package fr.cyril.course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cyril.course.dao.DatabaseAccessError;
import fr.cyril.course.dao.PlanningDB;
import fr.cyril.course.dto.Planning;

/**
 * Servlet implementation class GetListPlanningServlet
 */
@WebServlet("/GetListPlanningServlet")
public class GetListPlanningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		List<Planning> planning = new ArrayList<Planning>();

		try {
			planning = PlanningDB.getListPlanning();
			request.setAttribute("listPlanning", planning);
		} catch (DatabaseAccessError e1) {
			e1.printStackTrace();
		} finally {
			out.println("Planning ajouté !");
			request.getRequestDispatcher("/index.jsp")
					.forward(request, response);
		}
	}
}
