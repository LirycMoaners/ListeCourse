package fr.cyril.course.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.cyril.course.dto.Meal;

public class MealDB {
	private static String MEAL_ADD = "Insert into meal (name,creationDate) values (?,?)";
	private static String MEAL_GET_LIST = "Select * from meal";
	private static String MEAL_GET_ID = "Select * from meal where id=?";
	private static String MEAL_UPDATE = "Update meal set name=?,creationDate=? where id=?";
	private static Connection con;
	
	public static void saveMeal(Meal meal) throws DatabaseAccessError{
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(MEAL_ADD);
			stmt.setString(1, meal.getName());
			stmt.setDate(2, (Date) meal.getCreationDate());
			stmt.executeUpdate();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
            	meal.setId(generatedKeys.getInt(1));
            else
                throw new SQLException("Creating user failed, no ID obtained.");
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				DBManager.dropConnection();
				System.out.println("End of adding meal");
				LineMealDB.saveListLineMeal(meal.getLineMeal(), meal.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static List<Meal> getMealList() throws DatabaseAccessError {
		List<Meal> p = null;
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(MEAL_GET_LIST);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p.add(new Meal(rs.getInt("id"), rs.getString("name"), LineMealDB.getLineMealList(rs.getInt("id")), rs.getDate("creationDate")));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.dropConnection();
				System.out.println("End of getting list of meal");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static Meal getMeal(int id) throws DatabaseAccessError{
		Meal p = null;
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(MEAL_GET_ID);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p = new Meal(rs.getInt("id"), rs.getString("name"), LineMealDB.getLineMealList(rs.getInt("id")), rs.getDate("creationDate"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.dropConnection();
				System.out.println("End of getting meal");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static void updateMeal(Meal meal) throws DatabaseAccessError {
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(MEAL_UPDATE);
			stmt.setString(1, meal.getName());
			stmt.setDate(2, (Date) meal.getCreationDate());
			stmt.setInt(3, meal.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.dropConnection();
				System.out.println("End of updating meal");
				LineMealDB.updateListLineMeal(meal.getLineMeal(), meal.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
}
