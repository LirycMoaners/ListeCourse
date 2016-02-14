package fr.cyril.course.dto;

import java.sql.Timestamp;
import java.util.List;

public class Meal {
    public int id;
    public String name;
    public List<LineMeal> lineMeal;
    public Timestamp creationDate;
    
	public Meal() {
		super();
	}
	public Meal(int id, String name, List<LineMeal> lineMeal, Timestamp creationDate) {
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
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
}
