package pe.egcc.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/LogonIngresar","/LogonSalir"})
public class LogonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mapping = request.getServletPath();
		if(mapping.equals("/LogonIngresar")){
			logonIngresar(request, response);
		} else if(mapping.equals("/LogonSalir")){
			logonSalir(request, response);
		}
	}

	private void logonSalir(HttpServletRequest request,
      HttpServletResponse response) 
      throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd;
	  rd = request.getRequestDispatcher("index.jsp");
	  rd.forward(request, response);
  }

	private void logonIngresar(HttpServletRequest request,
      HttpServletResponse response) 
      throws ServletException, IOException {
		String destino;
	  try {
	    String nombre = request.getParameter("nombre");
	    nombre = nombre.trim();
	    if(nombre.isEmpty()){
	    	throw new Exception("ERROR: Debe ingresar su nombre.");
	    }
	    HttpSession session = request.getSession();
	    session.setAttribute("nombre", nombre);
	    destino = "main.jsp";
    } catch (Exception e) {
	    request.setAttribute("error", e.getMessage());
	    destino = "index.jsp";
    }
	  RequestDispatcher rd;
	  rd = request.getRequestDispatcher(destino);
	  rd.forward(request, response);
  }

}
