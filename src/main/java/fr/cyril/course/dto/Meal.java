package fr.cyril.course.dto;

import java.util.Date;
import java.util.List;

public class Meal {
    public int id;
    public String name;
    public List<LineMeal> lineMeal;
    public Date creationDate;
    
	public Meal() {
		super();
	}
	public Meal(int id, String name, List<LineMeal> lineMeal, Date creationDate) {
		super();
		this.id = id;
		this.name = name;
		this.lineMeal = lineMeal;
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
	public List<LineMeal> getLineMeal() {
		return lineMeal;
	}
	public void setLineMeal(List<LineMeal> lineMeal) {
		this.lineMeal = lineMeal;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
