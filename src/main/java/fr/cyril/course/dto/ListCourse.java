package fr.cyril.course.dto;

import java.util.Date;
import java.util.List;

public class ListCourse {
    public int id;
    public List<LineList> lineList;
    public Date creationDate;
    
	public ListCourse() {
		super();
	}
	public ListCourse(int id, List<LineList> lineList, Date creationDate) {
		super();
		this.id = id;
		this.lineList = lineList;
		this.creationDate = creationDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<LineList> getLineList() {
		return lineList;
	}
	public void setLineList(List<LineList> lineList) {
		this.lineList = lineList;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
