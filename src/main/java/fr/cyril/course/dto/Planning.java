package fr.cyril.course.dto;

import java.util.Date;
import java.util.List;

public class Planning {
    public int id;
    public List<LinePlanning> linePlanning;
    public Date creationDate;
    
	public Planning() {
		super();
	}
	public Planning(int id, List<LinePlanning> linePlanning, Date creationDate) {
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
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
