package com.ssafy.happyhouse.dto;

public class Board {
	int isbn;
	String author;
	String title;
	String content;
	String writtendate;
	int hit;
	
	public Board(int isbn, String author, String title, String content, String writtendate, int hit) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.content = content;
		this.writtendate = writtendate;
		this.hit = hit;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWrittendate() {
		return writtendate;
	}

	public void setWrittendate(String writtendate) {
		this.writtendate = writtendate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
}
