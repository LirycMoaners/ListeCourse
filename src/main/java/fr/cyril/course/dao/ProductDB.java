package fr.cyril.course.dao;
/* Modification */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import fr.cyril.course.dao.DbUtils;
import fr.cyril.course.dto.Product;
import fr.cyril.course.dao.DatabaseAccessError;

public class ProductDB {
	
	private static String PRODUCT_ADD = "Insert into product (name,comptable,creationDate) values (?,?,?)";
	private static String PRODUCT_GET_LIST = "Select * from product";
	private static String PRODUCT_GET_ID = "Select * from product where id=?";
	private static String PRODUCT_UPDATE = "Update product set name=?,comptable=?,creationDate=? where id=?";
	private static Connection con;
	
	public static void saveProduct(Product product) throws DatabaseAccessError{
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(PRODUCT_ADD);
			stmt.setString(1, product.getName());
			stmt.setBoolean(2, product.isComptable());
			stmt.setDate(3, (Date) product.getCreationDate());
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
				System.out.println("End of adding product");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static List<Product> getProductList() throws DatabaseAccessError {
		List<Product> p = null;
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(PRODUCT_GET_LIST);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getBoolean("comptable"),rs.getDate("creationDate")));	
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
				System.out.println("End of getting list of product");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static Product getProduct(int id) throws DatabaseAccessError{
		Product p = null;
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(PRODUCT_GET_ID);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p = new Product(rs.getInt("id"), rs.getString("name"), rs.getBoolean("comptable"),rs.getDate("creationDate"));	
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
				System.out.println("End of getting product");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static void updateProduct(Product product) throws DatabaseAccessError {
		try {
			con = DbUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(PRODUCT_UPDATE);
			stmt.setString(1, product.getName());
			stmt.setBoolean(2, product.isComptable());
			stmt.setDate(3, (Date) product.getCreationDate());
			stmt.setInt(4, product.getId());
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
				System.out.println("End of updating product");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
