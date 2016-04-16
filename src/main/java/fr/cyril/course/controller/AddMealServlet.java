package fr.cyril.course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cyril.course.dao.DatabaseAccessError;
import fr.cyril.course.dao.LinePlanningDB;
import fr.cyril.course.dao.MealDB;
import fr.cyril.course.dto.LinePlanning;

/**
 * Servlet implementation class AddMealServlet
 */
@WebServlet("/AddMealServlet")
public class AddMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		int idPlanning = Integer.parseInt(request.getParameter("idPlanning"));
		int nbPersonne = Integer.parseInt(request.getParameter("nbPersonne"));
		String day = request.getParameter("day");
		String moment = request.getParameter("moment");
		String[] listIDMeal = request.getParameterValues("meals");
		List<LinePlanning> listLinePlanning = new ArrayList<LinePlanning>();
		
		try {
			LinePlanningDB.deleteListLinePlanningDay(idPlanning, day, moment);
			for(String idMeal : listIDMeal){
				listLinePlanning.add(new LinePlanning(day,moment,MealDB.getMeal(Integer.parseInt(idMeal)),nbPersonne,new Timestamp(new Date().getTime())));
			}
			LinePlanningDB.saveListLinePlanning(listLinePlanning, idPlanning);
		} catch (NumberFormatException | DatabaseAccessError e) {
			e.printStackTrace();
		} finally {
			out.println("ListLinePlanning ajouté !");
			request.getRequestDispatcher("/GetLinePlanningListServlet")
					.forward(request, response);
		}
	}
}
