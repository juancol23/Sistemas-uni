
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "Proceso",  urlPatterns = {"/Promediar", "/Venta"})
public class Proceso extends HttpServlet {
    private int n1;
    private int n2;
    private int n3;
    private int n4;
    private double precio;
    private int cantidad;
    private double prom;
    private double total;
    private String condicion;
   
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
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();   
    out.println("<!DOCTYPE html");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>PROMEDIO</title");
    out.println("</head");
    out.println("<body>");
    // Datos
    n1 = Integer.parseInt(request.getParameter("n1"));
    n2 = Integer.parseInt(request.getParameter("n2"));
    n3 = Integer.parseInt(request.getParameter("n3"));
    n4 = Integer.parseInt(request.getParameter("n4"));
    out.println("<p>REGISTRO DE NOTAS </p>");
    out.println("<p>================= </p>");
    out.println("<p>Nota 1: " + n1 + "</p>");
    out.println("<p>Nota 2: " + n2 + "</p>");
    out.println("<p>Nota 3: " + n3 + "</p>");
    out.println("<p>Nota 4: " + n4 + "</p>");
    //Proceso
    prom = (double)(n1 + n2 + n3 + n4)/4;
    if(prom>=14){
        condicion = "APROBADO";
    }else{
        condicion = "DESAPROBADO";
    }
    out.println("<p>Promedio: " + prom + "</p>");
    out.println("<p>Condición: " + condicion + "</p>");
    out.println("</body>");
    out.println("</html>");
  }

  private void venta(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();   

    out.println("<!DOCTYPE html");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>VENTA</title");
    out.println("</head");
    out.println("<body>");
    // Datos
    precio = Integer.parseInt(request.getParameter("precio"));
    cantidad = Integer.parseInt(request.getParameter("cant"));
    total = (double)(precio*cantidad);
    out.println("<p>REGISTRO DE VENTAS</p>");
    out.println("<p>================== </p>");
    out.println("<p>Precio: S/." + precio + "</p>");
    out.println("<p>Cantidad: " + cantidad + " unidades</p>");
    out.println("<p>Monto Total: S/." + total + " </p>");
    out.println("</body>");
    out.println("</html>");
  }

    

}
