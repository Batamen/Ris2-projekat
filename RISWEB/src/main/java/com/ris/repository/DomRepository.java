package com.ris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Dom;
import model.Planina;

public interface DomRepository extends JpaRepository<Dom, Integer>,DomRepo {
	List<Dom> findByPlanina(Planina p);
}
