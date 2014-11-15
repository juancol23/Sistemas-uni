/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Alumno
 */
@WebServlet(name = "Proceso", urlPatterns = {"/Promediar","/Venta"})
public class Proceso extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mapping =request.getServletPath();
        if(mapping.equals("/Promediar")){
            promediar(request, response);
        }else if(mapping.equals("/Venta")){
            venta(request, response);
        }
    }

    private void promediar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int num3 = Integer.parseInt(request.getParameter("num3"));
        int num4 = Integer.parseInt(request.getParameter("num4"));
        double promedio=(num1+num2+num3+num4)/4;
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Promedio</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Número 1: " + num1 + "</p>");
        out.println("<p>Número 2: " + num2 + "</p>");
        out.println("<p>Número 3: " + num3 + "</p>");
        out.println("<p>Número 4: " + num4 + "</p>");
        out.println("<p>Promedio: " + promedio + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
    
    private void venta(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int precio = Integer.parseInt(request.getParameter("num5"));
        int cantidad = Integer.parseInt(request.getParameter("num6"));

        double venta=precio*cantidad;
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Venta Total</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Precio: " + precio + "</p>");
        out.println("<p>Cantidad: " + cantidad + "</p>");
        out.println("<p>Venta: " + venta + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
