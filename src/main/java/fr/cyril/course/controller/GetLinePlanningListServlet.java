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
import fr.cyril.course.dao.PlanningDB;
import fr.cyril.course.dto.LineMeal;
import fr.cyril.course.dto.LinePlanning;
import fr.cyril.course.dto.Planning;

/**
 * Servlet implementation class GetLinePlanningListServlet
 */
@WebServlet("/GetLinePlanningListServlet")
public class GetLinePlanningListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int idPlanning = Integer.valueOf(request.getParameter("idPlanning"));
		Planning planning = new Planning();
		
		Map<String,List<LinePlanning>> menu = new HashMap<String,List<LinePlanning>>();
		List<LinePlanning> listLinePlanning;
		
		List<Map<String,String>> listProduct = new ArrayList<Map<String,String>>();
		Map<String,String> newProduct;
		Boolean mealExist = false;

		try {
			request.setAttribute("idPlanning", idPlanning);
			
			planning = PlanningDB.getPlanning(idPlanning);
			
			for(LinePlanning linePlanning : planning.getLinePlanning()){
				if(menu.containsKey(linePlanning.getDay() + linePlanning.getMoment())){
					listLinePlanning = menu.get(linePlanning.getDay() + linePlanning.getMoment());
				}else {
					listLinePlanning = new ArrayList<LinePlanning>();
				}
				listLinePlanning.add(linePlanning);
				menu.put(linePlanning.getDay() + linePlanning.getMoment(), listLinePlanning);
				
				for(LineMeal lineMeal : linePlanning.getMeal().getLineMeal()){
					for(Map<String,String> product : listProduct){
						if(product.get("id").equals(String.valueOf(lineMeal.getProduct().getId()))){
							mealExist = true;
							product.put("qty",String.valueOf(Integer.valueOf(product.get("qty"))+lineMeal.getQuantity()*linePlanning.getNbPersonne()));
						}
					}
					if(!mealExist){
						newProduct = new HashMap<String,String>();
						newProduct.put("id", String.valueOf(lineMeal.getProduct().getId()));
						newProduct.put("name", lineMeal.getProduct().getName());
						newProduct.put("qty",String.valueOf(lineMeal.getQuantity()*linePlanning.getNbPersonne()));
						listProduct.add(newProduct);
					}
					mealExist = false;
				}
			}
			request.setAttribute("menu", menu);
			request.setAttribute("listProduct",listProduct);
			
		} catch (DatabaseAccessError e1) {
			e1.printStackTrace();
		} finally {
			out.println("Planning ajouté !");
			request.getRequestDispatcher("/menu.jsp")
					.forward(request, response);
		}
	}

}
