package fr.cyril.course.dto;

import java.sql.Timestamp;

public class LinePlanning {
	private int id;
	private String day;
	private String moment;
	private Meal meal;
	private int nbPersonne;
	private Timestamp creationDate;
	
	public LinePlanning(int id, String day, String moment, Meal meal,
			int nbPersonne, Timestamp creationDate) {
		super();
		this.id = id;
		this.day = day;
		this.moment = moment;
		this.meal = meal;
		this.nbPersonne = nbPersonne;
		this.creationDate = creationDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMoment() {
		return moment;
	}
	public void setMoment(String moment) {
		this.moment = moment;
	}
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	public int getNbPersonne() {
		return nbPersonne;
	}
	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
}
