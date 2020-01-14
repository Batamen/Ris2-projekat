package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the staza database table.
 * 
 */
@Entity
@NamedQuery(name="Staza.findAll", query="SELECT s FROM Staza s")
public class Staza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStaza;

	@Lob
	private String opis;

	@Lob
	private String tezina;

	//bi-directional many-to-one association to Mapa
	@OneToMany(mappedBy="staza")
	private List<Mapa> mapas;

	//bi-directional many-to-one association to Planina
	@ManyToOne
	private Planina planina;

	//bi-directional many-to-one association to Znamenitost
	@OneToMany(mappedBy="staza")
	private List<Znamenitost> znamenitosts;

	public Staza() {
	}

	public int getIdStaza() {
		return this.idStaza;
	}

	public void setIdStaza(int idStaza) {
		this.idStaza = idStaza;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getTezina() {
		return this.tezina;
	}

	public void setTezina(String tezina) {
		this.tezina = tezina;
	}

	public List<Mapa> getMapas() {
		return this.mapas;
	}

	public void setMapas(List<Mapa> mapas) {
		this.mapas = mapas;
	}

	public Mapa addMapa(Mapa mapa) {
		getMapas().add(mapa);
		mapa.setStaza(this);

		return mapa;
	}

	public Mapa removeMapa(Mapa mapa) {
		getMapas().remove(mapa);
		mapa.setStaza(null);

		return mapa;
	}

	public Planina getPlanina() {
		return this.planina;
	}

	public void setPlanina(Planina planina) {
		this.planina = planina;
	}

	public List<Znamenitost> getZnamenitosts() {
		return this.znamenitosts;
	}

	public void setZnamenitosts(List<Znamenitost> znamenitosts) {
		this.znamenitosts = znamenitosts;
	}

	public Znamenitost addZnamenitost(Znamenitost znamenitost) {
		getZnamenitosts().add(znamenitost);
		znamenitost.setStaza(this);

		return znamenitost;
	}

	public Znamenitost removeZnamenitost(Znamenitost znamenitost) {
		getZnamenitosts().remove(znamenitost);
		znamenitost.setStaza(null);

		return znamenitost;
	}

}