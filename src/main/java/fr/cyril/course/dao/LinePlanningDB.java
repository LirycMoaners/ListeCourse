package fr.cyril.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cyril.course.dto.LinePlanning;

public class LinePlanningDB {
	private static String LINEPLANNING_ADD = "Insert into linePlanning (idPlanning,day,moment,idMeal,nbPersonne,creationDate) values (?,?,?,?,?,?)";
	private static String LINEPLANNING_GET_LIST_DAY = "Select * from linePlanning where idPlanning=? and day=? and moment=?";
	private static String LINEPLANNING_GET_LIST = "Select * from linePlanning where idPlanning=?";
	private static String LINEPLANNING_GET_ID = "Select * from linePlanning where id=?";
	private static String LINEPLANNING_UPDATE = "Update linePlanning set idPlanning=?,day=?,moment=?,idMeal=?,nbPersonne=?,creationDate=? where id=?";
	private static String LINEPLANNING_DELETE_LIST_DAY = "Delete from linePlanning where idPlanning=? and day=? and moment=?";
	private static String LINEPLANNING_DELETE_LIST = "Delete from linePlanning where idPlanning=?";
	private static Connection con;
	
	public static void saveLinePlanning(LinePlanning linePlanning, int idPlanning) throws DatabaseAccessError{
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEPLANNING_ADD,Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, idPlanning);
			stmt.setString(2, linePlanning.getDay());
			stmt.setString(3, linePlanning.getMoment());
			stmt.setInt(4, linePlanning.getMeal().getId());
			stmt.setInt(5, linePlanning.getNbPersonne());
			stmt.setTimestamp(6, linePlanning.getCreationDate());
			stmt.executeUpdate();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
            	linePlanning.setId(generatedKeys.getInt(1));
            else
                throw new SQLException("Creating user failed, no ID obtained.");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			System.out.println("End of adding linePlanning");
		}
	}
	
	public static void saveListLinePlanning(List<LinePlanning> linePlannings, int idPlanning) throws DatabaseAccessError{
		for(LinePlanning linePlanning : linePlannings)
			saveLinePlanning(linePlanning, idPlanning);
	}
	
	public static List<LinePlanning> getLinePlanningListDay(int idPlanning, String day, String moment) throws DatabaseAccessError {
		List<LinePlanning> p = new ArrayList<LinePlanning>();
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEPLANNING_GET_LIST_DAY);
			stmt.setInt(1, idPlanning);
			stmt.setString(2, day);
			stmt.setString(3, moment);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p.add(new LinePlanning(rs.getInt("id"), rs.getString("day"), rs.getString("moment"), MealDB.getMeal(rs.getInt("idMeal")), rs.getInt("nbPersonne"), rs.getTimestamp("creationDate")));	
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of getting list of linePlanning");
		}
		return p;
	}
	
	public static List<LinePlanning> getLinePlanningList(int idPlanning) throws DatabaseAccessError {
		List<LinePlanning> p = new ArrayList<LinePlanning>();
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEPLANNING_GET_LIST);
			stmt.setInt(1, idPlanning);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p.add(new LinePlanning(rs.getInt("id"), rs.getString("day"), rs.getString("moment"), MealDB.getMeal(rs.getInt("idMeal")), rs.getInt("nbPersonne"), rs.getTimestamp("creationDate")));	
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of getting list of linePlanning");
		}
		return p;
	}
	
	public static LinePlanning getLinePlanning(int id) throws DatabaseAccessError{
		LinePlanning p = null;
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEPLANNING_GET_ID);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p = new LinePlanning(id, rs.getString("day"), rs.getString("moment"), MealDB.getMeal(rs.getInt("idMeal")), rs.getInt("nbPersonne"), rs.getTimestamp("creationDate"));	
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of getting linePlanning");
		}
		return p;
	}
	
	public static void updateLinePlanning(LinePlanning linePlanning, int idPlanning) throws DatabaseAccessError {
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEPLANNING_UPDATE,Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, idPlanning);
			stmt.setString(2, linePlanning.getDay());
			stmt.setString(3, linePlanning.getMoment());
			stmt.setInt(4, linePlanning.getMeal().getId());
			stmt.setInt(5, linePlanning.getNbPersonne());
			stmt.setTimestamp(6, linePlanning.getCreationDate());
			stmt.setInt(7, linePlanning.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of updating linePlanning");
		}	
	}
	
	public static void updateListLinePlanning(List<LinePlanning> linePlannings, int idPlanning) throws DatabaseAccessError{
		for(LinePlanning linePlanning : linePlannings)
			updateLinePlanning(linePlanning, idPlanning);
	}
	
	public static void deleteListLinePlanningDay(int id, String day, String moment){
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEPLANNING_DELETE_LIST_DAY);
			stmt.setInt(1, id);
			stmt.setString(2, day);
			stmt.setString(3, moment);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of deleting linePlanning list");
		}	
	}
	
	public static void deleteListLinePlanning(int id){
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEPLANNING_DELETE_LIST);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of deleting linePlanning list");
		}	
	}
}
