package com.ris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Planinar;
import model.Rezervacija;

public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer> {
	List<Rezervacija> findByPlaninar(Planinar p);
}
