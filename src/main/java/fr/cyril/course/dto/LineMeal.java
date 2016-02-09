package fr.cyril.course.dto;

import java.util.Date;

public class LineMeal {
    public int id;
    public int quantity;
    public Date creationDate;
    public Product product;
    
	public LineMeal() {
		super();
	}
	public LineMeal(int id, int quantity, Date creationDate, Product product) {
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
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

    
}
