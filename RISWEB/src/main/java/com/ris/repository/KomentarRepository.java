package com.ris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Komentar;

public interface KomentarRepository extends JpaRepository<Komentar, Integer> {

}
