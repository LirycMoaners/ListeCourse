package fr.cyril.course.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.cyril.course.dto.Planning;

public class PlanningDB {
	private static String LIST_ADD = "Insert into planning (creationDate) values (?)";
	private static String LIST_GET_LIST = "Select * from planning";
	private static String LIST_GET_ID = "Select * from planning where id=?";
	private static String LIST_UPDATE = "Update planning set creationDate=? where id=?";
	private static Connection con;
	
	public static void savePlanning(Planning planning) throws DatabaseAccessError{
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LIST_ADD);
			stmt.setDate(1, (Date) planning.getCreationDate());
			stmt.executeUpdate();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
            	planning.setId(generatedKeys.getInt(1));
            else
                throw new SQLException("Creating user failed, no ID obtained.");
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				DBManager.dropConnection();
				System.out.println("End of adding list");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static List<Planning> getListPlanning() throws DatabaseAccessError {
		List<Planning> p = null;
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LIST_GET_LIST);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p.add(new Planning(rs.getInt("id"), null, rs.getDate("creationDate")));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.dropConnection();
				System.out.println("End of getting list of list");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static Planning getPlanning(int id) throws DatabaseAccessError{
		Planning p = null;
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LIST_GET_ID);
			stmt.setInt(1, id);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p = new Planning(id, LinePlanningDB.getLinePlanningList(id), rs.getDate("creationDate"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.dropConnection();
				System.out.println("End of getting list");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static void updatePlanning(Planning planning) throws DatabaseAccessError {
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LIST_UPDATE);
			stmt.setDate(1, (Date) planning.getCreationDate());
			stmt.setInt(2, planning.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.dropConnection();
				System.out.println("End of updating list");
				LinePlanningDB.updateListLinePlanning(planning.getLinePlanning(), planning.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
}
