package fr.cyril.course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cyril.course.dao.DatabaseAccessError;
import fr.cyril.course.dao.LinePlanningDB;
import fr.cyril.course.dao.MealDB;
import fr.cyril.course.dao.ProductDB;
import fr.cyril.course.dto.LinePlanning;
import fr.cyril.course.dto.Meal;

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
		String day = request.getParameter("day");
		String moment = request.getParameter("moment");
		Map<Meal,Integer> listMealSel = new HashMap<Meal,Integer>();
		List<Meal> listMeal = new ArrayList<Meal>();
		List<LinePlanning> listLinePlanning = new ArrayList<LinePlanning>();
		Boolean exist = false;
		
		try {
			request.setAttribute("idPlanning",idPlanning);
			request.setAttribute("day",day);
			request.setAttribute("moment",moment);
			request.setAttribute("listProduct",ProductDB.getProductList());
			
			listMeal = MealDB.getMealList();
			listLinePlanning = LinePlanningDB.getLinePlanningListDay(idPlanning, day, moment);
			
			for(Meal meal : listMeal){
				for(LinePlanning linePlanning : listLinePlanning){
					if(meal.getId() == linePlanning.getMeal().getId()){
						exist = true;
					}
				}
				if(exist){
					listMealSel.put(meal, 1);
				}else{
					listMealSel.put(meal, 0);
				}
				exist = false;
			}
			
			if(listLinePlanning.size()!=0)
				request.setAttribute("nbPersonne",listLinePlanning.get(0).getNbPersonne());
			
			request.setAttribute("listMeal",listMealSel);
			
		} catch (DatabaseAccessError e) {
			e.printStackTrace();
		}
		
		out.println("Fin de la servlet de choix du plat !");
		request.getRequestDispatcher("/plat.jsp").forward(request, response);
	}
}
