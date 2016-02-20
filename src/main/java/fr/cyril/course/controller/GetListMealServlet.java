package fr.cyril.course.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cyril.course.dao.DatabaseAccessError;
import fr.cyril.course.dao.MealDB;
import fr.cyril.course.dao.ProductDB;

/**
 * Servlet implementation class GetListMealServlet
 */
@WebServlet("/GetListMealServlet")
public class GetListMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		int idPlanning = Integer.parseInt(request.getParameter("idPlanning"));
		
		try {
			if (!request.getParameter("idPlanning").equals(null)){
				request.setAttribute("idPlanning",idPlanning);
				request.setAttribute("day",request.getParameter("day"));
				request.setAttribute("moment",request.getParameter("moment"));
			}else{
				request.setAttribute("listLinePlanning",request.getParameter("listLinePlanning"));
			}
			
			request.setAttribute("listMeal",MealDB.getMealList());
			request.setAttribute("listProduct",ProductDB.getProductList());
			
		} catch (DatabaseAccessError e) {
			e.printStackTrace();
		}
		
		out.println("Fin de la servlet de choix du plat !");
		request.getRequestDispatcher("/plat.jsp").forward(request, response);
	}
}
