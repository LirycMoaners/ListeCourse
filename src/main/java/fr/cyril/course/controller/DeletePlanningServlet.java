package fr.cyril.course.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cyril.course.dao.DatabaseAccessError;
import fr.cyril.course.dao.PlanningDB;

/**
 * Servlet implementation class DeletePlanningServlet
 */
@WebServlet("/DeletePlanningServlet")
public class DeletePlanningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		try {
			PlanningDB.deletePlanning(Integer.valueOf(request.getParameter("idPlanning")));
		} catch (DatabaseAccessError e) {
			e.printStackTrace();
		} finally {
			out.println("Planning supprimé !");
			request.getRequestDispatcher("/")
					.forward(request, response);
		}
	}
}
