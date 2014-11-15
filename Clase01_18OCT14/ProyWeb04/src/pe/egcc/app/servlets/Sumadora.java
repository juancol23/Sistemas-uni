package pe.egcc.app.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sumadora")
public class Sumadora extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

		// Datos
		int n1 = Integer.parseInt(request.getParameter("num1"));
		int n2 = Integer.parseInt(request.getParameter("num2"));
		// Proceso
		int suma = n1 + n2;
		// Reporte
		request.setAttribute("n1", n1);
		request.setAttribute("n2", n2);
		request.setAttribute("suma", suma);
		// Forward
		RequestDispatcher rd = request.getRequestDispatcher("suma.jsp");
		rd.forward(request, response);
	}

}
