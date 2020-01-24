package com.ris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Staza;
import model.Znamenitost;

public interface ZnamenitostRepository extends JpaRepository<Znamenitost, Integer> {
	List<Znamenitost> findByStaza(Staza s);
}
