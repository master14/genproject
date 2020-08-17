package com.gen.Library.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "books")
public class Books {

    @Id
    @Column
    private String id = "";
    @Column
    private String title = "";
    @Column
    private String author = "";
    @Column
    private String type = "";
    @Column
    private double price = 0;
    @Column
    private int numOfPages = 0;
    @Column
    private String language = "";
    @Column
    private String isbn13 = "";
    @Column
    private Date createOn = new Date();

    public Books() {
    }

    public Books(String id, String title, String author, String type, double price, int numOfPages, String language, String isbn13,Date createOn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.type = type;
        this.price = price;
        this.numOfPages = numOfPages;
        this.language = language;
        this.isbn13 = isbn13;
        this.createOn = createOn;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumOfPages() {
		return numOfPages;
	}

	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
    
	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author=" + author + ", type=" + type + ", price=" + price
				+ ", numOfPages=" + numOfPages + ", language=" + language + ", isbn13=" + isbn13 + "]";
	}
    
}