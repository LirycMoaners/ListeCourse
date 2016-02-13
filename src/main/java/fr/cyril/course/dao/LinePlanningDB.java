package fr.cyril.course.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.cyril.course.dto.LinePlanning;

public class LinePlanningDB {
	private static String LINEPLANNING_ADD = "Insert into linePlanning (idPlanning,day,moment,idMeal,nbPersonne,creationDate) values (?,?,?,?,?,?)";
	private static String LINEPLANNING_GET_LIST = "Select * from linePlanning where idPlanning=?";
	private static String LINEPLANNING_GET_ID = "Select * from linePlanning where id=?";
	private static String LINEPLANNING_UPDATE = "Update linePlanning set idPlanning=?,day=?,moment=?,idMeal=?,nbPersonne=?,creationDate=? where id=?";
	private static Connection con;
	
	public static void saveLinePlanning(LinePlanning linePlanning, int idPlanning) throws DatabaseAccessError{
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEPLANNING_ADD);
			stmt.setInt(1, idPlanning);
			stmt.setString(1, linePlanning.getDay());
			stmt.setString(1, linePlanning.getMoment());
			stmt.setInt(4, linePlanning.getMeal().getId());
			stmt.setInt(5, linePlanning.getNbPersonne());
			stmt.setDate(6, (Date) linePlanning.getCreationDate());
			stmt.executeUpdate();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
            	linePlanning.setId(generatedKeys.getInt(1));
            else
                throw new SQLException("Creating user failed, no ID obtained.");
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
	
	public static List<LinePlanning> getLinePlanningList(int idPlanning) throws DatabaseAccessError {
		List<LinePlanning> p = null;
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEPLANNING_GET_LIST);
			stmt.setInt(1, idPlanning);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p.add(new LinePlanning(rs.getInt("id"), rs.getString("day"), rs.getString("moment"), MealDB.getMeal(rs.getInt("idMeal")), rs.getInt("nbPersonne"), rs.getDate("creationDate")));	
			}
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
				p = new LinePlanning(id, rs.getString("day"), rs.getString("moment"), MealDB.getMeal(rs.getInt("idMeal")), rs.getInt("nbPersonne"), rs.getDate("creationDate"));	
			}
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
			PreparedStatement stmt = con.prepareStatement(LINEPLANNING_UPDATE);
			stmt.setInt(1, idPlanning);
			stmt.setString(1, linePlanning.getDay());
			stmt.setString(1, linePlanning.getMoment());
			stmt.setInt(4, linePlanning.getMeal().getId());
			stmt.setInt(5, linePlanning.getNbPersonne());
			stmt.setDate(6, (Date) linePlanning.getCreationDate());
			stmt.setInt(7, linePlanning.getId());
			stmt.executeUpdate();
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
}
