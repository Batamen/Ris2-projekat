package com.ris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Planina;
import model.Staza;

public interface StazaRepository extends JpaRepository<Staza, Integer> {
	List<Staza> findByPlanina(Planina p);
}
