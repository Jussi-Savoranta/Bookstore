package com.jussi.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	public String title, author, bookYear, isbn;
	public double price;
	
	public Book() {}
	
	public Book(String title, String author, String bookYear, String isbn, int price) {
		super();
		this.title = title;
		this.author = author;
		this.bookYear = bookYear;
		this.isbn = isbn;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	public String getBookYear() {
		return bookYear;
	}
	public void setBookYear(String bookYear) {
		this.bookYear = bookYear;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", bookYear=" + bookYear + ", isbn="
				+ isbn + ", price=" + price + "]";
	}
	
	
}
