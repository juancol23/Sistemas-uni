/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egcc.pe.servlet;

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
@WebServlet(name = "Proceso", urlPatterns = {"/Promediar", "/Venta"})
public class Proceso extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String mapping = request.getServletPath();
        if (mapping.equals("/Promediar")) {
            promediar(request,response);
        }
        if (mapping.equals("/Venta")) {
            venta(request,response);
        }
    }

    private void promediar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int numero1 = Integer.parseInt(request.getParameter("num1"));
        int numero2 = Integer.parseInt(request.getParameter("num2"));
        int numero3 = Integer.parseInt(request.getParameter("num3"));
        int numero4 = Integer.parseInt(request.getParameter("num4"));
        //proceso
        
        double promedio = (numero1 + numero2 + numero3 + numero4)/4;
        //reporte
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Suma</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p> Numero1:"+ numero1 + "</p>");
        out.println("<p> Numero2:"+ numero2 + "</p>");
        out.println("<p> Numero3:"+ numero3 + "</p>");
        out.println("<p> Numero4:"+ numero4 + "</p>");
        out.println("<p> Promedio:"+ promedio + "</p>");
        out.println("</body>");
        out.println("</html>"); 
        
    }

    private void venta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int precio = Integer.parseInt(request.getParameter("precio"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        //proceso
        
        double venta = precio*cantidad;
        //reporte
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Suma</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p> Precio:"+ precio + "</p>");
        out.println("<p> Cantidad:"+ cantidad + "</p>");
        out.println("<p> Precio Total:"+ venta + "</p>");
        out.println("</body>");
        out.println("</html>"); 
    }
    
    
}
