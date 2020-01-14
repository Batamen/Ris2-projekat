package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mapa database table.
 * 
 */
@Entity
@NamedQuery(name="Mapa.findAll", query="SELECT m FROM Mapa m")
public class Mapa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMapa;

	@Lob
	private String path;

	//bi-directional many-to-one association to Staza
	@ManyToOne
	private Staza staza;

	public Mapa() {
	}

	public int getIdMapa() {
		return this.idMapa;
	}

	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Staza getStaza() {
		return this.staza;
	}

	public void setStaza(Staza staza) {
		this.staza = staza;
	}

}