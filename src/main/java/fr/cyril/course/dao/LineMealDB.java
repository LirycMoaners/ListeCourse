package fr.cyril.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cyril.course.dto.LineMeal;

public class LineMealDB {
	private static String LINEMEAL_ADD = "Insert into lineMeal (idMeal,idProduct,quantity,creationDate) values (?,?,?,?)";
	private static String LINEMEAL_GET_LIST = "Select * from lineMeal where idMeal=?";
	private static String LINEMEAL_GET_ID = "Select * from lineMeal where id=?";
	private static String LINEMEAL_UPDATE = "Update lineMeal set idMeal=?,idProduct=?,quantity=?,creationDate=? where id=?";
	private static String LINEMEAL_DELETE_LIST = "Delete from lineMeal where idMeal=?";
	private static Connection con;
	
	public static void saveLineMeal(LineMeal lineMeal, int idMeal) throws DatabaseAccessError{
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEMEAL_ADD,Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, idMeal);
			stmt.setInt(2, lineMeal.getProduct().getId());
			stmt.setInt(3, lineMeal.getQuantity());
			stmt.setTimestamp(4, lineMeal.getCreationDate());
			stmt.executeUpdate();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
            	lineMeal.setId(generatedKeys.getInt(1));
            else
                throw new SQLException("Creating user failed, no ID obtained.");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			System.out.println("End of adding lineMeal");
		}
	}
	
	public static void saveListLineMeal(List<LineMeal> lineMeals, int idMeal) throws DatabaseAccessError{
		for(LineMeal lineMeal : lineMeals)
			saveLineMeal(lineMeal, idMeal);
	}
	
	public static List<LineMeal> getLineMealList(int idMeal) throws DatabaseAccessError {
		List<LineMeal> p = new ArrayList<LineMeal>();
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEMEAL_GET_LIST);
			stmt.setInt(1, idMeal);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p.add(new LineMeal(rs.getInt("id"), rs.getInt("quantity"), rs.getTimestamp("creationDate"), ProductDB.getProduct(rs.getInt("idProduct"))));	
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of getting list of lineMeal");
		}
		return p;
	}
	
	public static LineMeal getLineMeal(int id) throws DatabaseAccessError{
		LineMeal p = null;
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEMEAL_GET_ID);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p = new LineMeal(rs.getInt("id"), rs.getInt("quantity"), rs.getTimestamp("creationDate"), ProductDB.getProduct(rs.getInt("idProduct")));	
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of getting lineMeal");
		}
		return p;
	}
	
	public static void updateLineMeal(LineMeal lineMeal, int idMeal) throws DatabaseAccessError {
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEMEAL_UPDATE,Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, idMeal);
			stmt.setInt(2, lineMeal.getProduct().getId());
			stmt.setInt(3, lineMeal.getQuantity());
			stmt.setTimestamp(4, lineMeal.getCreationDate());
			stmt.setInt(5, lineMeal.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of updating lineMeal");
		}	
	}
	
	public static void updateListLineMeal(List<LineMeal> lineMeals, int idMeal) throws DatabaseAccessError{
		for(LineMeal lineMeal : lineMeals)
			updateLineMeal(lineMeal, idMeal);
	}
	
	public static void deleteListLineMeal(int id){
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(LINEMEAL_DELETE_LIST);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of deleting lineMeal list");
		}	
	}
}
