package fr.cyril.course.dto;

import java.sql.Timestamp;
import java.util.List;

public class Planning {
    public int id;
    public List<LinePlanning> linePlanning;
    public Timestamp creationDate;
    
	public Planning() {
		super();
	}
	public Planning(Timestamp creationDate) {
		super();
		this.creationDate = creationDate;
	}
	public Planning(int id, List<LinePlanning> linePlanning, Timestamp creationDate) {
		super();
		this.id = id;
		this.linePlanning = linePlanning;
		this.creationDate = creationDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<LinePlanning> getLinePlanning() {
		return linePlanning;
	}
	public void setLinePlanning(List<LinePlanning> linePlanning) {
		this.linePlanning = linePlanning;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
}
