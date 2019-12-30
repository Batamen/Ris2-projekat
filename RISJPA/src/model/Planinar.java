package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private String ime;

	@Lob
	private String prezime;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="planinar")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Portal
	@OneToMany(mappedBy="planinar")
	private List<Portal> portals;

	//bi-directional many-to-one association to Poseta
	@OneToMany(mappedBy="planinar")
	private List<Poseta> posetas;

	//bi-directional many-to-one association to Rezervacija
	@OneToMany(mappedBy="planinar")
	private List<Rezervacija> rezervacijas;

	public Planinar() {
	}

	public int getIdPlaninar() {
		return this.idPlaninar;
	}

	public void setIdPlaninar(int idPlaninar) {
		this.idPlaninar = idPlaninar;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
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

	public List<Poseta> getPosetas() {
		return this.posetas;
	}

	public void setPosetas(List<Poseta> posetas) {
		this.posetas = posetas;
	}

	public Poseta addPoseta(Poseta poseta) {
		getPosetas().add(poseta);
		poseta.setPlaninar(this);

		return poseta;
	}

	public Poseta removePoseta(Poseta poseta) {
		getPosetas().remove(poseta);
		poseta.setPlaninar(null);

		return poseta;
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

}