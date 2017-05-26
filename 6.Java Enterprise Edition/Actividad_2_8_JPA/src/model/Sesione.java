package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sesiones database table.
 * 
 */
@Entity
@Table(name="sesiones")
@NamedQuery(name="Sesione.findAll", query="SELECT s FROM Sesione s")
public class Sesione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private int n;

	public Sesione() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getN() {
		return this.n;
	}

	public void setN(int n) {
		this.n = n;
	}

}