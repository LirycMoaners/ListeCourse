package fr.cyril.course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cyril.course.dao.DatabaseAccessError;
import fr.cyril.course.dao.PlanningDB;
import fr.cyril.course.dto.Planning;

/**
 * Servlet implementation class AddPlanningServlet
 */
@WebServlet("/AddPlanningServlet")
public class AddPlanningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		Planning planning = new Planning(new Date());

		try {
			PlanningDB.savePlanning(planning);
			request.setAttribute("idPlanning", planning.getId());
		} catch (DatabaseAccessError e1) {
			e1.printStackTrace();
		} finally {
			out.println("Planning ajouté !");
			request.getRequestDispatcher("/menu.jsp")
					.forward(request, response);
		}
	}
}
