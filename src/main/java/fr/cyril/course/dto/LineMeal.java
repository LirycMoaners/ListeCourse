package fr.cyril.course.dto;

import java.sql.Timestamp;

public class LineMeal {
    public int id;
    public int quantity;
    public Timestamp creationDate;
    public Product product;
    
	public LineMeal() {
		super();
	}
	public LineMeal(int id, int quantity, Timestamp creationDate, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.creationDate = creationDate;
		this.product = product;
	}
	public LineMeal(int quantity, Timestamp creationDate, Product product) {
		super();
		this.quantity = quantity;
		this.creationDate = creationDate;
		this.product = product;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
