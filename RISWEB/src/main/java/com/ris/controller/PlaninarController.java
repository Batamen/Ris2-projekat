package com.ris.controller;

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

import com.ris.repository.DomRepository;
import com.ris.repository.KomentarRepository;
import com.ris.repository.PlaninaRepository;
import com.ris.repository.PlaninarRepository;
import com.ris.repository.RezervacijaRepository;
import com.ris.repository.StazaRepository;
import com.ris.repository.ZnamenitostRepository;

import model.Dom;
import model.Komentar;
import model.Planina;
import model.Planinar;
import model.Rezervacija;
import model.Staza;
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
	DomRepository dr;
	
	@Autowired
	StazaRepository sr;
	
	@Autowired
	ZnamenitostRepository zr;
	
	@Autowired
	KomentarRepository kr;
	
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
	
	@RequestMapping(value = "/rezervisi", method = RequestMethod.GET)
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
}
