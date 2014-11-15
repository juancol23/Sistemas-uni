package pe.egcc.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.app.model.CatalogoModel;
import pe.egcc.app.model.MatematicaModel;

/**
 * Servlet implementation class CatalogoController
 */
@WebServlet({"/CatalogoListado","/CatalogoNuevo",
	"/CatalogoEditar"})
public class CatalogoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mapping = request.getServletPath();
		if(mapping.equals("/CatalogoListado")){
			catalogoListado(request, response);
		} 
	}

	private void catalogoListado(HttpServletRequest request,
      HttpServletResponse response) 
      throws ServletException, IOException {
		try {
	    // Proceso
	  	CatalogoModel model = new CatalogoModel();
	  	List<Map<String,Object>> lista;
	  	lista = model.listado();
	  	// Reporte
	  	request.setAttribute("lista", lista);
    } catch (Exception e) {
	    request.setAttribute("error", e.getMessage());
    }
	  RequestDispatcher rd;
	  rd = request.getRequestDispatcher("catalogo.jsp");
	  rd.forward(request, response);
  }

}
