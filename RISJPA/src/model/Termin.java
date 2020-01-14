package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the termin database table.
 * 
 */
@Entity
@NamedQuery(name="Termin.findAll", query="SELECT t FROM Termin t")
public class Termin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTermin;

	@Temporal(TemporalType.DATE)
	private Date datum;

	//bi-directional many-to-one association to Planinar
	@ManyToOne
	private Planinar planinar;

	//bi-directional many-to-one association to Znamenitost
	@ManyToOne
	private Znamenitost znamenitost;

	public Termin() {
	}

	public int getIdTermin() {
		return this.idTermin;
	}

	public void setIdTermin(int idTermin) {
		this.idTermin = idTermin;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Planinar getPlaninar() {
		return this.planinar;
	}

	public void setPlaninar(Planinar planinar) {
		this.planinar = planinar;
	}

	public Znamenitost getZnamenitost() {
		return this.znamenitost;
	}

	public void setZnamenitost(Znamenitost znamenitost) {
		this.znamenitost = znamenitost;
	}

}