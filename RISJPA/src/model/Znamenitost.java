package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the znamenitost database table.
 * 
 */
@Entity
@NamedQuery(name="Znamenitost.findAll", query="SELECT z FROM Znamenitost z")
public class Znamenitost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZnamenitost;

	@Lob
	private String opis;

	@Lob
	private String tip;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="znamenitost")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Slikaznamenitost
	@OneToMany(mappedBy="znamenitost")
	private List<Slikaznamenitost> slikaznamenitosts;

	//bi-directional many-to-one association to Termin
	@OneToMany(mappedBy="znamenitost")
	private List<Termin> termins;

	//bi-directional many-to-one association to Staza
	@ManyToOne
	private Staza staza;

	public Znamenitost() {
	}

	public int getIdZnamenitost() {
		return this.idZnamenitost;
	}

	public void setIdZnamenitost(int idZnamenitost) {
		this.idZnamenitost = idZnamenitost;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getTip() {
		return this.tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setZnamenitost(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setZnamenitost(null);

		return komentar;
	}

	public List<Slikaznamenitost> getSlikaznamenitosts() {
		return this.slikaznamenitosts;
	}

	public void setSlikaznamenitosts(List<Slikaznamenitost> slikaznamenitosts) {
		this.slikaznamenitosts = slikaznamenitosts;
	}

	public Slikaznamenitost addSlikaznamenitost(Slikaznamenitost slikaznamenitost) {
		getSlikaznamenitosts().add(slikaznamenitost);
		slikaznamenitost.setZnamenitost(this);

		return slikaznamenitost;
	}

	public Slikaznamenitost removeSlikaznamenitost(Slikaznamenitost slikaznamenitost) {
		getSlikaznamenitosts().remove(slikaznamenitost);
		slikaznamenitost.setZnamenitost(null);

		return slikaznamenitost;
	}

	public List<Termin> getTermins() {
		return this.termins;
	}

	public void setTermins(List<Termin> termins) {
		this.termins = termins;
	}

	public Termin addTermin(Termin termin) {
		getTermins().add(termin);
		termin.setZnamenitost(this);

		return termin;
	}

	public Termin removeTermin(Termin termin) {
		getTermins().remove(termin);
		termin.setZnamenitost(null);

		return termin;
	}

	public Staza getStaza() {
		return this.staza;
	}

	public void setStaza(Staza staza) {
		this.staza = staza;
	}

}