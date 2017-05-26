package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the peticiones database table.
 * 
 */
@Entity
@Table(name="peticiones")
@NamedQuery(name="Peticione.findAll", query="SELECT p FROM Peticione p")
public class Peticione implements Serializable {//Serializable = implementa beans
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int n;

	public Peticione() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getN() {
		return this.n;
	}

	public void setN(int n) {
		this.n = n;
	}

}