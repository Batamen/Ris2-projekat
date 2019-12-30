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
	private int idZnamenitosti;

	@Lob
	private String komentari;

	@Lob
	private String opis;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="znamenitost")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Poseta
	@OneToMany(mappedBy="znamenitost")
	private List<Poseta> posetas;

	//bi-directional many-to-one association to Slikaznamenitost
	@OneToMany(mappedBy="znamenitost")
	private List<Slikaznamenitost> slikaznamenitosts;

	//bi-directional many-to-one association to Staza
	@ManyToOne
	@JoinColumn(name="idStaza")
	private Staza staza;

	public Znamenitost() {
	}

	public int getIdZnamenitosti() {
		return this.idZnamenitosti;
	}

	public void setIdZnamenitosti(int idZnamenitosti) {
		this.idZnamenitosti = idZnamenitosti;
	}

	public String getKomentari() {
		return this.komentari;
	}

	public void setKomentari(String komentari) {
		this.komentari = komentari;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
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

	public List<Poseta> getPosetas() {
		return this.posetas;
	}

	public void setPosetas(List<Poseta> posetas) {
		this.posetas = posetas;
	}

	public Poseta addPoseta(Poseta poseta) {
		getPosetas().add(poseta);
		poseta.setZnamenitost(this);

		return poseta;
	}

	public Poseta removePoseta(Poseta poseta) {
		getPosetas().remove(poseta);
		poseta.setZnamenitost(null);

		return poseta;
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

	public Staza getStaza() {
		return this.staza;
	}

	public void setStaza(Staza staza) {
		this.staza = staza;
	}

}