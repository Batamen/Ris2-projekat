package com.ris.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ris.repository.DomRepository;
import com.ris.repository.PlaninaRepository;
import com.ris.repository.PlaninarRepository;

import model.Dom;
import model.Planina;
import model.Planinar;

@Controller
@RequestMapping(value="/PlaninarController")
public class PlaninarController {
	
	@Autowired
	PlaninarRepository pr;
	
	@Autowired
	PlaninaRepository plr;
	
	@Autowired
	DomRepository dr;
	
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
}
