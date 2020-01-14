package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the slikeportal database table.
 * 
 */
@Entity
@NamedQuery(name="Slikeportal.findAll", query="SELECT s FROM Slikeportal s")
public class Slikeportal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSlikePortal;

	@Lob
	private String path;

	//bi-directional many-to-one association to Portal
	@ManyToOne
	private Portal portal;

	public Slikeportal() {
	}

	public int getIdSlikePortal() {
		return this.idSlikePortal;
	}

	public void setIdSlikePortal(int idSlikePortal) {
		this.idSlikePortal = idSlikePortal;
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