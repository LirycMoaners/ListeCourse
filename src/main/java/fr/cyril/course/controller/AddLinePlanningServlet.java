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
import fr.cyril.course.dao.ProductDB;
import fr.cyril.course.dto.LineMeal;
import fr.cyril.course.dto.LinePlanning;
import fr.cyril.course.dto.Meal;
import fr.cyril.course.dto.Product;

/**
 * Servlet implementation class AddLinePlanning
 */
@WebServlet("/AddLinePlanningServlet")
public class AddLinePlanningServlet extends HttpServlet {
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
			if(listIDMeal != null){
				LinePlanningDB.deleteListLinePlanningDay(idPlanning, day, moment);
				for(String idMeal : listIDMeal){
					listLinePlanning.add(new LinePlanning(day,moment,MealDB.getMeal(Integer.parseInt(idMeal)),nbPersonne,new Timestamp(new Date().getTime())));
				}
				LinePlanningDB.saveListLinePlanning(listLinePlanning, idPlanning);
			}
			
			if (request.getParameter("Valider").equals("Ajouter")){
				List<LineMeal> listLineMeal = new ArrayList<LineMeal>();
				String[] names = request.getParameterValues("produit");
				String[] qties = request.getParameterValues("qte");
				for(int i=0; i<names.length;i++){
					Product product = ProductDB.getProduct(names[i]);
					if(product == null){
						product = new Product(names[i], new Timestamp(new Date().getTime()));
						ProductDB.saveProduct(product);
					}
					listLineMeal.add(new LineMeal(Integer.parseInt(qties[i]),new Timestamp(new Date().getTime()),product));
				}
				
				Meal meal = new Meal(request.getParameter("name"),listLineMeal,new Timestamp(new Date().getTime()));
				MealDB.saveMeal(meal);
				LinePlanningDB.saveLinePlanning(new LinePlanning(day, moment, meal, nbPersonne, new Timestamp(new Date().getTime())), idPlanning);
			} else if (!request.getParameter("Valider").equals("Valider")) {
				MealDB.deleteMeal(Integer.parseInt(request.getParameter("Valider")));
			}
		} catch (NumberFormatException | DatabaseAccessError e) {
			e.printStackTrace();
		} finally {
			out.println("ListLinePlanning ajouté !");
			if (!request.getParameter("Valider").equals("Valider")){
				request.getRequestDispatcher("/GetListMealServlet")
						.forward(request, response);
			}else{
				request.getRequestDispatcher("/GetLinePlanningListServlet")
						.forward(request, response);
			}
		}
	}
}
