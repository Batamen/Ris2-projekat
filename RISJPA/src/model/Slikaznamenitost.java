package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the slikaznamenitost database table.
 * 
 */
@Entity
@NamedQuery(name="Slikaznamenitost.findAll", query="SELECT s FROM Slikaznamenitost s")
public class Slikaznamenitost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSlikaZnamenitost;

	@Lob
	private String path;

	//bi-directional many-to-one association to Znamenitost
	@ManyToOne
	private Znamenitost znamenitost;

	public Slikaznamenitost() {
	}

	public int getIdSlikaZnamenitost() {
		return this.idSlikaZnamenitost;
	}

	public void setIdSlikaZnamenitost(int idSlikaZnamenitost) {
		this.idSlikaZnamenitost = idSlikaZnamenitost;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Znamenitost getZnamenitost() {
		return this.znamenitost;
	}

	public void setZnamenitost(Znamenitost znamenitost) {
		this.znamenitost = znamenitost;
	}

}