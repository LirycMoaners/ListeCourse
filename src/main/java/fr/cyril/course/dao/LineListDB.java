package fr.cyril.course.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import fr.cyril.course.dto.LineList;

public class LineListDB {
	private static String LINELIST_ADD = "Insert into lineList (idList,idProduct,quantity,creationDate) values (?,?,?,?)";
	private static String LINELIST_GET_LIST = "Select * from lineList where idList=?";
	private static String LINELIST_GET_ID = "Select * from lineList where id=?";
	private static String LINELIST_UPDATE = "Update lineList set idList=?,idProduct=?,quantity=?,creationDate=? where id=?";
	private static Connection con;
	
	public static void saveLineList(LineList lineList, int idList) throws DatabaseAccessError{
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(LINELIST_ADD);
			stmt.setInt(1, idList);
			stmt.setInt(2, lineList.getProduct().getId());
			stmt.setInt(3, lineList.getQuantity());
			stmt.setDate(4, (Date) lineList.getCreationDate());
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
				System.out.println("End of adding lineList");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void saveListLineList(List<LineList> lineLists, int idList) throws DatabaseAccessError{
		for(LineList lineList : lineLists)
			saveLineList(lineList, idList);
	}
	
	public static List<LineList> getLineListList(int idList) throws DatabaseAccessError {
		List<LineList> p = null;
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(LINELIST_GET_LIST);
			stmt.setInt(1, idList);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p.add(new LineList(rs.getInt("quantity"), rs.getDate("creationDate"), new ProductDB().getProduct(rs.getInt("idProduct"))));	
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
				System.out.println("End of getting list of lineList");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static LineList getLineList(int id) throws DatabaseAccessError{
		LineList p = null;
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(LINELIST_GET_ID);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p = new LineList(rs.getInt("quantity"), rs.getDate("creationDate"), new ProductDB().getProduct(rs.getInt("idProduct")));	
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
				System.out.println("End of getting lineList");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static void updateLineList(LineList lineList, int idList) throws DatabaseAccessError {
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(LINELIST_UPDATE);
			stmt.setInt(1, idList);
			stmt.setInt(2, lineList.getProduct().getId());
			stmt.setInt(3, lineList.getQuantity());
			stmt.setDate(4, (Date) lineList.getCreationDate());
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
				System.out.println("End of updating lineList");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public static void updateListLineList(List<LineList> lineList, int idList) throws DatabaseAccessError {
		for(LineList l : lineList)
			updateLineList(l,idList);
	}
}
