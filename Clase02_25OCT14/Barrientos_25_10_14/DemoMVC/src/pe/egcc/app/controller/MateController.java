package pe.egcc.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.app.model.MatematicaModel;

@WebServlet({"/FactorialControl","/MCDControl"})
public class MateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

		String mapping = request.getServletPath();
		if(mapping.equals("/FactorialControl")){
			factorialControl(request, response);
		} else if(mapping.equals("/MCDControl")){
			mcdControl(request, response);
		}
		
	}

	private void factorialControl(HttpServletRequest request,
      HttpServletResponse response) 
      throws ServletException, IOException {
	  try {
	    // Recoger el dato
	  	int num = Integer.parseInt(request.getParameter("num"));
	  	// Proceso
	  	MatematicaModel model = new MatematicaModel();
	  	long f = model.factorial(num);
	  	// Reporte
	  	String repo = "Factorial de "  + num + 
	  			" es " + f + ".";
	  	request.setAttribute("repo", repo);
    } catch (Exception e) {
	    request.setAttribute("error", e.getMessage());
    }
	  RequestDispatcher rd;
	  rd = request.getRequestDispatcher("factorial.jsp");
	  rd.forward(request, response);
  }

	private void mcdControl(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
		 try {
			 // Recoger el dato
			  	int num1 = Integer.parseInt(request.getParameter("num1"));
			  	int num2 = Integer.parseInt(request.getParameter("num2"));
			  	// Proceso
			  	MatematicaModel model = new MatematicaModel();
			  	long f = model.mcd(num1, num2);
			  	// Reporte
			  	String repo = "El MCD de: " + num1 + " y "+ num2 +
			  		" es " + f + ".";
			  	request.setAttribute("repo", repo);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		 RequestDispatcher rd;
		  rd = request.getRequestDispatcher("mcd.jsp");
		  rd.forward(request, response);
	  
   }
	
}