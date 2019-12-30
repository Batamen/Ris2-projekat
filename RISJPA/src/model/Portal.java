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
	private int idPortal;

	@Lob
	private String iskustva;

	//bi-directional many-to-one association to Planina
	@ManyToOne
	@JoinColumn(name="idPlanina")
	private Planina planina;

	//bi-directional many-to-one association to Planinar
	@ManyToOne
	@JoinColumn(name="idPlaninar")
	private Planinar planinar;

	//bi-directional many-to-one association to Portalslika
	@OneToMany(mappedBy="portal")
	private List<Portalslika> portalslikas;

	public Portal() {
	}

	public int getIdPortal() {
		return this.idPortal;
	}

	public void setIdPortal(int idPortal) {
		this.idPortal = idPortal;
	}

	public String getIskustva() {
		return this.iskustva;
	}

	public void setIskustva(String iskustva) {
		this.iskustva = iskustva;
	}

	public Planina getPlanina() {
		return this.planina;
	}

	public void setPlanina(Planina planina) {
		this.planina = planina;
	}

	public Planinar getPlaninar() {
		return this.planinar;
	}

	public void setPlaninar(Planinar planinar) {
		this.planinar = planinar;
	}

	public List<Portalslika> getPortalslikas() {
		return this.portalslikas;
	}

	public void setPortalslikas(List<Portalslika> portalslikas) {
		this.portalslikas = portalslikas;
	}

	public Portalslika addPortalslika(Portalslika portalslika) {
		getPortalslikas().add(portalslika);
		portalslika.setPortal(this);

		return portalslika;
	}

	public Portalslika removePortalslika(Portalslika portalslika) {
		getPortalslikas().remove(portalslika);
		portalslika.setPortal(null);

		return portalslika;
	}

}