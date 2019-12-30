package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the portalslika database table.
 * 
 */
@Entity
@NamedQuery(name="Portalslika.findAll", query="SELECT p FROM Portalslika p")
public class Portalslika implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPortalSlika;

	@Lob
	private String path;

	//bi-directional many-to-one association to Portal
	@ManyToOne
	private Portal portal;

	public Portalslika() {
	}

	public int getIdPortalSlika() {
		return this.idPortalSlika;
	}

	public void setIdPortalSlika(int idPortalSlika) {
		this.idPortalSlika = idPortalSlika;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Portal getPortal() {
		return this.portal;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}

}