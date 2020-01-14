package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the portal database table.
 * 
 */
@Entity
@NamedQuery(name="Portal.findAll", query="SELECT p FROM Portal p")
public class Portal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIkustva;

	@Lob
	private String iskustva;

	//bi-directional many-to-one association to Planinar
	@ManyToOne
	private Planinar planinar;

	//bi-directional many-to-one association to Slikeportal
	@OneToMany(mappedBy="portal")
	private List<Slikeportal> slikeportals;

	public Portal() {
	}

	public int getIdIkustva() {
		return this.idIkustva;
	}

	public void setIdIkustva(int idIkustva) {
		this.idIkustva = idIkustva;
	}

	public String getIskustva() {
		return this.iskustva;
	}

	public void setIskustva(String iskustva) {
		this.iskustva = iskustva;
	}

	public Planinar getPlaninar() {
		return this.planinar;
	}

	public void setPlaninar(Planinar planinar) {
		this.planinar = planinar;
	}

	public List<Slikeportal> getSlikeportals() {
		return this.slikeportals;
	}

	public void setSlikeportals(List<Slikeportal> slikeportals) {
		this.slikeportals = slikeportals;
	}

	public Slikeportal addSlikeportal(Slikeportal slikeportal) {
		getSlikeportals().add(slikeportal);
		slikeportal.setPortal(this);

		return slikeportal;
	}

	public Slikeportal removeSlikeportal(Slikeportal slikeportal) {
		getSlikeportals().remove(slikeportal);
		slikeportal.setPortal(null);

		return slikeportal;
	}

}