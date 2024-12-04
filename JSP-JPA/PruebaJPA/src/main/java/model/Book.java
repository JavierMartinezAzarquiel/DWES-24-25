package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the BOOK database table.
 * 
 */
@Entity
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b order by b.id")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(length = 2000)
	private String description;

	private Boolean illustrations;

	private String isbn;

	private Integer nbofpage;

	private Float price;
	
	@Column(nullable = false)
	private String title;

	public Book() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIllustrations() {
		return this.illustrations;
	}

	public void setIllustrations(Boolean illustrations) {
		this.illustrations = illustrations;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNbofpage() {
		return this.nbofpage;
	}

	public void setNbofpage(Integer nbofpage) {
		this.nbofpage = nbofpage;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", description=" + description + ", illustrations=" + illustrations + ", isbn=" + isbn
				+ ", nbofpage=" + nbofpage + ", price=" + price + ", title=" + title + "]";
	}
	

}