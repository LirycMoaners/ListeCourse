package fr.cyril.course.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import fr.cyril.course.dto.LineMeal;

public class LineMealDB {
	private static String LINEMEAL_ADD = "Insert into lineMeal (idMeal,idProduct,quantity,creationDate) values (?,?,?,?)";
	private static String LINEMEAL_GET_LIST = "Select * from lineMeal where idMeal=?";
	private static String LINEMEAL_GET_ID = "Select * from lineMeal where id=?";
	private static String LINEMEAL_UPDATE = "Update lineMeal set idMeal=?,idProduct=?,quantity=?,creationDate=? where id=?";
	private static Connection con;
	
	public static void saveLineMeal(LineMeal lineMeal, int idMeal) throws DatabaseAccessError{
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(LINEMEAL_ADD);
			stmt.setInt(1, idMeal);
			stmt.setInt(2, lineMeal.getProduct().getId());
			stmt.setInt(3, lineMeal.getQuantity());
			stmt.setDate(4, (Date) lineMeal.getCreationDate());
			stmt.executeUpdate();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
            	lineMeal.setId(generatedKeys.getInt(1));
            else
                throw new SQLException("Creating user failed, no ID obtained.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getExplanation());
			
		}  finally {
			try {
				DbUtils.dropConnection(con);
				System.out.println("End of adding lineMeal");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void saveListLineMeal(List<LineMeal> lineMeals, int idMeal) throws DatabaseAccessError{
		for(LineMeal lineMeal : lineMeals)
			saveLineMeal(lineMeal, idMeal);
	}
	
	public static List<LineMeal> getLineMealList(int idMeal) throws DatabaseAccessError {
		List<LineMeal> p = null;
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(LINEMEAL_GET_LIST);
			stmt.setInt(1, idMeal);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p.add(new LineMeal(rs.getInt("id"), rs.getInt("quantity"), rs.getDate("creationDate"), new ProductDB().getProduct(rs.getInt("idProduct"))));	
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getExplanation());
			
		} finally {
			try {
				DbUtils.dropConnection(con);
				System.out.println("End of getting list of lineMeal");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static LineMeal getLineMeal(int id) throws DatabaseAccessError{
		LineMeal p = null;
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(LINEMEAL_GET_ID);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p = new LineMeal(rs.getInt("id"), rs.getInt("quantity"), rs.getDate("creationDate"), new ProductDB().getProduct(rs.getInt("idProduct")));	
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getExplanation());
			
		} finally {
			try {
				DbUtils.dropConnection(con);
				System.out.println("End of getting lineMeal");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static void updateLineMeal(LineMeal lineMeal, int idMeal) throws DatabaseAccessError {
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(LINEMEAL_UPDATE);
			stmt.setInt(1, idMeal);
			stmt.setInt(2, lineMeal.getProduct().getId());
			stmt.setInt(3, lineMeal.getQuantity());
			stmt.setDate(4, (Date) lineMeal.getCreationDate());
			stmt.setInt(5, lineMeal.getId());
			stmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getExplanation());
		} finally {
			try {
				DbUtils.dropConnection(con);
				System.out.println("End of updating lineMeal");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public static void updateListLineMeal(List<LineMeal> lineMeals, int idMeal) throws DatabaseAccessError{
		for(LineMeal lineMeal : lineMeals)
			updateLineMeal(lineMeal, idMeal);
	}
}
