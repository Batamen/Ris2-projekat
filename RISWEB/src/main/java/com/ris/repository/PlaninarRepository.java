package com.ris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Planinar;

public interface PlaninarRepository extends JpaRepository<Planinar, Integer> {

	@Query("SELECT p FROM Planinar p WHERE p.ime=:ime and p.prezime=:prezime")
	public Planinar findByImePrezime(@Param("ime")String ime,@Param("prezime") String prezime);
}
