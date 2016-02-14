package fr.cyril.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cyril.course.dto.Planning;

public class PlanningDB {
	private static String LIST_ADD = "Insert into planning (creationDate) values (?)";
	private static String LIST_GET_LIST = "Select * from planning";
	private static String LIST_GET_ID = "Select * from planning where id=?";
	private static String LIST_UPDATE = "Update planning set creationDate=? where id=?";
	private static String LIST_DELETE = "Delete from planning where id=?";
	private static Connection con;
	
	public static void savePlanning(Planning planning) throws DatabaseAccessError{
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LIST_ADD,Statement.RETURN_GENERATED_KEYS);
			stmt.setTimestamp(1, planning.getCreationDate());
			stmt.executeUpdate();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
            	planning.setId(generatedKeys.getInt(1));
            else
                throw new SQLException("Creating user failed, no ID obtained.");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			System.out.println("End of adding list");
		}
	}
	
	public static List<Planning> getListPlanning() throws DatabaseAccessError {
		List<Planning> p = new ArrayList<Planning>();
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LIST_GET_LIST);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p.add(new Planning(rs.getInt("id"), null, rs.getTimestamp("creationDate")));	
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of getting list of list");
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
				p = new Planning(id, LinePlanningDB.getLinePlanningList(id), rs.getTimestamp("creationDate"));	
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of getting list");
		}
		return p;
	}
	
	public static void updatePlanning(Planning planning) throws DatabaseAccessError {
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LIST_UPDATE,Statement.RETURN_GENERATED_KEYS);
			stmt.setTimestamp(1, planning.getCreationDate());
			stmt.setInt(2, planning.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of updating list");
			LinePlanningDB.updateListLinePlanning(planning.getLinePlanning(), planning.getId());
		}	
	}
	
	public static void deletePlanning(int id) throws DatabaseAccessError {
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LIST_DELETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of deleting list");
			LinePlanningDB.deleteListLinePlanning(id);
		}	
	}
}
