package fr.cyril.course.dao;
/* Modification */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(PRODUCT_ADD,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, product.getName());
			stmt.setBoolean(2, product.isComptable());
			stmt.setTimestamp(3, product.getCreationDate());
			stmt.executeUpdate();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
            	product.setId(generatedKeys.getInt(1));
            else
                throw new SQLException("Creating user failed, no ID obtained.");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			System.out.println("End of adding product");
		}
	}
	
	public static List<Product> getProductList() throws DatabaseAccessError {
		List<Product> p = new ArrayList<Product>();
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(PRODUCT_GET_LIST);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getBoolean("comptable"),rs.getTimestamp("creationDate")));	
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of getting list of product");
		}
		return p;
	}
	
	public static Product getProduct(int id) throws DatabaseAccessError{
		Product p = null;
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(PRODUCT_GET_ID);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				p = new Product(rs.getInt("id"), rs.getString("name"), rs.getBoolean("comptable"),rs.getTimestamp("creationDate"));	
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of getting product");
		}
		return p;
	}
	
	public static void updateProduct(Product product) throws DatabaseAccessError {
		try {
			con = DBManager.getConnect();
			PreparedStatement stmt = con.prepareStatement(PRODUCT_UPDATE,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, product.getName());
			stmt.setBoolean(2, product.isComptable());
			stmt.setTimestamp(3, product.getCreationDate());
			stmt.setInt(4, product.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End of updating product");
		}	
	}
}
