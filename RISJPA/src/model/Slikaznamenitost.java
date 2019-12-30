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
	private int idSlika;

	@Lob
	private String path;

	//bi-directional many-to-one association to Znamenitost
	@ManyToOne
	@JoinColumn(name="idZnamenitost")
	private Znamenitost znamenitost;

	public Slikaznamenitost() {
	}

	public int getIdSlika() {
		return this.idSlika;
	}

	public void setIdSlika(int idSlika) {
		this.idSlika = idSlika;
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