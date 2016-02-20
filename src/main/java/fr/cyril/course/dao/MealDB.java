package fr.cyril.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			PreparedStatement stmt = con.prepareStatement(MEAL_ADD,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, meal.getName());
			stmt.setTimestamp(2, meal.getCreationDate());
			stmt.executeUpdate();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
            	meal.setId(generatedKeys.getInt(1));
            else
                throw new SQLException("Creating user failed, no ID obtained.");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			System.out.println("End of adding meal");
			LineMealDB.saveListLineMeal(meal.getLineMeal(), meal.getId());
		}
	}
	
	public static List<Meal> getMealList() throws DatabaseAccessError {
		List<Meal> p = new ArrayList<Meal>();
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(MEAL_GET_LIST);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p.add(new Meal(rs.getInt("id"), rs.getString("name"), LineMealDB.getLineMealList(rs.getInt("id")), rs.getTimestamp("creationDate")));	
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of getting list of meal");
		}
		return p;
	}
	
	public static Meal getMeal(int id) throws DatabaseAccessError{
		Meal p = null;
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(MEAL_GET_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				p = new Meal(rs.getInt("id"), rs.getString("name"), LineMealDB.getLineMealList(rs.getInt("id")), rs.getTimestamp("creationDate"));	
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of getting meal");
		}
		return p;
	}
	
	public static void updateMeal(Meal meal) throws DatabaseAccessError {
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(MEAL_UPDATE,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, meal.getName());
			stmt.setTimestamp(2, meal.getCreationDate());
			stmt.setInt(3, meal.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of updating meal");
			LineMealDB.updateListLineMeal(meal.getLineMeal(), meal.getId());
		}	
	}
}
