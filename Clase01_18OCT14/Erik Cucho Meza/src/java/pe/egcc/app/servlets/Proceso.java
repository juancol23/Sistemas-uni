package pe.egcc.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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

  private void promediar(HttpServletRequest request, HttpServletResponse response) throws IOException {
   int n1;
   int n2;
   int n3;
   int n4;
   double promedio;
// Inicio
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    // Cabecera
    out.println("<!DOCTYPE html");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>SUMA</title");
    out.println("</head");
    out.println("<body>");
    // Datos
    n1 = Integer.parseInt(request.getParameter("n1"));
    n2 = Integer.parseInt(request.getParameter("n2"));
    n3 = Integer.parseInt(request.getParameter("n3"));
    n4 = Integer.parseInt(request.getParameter("n4"));
    out.println("<p>Nota 1: " + n1 + "</p>");
    out.println("<p>Nota 2: " + n2 + "</p>");
    out.println("<p>Nota 3: " + n3 + "</p>");
    out.println("<p>Nota 4: " + n4 + "</p>");
    
      // Proceso

    promedio=(n1+n2+n3+n4)/4;
    out.println("<p>Promedio: " + promedio + "</p>");
    // Fin
    out.println("</body>");
    out.println("</html>");
  }
  

  private void venta(HttpServletRequest request, HttpServletResponse response) throws IOException {
      double pre;
   int cant;
double total;
   
// Inicio
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    // Cabecera
    out.println("<!DOCTYPE html");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>SUMA</title");
    out.println("</head");
    out.println("<body>");
    // Datos
    pre = Double.parseDouble(request.getParameter("pre"));
    cant = Integer.parseInt(request.getParameter("cant"));
    out.println("<p>Precio: " + pre + "</p>");
    out.println("<p>Cantidad: " + cant + "</p>");
       
      // Proceso

    total=(pre*cant);
    out.println("<p>Total: " + total + "</p>");
    // Fin
    out.println("</body>");
    out.println("</html>");
  }

  
  
  
}