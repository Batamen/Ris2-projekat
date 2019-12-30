package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the poseta database table.
 * 
 */
@Entity
@NamedQuery(name="Poseta.findAll", query="SELECT p FROM Poseta p")
public class Poseta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPoseta;

	@Temporal(TemporalType.DATE)
	private Date datum;

	//bi-directional many-to-one association to Planinar
	@ManyToOne
	@JoinColumn(name="idPlaninar")
	private Planinar planinar;

	//bi-directional many-to-one association to Znamenitost
	@ManyToOne
	@JoinColumn(name="idZnamenitosti")
	private Znamenitost znamenitost;

	public Poseta() {
	}

	public int getIdPoseta() {
		return this.idPoseta;
	}

	public void setIdPoseta(int idPoseta) {
		this.idPoseta = idPoseta;
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