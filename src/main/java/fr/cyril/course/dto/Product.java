package fr.cyril.course.dto;

import java.util.Date;

public class Product {
    public int id;
    public String name;
    public boolean comptable;
    public Date creationDate;
    
	public Product() {
		super();
	}
	public Product(int id, String name, boolean comptable, Date creationDate) {
		super();
		this.id = id;
		this.name = name;
		this.comptable = comptable;
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
	public boolean isComptable() {
		return comptable;
	}
	public void setComptable(boolean comptable) {
		this.comptable = comptable;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
