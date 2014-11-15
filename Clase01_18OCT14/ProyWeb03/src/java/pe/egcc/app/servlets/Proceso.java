package pe.egcc.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Coronel
 */
@WebServlet(name = "Proceso", 
        urlPatterns = {"/Promediar", "/Venta"})
public class Proceso extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    String mapping = request.getServletPath();
    if(mapping.equals("/Promediar")){
      promediar(request,response);
    } else if(mapping.equals("/Venta")){
      venta(request,response);
    }
  }

  private void promediar(HttpServletRequest request, HttpServletResponse response) {
  }

  private void venta(HttpServletRequest request, HttpServletResponse response) {
  }

  
  
  
}