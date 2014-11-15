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
@WebServlet(name = "Sumar",
        urlPatterns = {"/Sumar", "/Plus", "/Sumita"})
public class Sumar extends HttpServlet {

  // No es buena practica crear variables
  // a nivel de clase
  private int num1;
  private int num2;
  private int suma;

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {
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
    num1 = Integer.parseInt(request.getParameter("num1"));
    num2 = Integer.parseInt(request.getParameter("num2"));
    out.println("<p>Número 1: " + num1 + "</p>");
    out.println("<p>Número 2: " + num2 + "</p>");
    try {
      // Proceso
      Thread.currentThread().sleep(1000);
    } catch (InterruptedException ex) {
      Logger.getLogger(Sumar.class.getName()).log(Level.SEVERE, null, ex);
    }
    suma = num1 + num2;
    out.println("<p>Suma: " + suma + "</p>");
    // Fin
    out.println("</body>");
    out.println("</html>");
  }

}
