package pe.fly.app.servlets;

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
 * @author FlyingCat
 */
@WebServlet(name = "Proceso", urlPatterns = {"/Promediar", "/Venta"})
public class Proceso extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Este método nos dice como fue invocado, con promediar o con venta
        String mapping = request.getServletPath();
        if (mapping.equals("/Promediar")) {
            promediar(request, response);
        } else if (mapping.equals("/Venta")) {
            venta(request, response);
        }
    }

    private void promediar(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            // Datos
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));
            int num3 = Integer.parseInt(request.getParameter("num3"));
            int num4 = Integer.parseInt(request.getParameter("num4"));
            // Proceso
            int prom = (num1 + num2 + num3 + num4) / 4;
            // Reporte
            response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
            out.println("<!DOCTYPE html");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>PROMEDIO</title");
            out.println("</head");
            out.println("<body>");
            out.println("<p>Número 1: " + num1 + "</p>");
            out.println("<p>Número 2: " + num2 + "</p>");
            out.println("<p>Número 3: " + num3 + "</p>");
            out.println("<p>Número 4: " + num4 + "</p>");
            out.println("<p>Promedio: " + prom + "</p>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    private void venta(HttpServletRequest request, HttpServletResponse response)  {
        PrintWriter out = null;
        try {
            // Datos
            double precio = Double.parseDouble(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cant"));
            // Proceso
            double total = precio * cantidad;
            // Reporte
            response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
            out.println("<!DOCTYPE html");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>VENTA</title");
            out.println("</head");
            out.println("<body>");
            out.println("<p>Precio: " + precio + "</p>");
            out.println("<p>Cantidad: " + cantidad + "</p>");
            out.println("<p>Total: " + total + "</p>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

}
