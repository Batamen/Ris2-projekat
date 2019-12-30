package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dom database table.
 * 
 */
@Entity
@NamedQuery(name="Dom.findAll", query="SELECT d FROM Dom d")
public class Dom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDom;

	@Lob
	private String mesto;

	@Lob
	private String naziv;

	private int slobodnaMesta;

	//bi-directional many-to-one association to Planina
	@ManyToOne
	@JoinColumn(name="idPlanina")
	private Planina planina;

	//bi-directional many-to-one association to Rezervacija
	@OneToMany(mappedBy="dom")
	private List<Rezervacija> rezervacijas;

	public Dom() {
	}

	public int getIdDom() {
		return this.idDom;
	}

	public void setIdDom(int idDom) {
		this.idDom = idDom;
	}

	public String getMesto() {
		return this.mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getSlobodnaMesta() {
		return this.slobodnaMesta;
	}

	public void setSlobodnaMesta(int slobodnaMesta) {
		this.slobodnaMesta = slobodnaMesta;
	}

	public Planina getPlanina() {
		return this.planina;
	}

	public void setPlanina(Planina planina) {
		this.planina = planina;
	}

	public List<Rezervacija> getRezervacijas() {
		return this.rezervacijas;
	}

	public void setRezervacijas(List<Rezervacija> rezervacijas) {
		this.rezervacijas = rezervacijas;
	}

	public Rezervacija addRezervacija(Rezervacija rezervacija) {
		getRezervacijas().add(rezervacija);
		rezervacija.setDom(this);

		return rezervacija;
	}

	public Rezervacija removeRezervacija(Rezervacija rezervacija) {
		getRezervacijas().remove(rezervacija);
		rezervacija.setDom(null);

		return rezervacija;
	}

}