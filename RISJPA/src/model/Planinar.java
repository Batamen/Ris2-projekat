package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * The persistent class for the planinar database table.
 * 
 */
@Entity
@NamedQuery(name="Planinar.findAll", query="SELECT p FROM Planinar p")
public class Planinar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPlaninar;

	@Lob
	private String clanskibroj;

	@Lob
	private String ime;

	private int novac;

	@Lob
	private String prezime;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="planinar", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Portal
	@OneToMany(mappedBy="planinar", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Portal> portals;

	//bi-directional many-to-one association to Rezervacija
	@OneToMany(mappedBy="planinar", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Rezervacija> rezervacijas;

	//bi-directional many-to-one association to Termin
	@OneToMany(mappedBy="planinar", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Termin> termins;

	public Planinar() {
	}

	public int getIdPlaninar() {
		return this.idPlaninar;
	}

	public void setIdPlaninar(int idPlaninar) {
		this.idPlaninar = idPlaninar;
	}

	public String getClanskibroj() {
		return this.clanskibroj;
	}

	public void setClanskibroj(String clanskibroj) {
		this.clanskibroj = clanskibroj;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getNovac() {
		return this.novac;
	}

	public void setNovac(int novac) {
		this.novac = novac;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setPlaninar(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setPlaninar(null);

		return komentar;
	}

	public List<Portal> getPortals() {
		return this.portals;
	}

	public void setPortals(List<Portal> portals) {
		this.portals = portals;
	}

	public Portal addPortal(Portal portal) {
		getPortals().add(portal);
		portal.setPlaninar(this);

		return portal;
	}

	public Portal removePortal(Portal portal) {
		getPortals().remove(portal);
		portal.setPlaninar(null);

		return portal;
	}

	public List<Rezervacija> getRezervacijas() {
		return this.rezervacijas;
	}

	public void setRezervacijas(List<Rezervacija> rezervacijas) {
		this.rezervacijas = rezervacijas;
	}

	public Rezervacija addRezervacija(Rezervacija rezervacija) {
		getRezervacijas().add(rezervacija);
		rezervacija.setPlaninar(this);

		return rezervacija;
	}

	public Rezervacija removeRezervacija(Rezervacija rezervacija) {
		getRezervacijas().remove(rezervacija);
		rezervacija.setPlaninar(null);

		return rezervacija;
	}

	public List<Termin> getTermins() {
		return this.termins;
	}

	public void setTermins(List<Termin> termins) {
		this.termins = termins;
	}

	public Termin addTermin(Termin termin) {
		getTermins().add(termin);
		termin.setPlaninar(this);

		return termin;
	}

	public Termin removeTermin(Termin termin) {
		getTermins().remove(termin);
		termin.setPlaninar(null);

		return termin;
	}

}