package com.ris.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ris.repository.DomRepository;
import com.ris.repository.KomentarRepository;
import com.ris.repository.PlaninaRepository;
import com.ris.repository.PlaninarRepository;
import com.ris.repository.PortalRepository;
import com.ris.repository.PortalSlikaRepository;
import com.ris.repository.RezervacijaRepository;
import com.ris.repository.StazaRepository;
import com.ris.repository.TerminRepository;
import com.ris.repository.ZnamenitostRepository;

import model.Dom;
import model.Komentar;
import model.Planina;
import model.Planinar;
import model.Portal;
import model.Rezervacija;
import model.Slikeportal;
import model.Staza;
import model.Termin;
import model.Znamenitost;

@Controller
@RequestMapping(value="/PlaninarController")
public class PlaninarController {
	
	@Autowired
	RezervacijaRepository rr;
	
	@Autowired
	PlaninarRepository pr;
	
	@Autowired
	PlaninaRepository plr;
	
	@Autowired
	TerminRepository tr;
	
	@Autowired
	DomRepository dr;
	
	@Autowired
	PortalSlikaRepository psr;
	
	@Autowired
	StazaRepository sr;
	
	@Autowired
	ZnamenitostRepository zr;
	
	@Autowired
	KomentarRepository kr;
	
	@Autowired
	PortalRepository porr;
	
	@RequestMapping(value="/logPlaninar", method = RequestMethod.POST)
	public String addPlaninar(String ime, String clanskibroj, HttpServletRequest request,Model m) {
		
		Planinar p = pr.findByImeClanskiBr(ime, clanskibroj);
		if(p==null) {
			m.addAttribute("poruka", "Ne postoji dati korisnik");
			return "index";
		}
		request.getSession().setAttribute("planinar", p);
		
		return "planinar/firstpage";
	}
	
	@RequestMapping(value="/getPlanine", method = RequestMethod.GET)
	public String getPlanine(HttpServletRequest request) {
		List<Planina> planine = plr.findAll();
		
		request.getSession().setAttribute("planine", planine);

		return "planinar/planine";
	}
	
	@RequestMapping(value = "/getDomoviPlanine", method = RequestMethod.GET)
	public String getDomPlanine(String planina, HttpServletRequest request, Model m) {
		Integer idDom = Integer.parseInt(planina);
		
		Planina p = plr.findById(idDom).get();
		
		List<Dom> domovi = dr.findByPlanina(p);
		
		request.getSession().setAttribute("domovi", domovi);
		request.getSession().setAttribute("planina", p);
		
		m.addAttribute("poruka", "planine " + p.getIme());
		
		return "planinar/domoviPlanine";
	}
	
