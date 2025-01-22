package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the IMAGES database table.
 * 
 */
@Entity
@Table(name="IMAGES")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	//bi-directional many-to-one association to Playa
	@ManyToOne
	@JoinColumn(name="PLAYA")
	private Playa playaBean;

	public Image() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Playa getPlayaBean() {
		return this.playaBean;
	}

	public void setPlayaBean(Playa playaBean) {
		this.playaBean = playaBean;
	}

}