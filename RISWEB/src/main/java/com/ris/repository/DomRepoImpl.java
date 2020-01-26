package com.ris.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Dom;

@Repository
@Transactional
public class DomRepoImpl implements DomRepo{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public boolean updateDom(Dom d) {
		int n=em.createQuery("UPDATE Dom SET kapacitet= :kapacitet where IdDom = :idDom").setParameter("kapacitet", d.getKapacitet()-1)
			.setParameter("idDom", d.getIdDom()).executeUpdate();
		if (n == 0)
			return false;
		else
			return true;
	}
}
