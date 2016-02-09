package fr.cyril.course.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import fr.cyril.course.dto.ListCourse;

public class ListCourseDB {
	private static String LIST_ADD = "Insert into list (creationDate) values (?)";
	private static String LIST_GET_LIST = "Select * from list";
	private static String LIST_GET_ID = "Select * from list where id=?";
	private static String LIST_UPDATE = "Update list set creationDate=? where id=?";
	private static Connection con;
	
	public static void saveList(ListCourse list) throws DatabaseAccessError{
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(LIST_ADD);
			stmt.setDate(1, (Date) list.getCreationDate());
			stmt.executeUpdate();
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
				System.out.println("End of adding list");
				LineListDB lineListDB = new LineListDB();
				lineListDB.saveListLineList(list.getLineList(), list.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static List<ListCourse> getListListCourse() throws DatabaseAccessError {
		List<ListCourse> p = null;
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(LIST_GET_LIST);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p.add(new ListCourse(rs.getInt("id"), new LineListDB().getLineListList(rs.getInt("id")), rs.getDate("creationDate")));	
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
				System.out.println("End of getting list of list");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static ListCourse getList(int id) throws DatabaseAccessError{
		ListCourse p = null;
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(LIST_GET_ID);
			stmt.setInt(1, id);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p = new ListCourse(id, new LineListDB().getLineListList(id), rs.getDate("creationDate"));	
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
				System.out.println("End of getting list");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static void updateList(ListCourse list) throws DatabaseAccessError {
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(LIST_UPDATE);
			stmt.setDate(1, (Date) list.getCreationDate());
			stmt.setInt(2, list.getId());
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
				System.out.println("End of updating list");
				LineListDB lineListDB = new LineListDB();
				lineListDB.updateListLineList(list.getLineList(), list.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
