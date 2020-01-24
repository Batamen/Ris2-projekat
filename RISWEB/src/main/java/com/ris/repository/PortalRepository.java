package com.ris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Planinar;
import model.Portal;

public interface PortalRepository extends JpaRepository<Portal, Integer> {
	List<Portal> findByPlaninar(Planinar p);
}
