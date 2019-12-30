package com.ris.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ris.repository.PlaninarRepository;

import model.Planinar;

@Controller
@RequestMapping(value="/PlaninarController")
public class PlaninarController {
	
	@Autowired
	PlaninarRepository pr;
	
	@RequestMapping(value="/logPlaninar", method = RequestMethod.POST)
	public String addPlaninar(String ime, String prezime, HttpServletRequest request,Model m) {
		
		Planinar p = pr.findByImePrezime(ime, prezime);
		if(p==null) {
			m.addAttribute("poruka", "Ne postoji dati korisnik");
			return "index";
		}
		request.getSession().setAttribute("planinar", p);
		
		return "planinar/firstpage";
	}
	
	@RequestMapping(value="/Planinar", method = RequestMethod.GET)
	public String addPlaninar() {
		
		return "planinar/druga";
	}
	@RequestMapping(value="/Planinarl", method = RequestMethod.GET)
	public String addPlaninarl(HttpSession session) {
		session.invalidate();
		return "planinar/druga";
	}
}