	@RequestMapping(value = "/reservationPage", method = RequestMethod.GET)
	public String getRezervisiPage(String dom, HttpServletRequest request) {
		Dom d = dr.findById(Integer.parseInt(dom)).get();
		request.getSession().setAttribute("dom", d);
		return "planinar/rezervacija";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(value = "/rezervisi", method = RequestMethod.POST)
	public String rezervisi(Date datum, HttpServletRequest request, Model m) {
		Dom d= (Dom) request.getSession().getAttribute("dom");
		Planinar p = (Planinar) request.getSession().getAttribute("planinar");
		Rezervacija rezervacija = new Rezervacija();
		rezervacija.setDatum(datum);
		rezervacija.setPlaninar(p);
		rezervacija.setDom(d);
		Rezervacija proba = rr.save(rezervacija);
		p.getRezervacijas().add(rezervacija);
		if(proba != null) {
			m.addAttribute("poruka", "Rezervisali ste mesto za dom u terminu:" + rezervacija.getDatum());
			request.getSession().setAttribute("planinar", p);
		} else {
			m.addAttribute("poruka", "Nije uspesna rezervacija");
		}
		return "planinar/firstpage";
	}

	
	@RequestMapping(value= "/getProfil", method= RequestMethod.GET)
	public String getProfil(HttpServletRequest request) {
		return "planinar/profil";
	}
	@RequestMapping(value= "/ukloni", method= RequestMethod.GET)
	public String ukloniR(HttpServletRequest request, String rezervacija) {
		Rezervacija r = rr.findById(Integer.parseInt(rezervacija)).get();
		rr.delete(r);
		Planinar p = (Planinar) request.getSession().getAttribute("planinar");
		p.setRezervacijas(rr.findByPlaninar(p));
		request.getSession().setAttribute("planinar", p);
		return "planinar/profil";
	}
	@RequestMapping(value="/getStazePlanine", method = RequestMethod.GET)
	public String getStazePlanine(String planina, HttpServletRequest request) {
		Planina p = plr.findById(Integer.parseInt(planina)).get();
		List<Staza> staze = sr.findByPlanina(p);
		request.getSession().setAttribute("planina", p);
		request.getSession().setAttribute("staze", staze);
		return "planinar/staze";
	}
	
	@RequestMapping(value="/getZnamenitosti", method = RequestMethod.GET)
	public String getZnamenitosti(String staza, HttpServletRequest request) {
		Staza s = sr.findById(Integer.parseInt(staza)).get();
		List<Znamenitost> znamenitosti = zr.findByStaza(s);
		request.getSession().setAttribute("znamenitosti", znamenitosti);
		
		return "planinar/znamenitosti";
	}
	@RequestMapping(value="/komentarisi", method = RequestMethod.POST)
	public String komentarisi(String komentar,String znamenitost,String staza, HttpServletRequest request) {
		Komentar k = new Komentar();
		Znamenitost z = zr.findById(Integer.parseInt(znamenitost)).get();
		k.setOpis(komentar);
		k.setPlaninar((Planinar)request.getSession().getAttribute("planinar"));
		k.setZnamenitost(z);
		kr.save(k);
		Staza s = sr.findById(Integer.parseInt(staza)).get();
		List<Znamenitost> znamenitosti = zr.findByStaza(s);
		request.getSession().setAttribute("znamenitosti", znamenitosti);
		
		return "planinar/znamenitosti";
	}
	@RequestMapping(value = "/reservationTermin", method = RequestMethod.GET)
	public String getRezervisiTermin(String znamenitost, HttpServletRequest request) {
		Znamenitost z = zr.findById(Integer.parseInt(znamenitost)).get();
		request.getSession().setAttribute("znamenitost", z);
		return "planinar/rezervacijaZnamenitost";
	}
	
	@RequestMapping(value="/rezervisiZ", method = RequestMethod.POST)
	public String rezervisiZ(HttpServletRequest request, Date datum) {
		Znamenitost z = (Znamenitost) request.getSession().getAttribute("znamenitost");
		Planinar p = (Planinar) request.getSession().getAttribute("planinar");
		Termin termin = new Termin();
		termin.setDatum(datum);
		termin.setPlaninar(p);
		termin.setZnamenitost(z);
		tr.save(termin);
		return "planinar/firstpage";
	}
	@RequestMapping(value="/getPlaninari", method = RequestMethod.GET)
	public String getPlaninari(HttpServletRequest request) {
		List<Planinar> planinari = pr.findAll();
		request.getSession().setAttribute("planinari",planinari);
		return "planinar/planinari";
	}
	@RequestMapping(value="/getPortal", method = RequestMethod.GET)
	public String getPortal(HttpServletRequest request, String planinar) {
		Planinar p = pr.findById(Integer.parseInt(planinar)).get();
		List<Portal> portali = porr.findByPlaninar(p);
		request.getSession().setAttribute("portali", portali);
		return "planinar/portal";
	}
	
	@RequestMapping(value="/sacuvajPortal", method = RequestMethod.POST)
	public String sacuvajPortal(HttpServletRequest request, String tekst, Model m, @RequestParam("picture") MultipartFile picture) {
		Planinar p = (Planinar) request.getSession().getAttribute("planinar");
		Path fileNameAndPath = Paths.get("src/main/webapp/slike",picture.getOriginalFilename());
		try {
			Files.write(fileNameAndPath,picture.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Portal po = new Portal();
		po.setIskustva(tekst);
		po.setPlaninar(p);
		Slikeportal slikeportal = new Slikeportal();
		slikeportal.setPath("../slike/"+picture.getOriginalFilename());
		slikeportal.setPortal(po);
		
		porr.save(po);
		psr.save(slikeportal);
		po.getSlikeportals().add(slikeportal);
		p.getPortals().add(po);
		request.getSession().setAttribute("planinar", p);
		List<Portal> portali = porr.findByPlaninar(p);
		request.getSession().setAttribute("portali", portali);
		return "planinar/portal";
	}
	
}
