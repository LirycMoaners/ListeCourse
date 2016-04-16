package fr.cyril.course.dto;

import java.sql.Timestamp;

public class Product {
    public int id;
    public String name;
    public Timestamp creationDate;
    
	public Product() {
		super();
	}
	public Product(int id, String name, Timestamp creationDate) {
		super();
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
	}
	public Product(String name, Timestamp creationDate) {
		super();
		this.name = name;
		this.creationDate = creationDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
}
