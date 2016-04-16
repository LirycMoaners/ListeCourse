package fr.cyril.course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cyril.course.dao.DatabaseAccessError;
import fr.cyril.course.dao.ProductDB;
import fr.cyril.course.dto.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		Product product = new Product(request.getParameter("name"),new Timestamp(new Date().getTime()));

		try {
			ProductDB.saveProduct(product);
		} catch (DatabaseAccessError e1) {
			e1.printStackTrace();
		} finally {
			out.println("Planning ajouté !");
		}
	}
}
