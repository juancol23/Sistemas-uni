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
@WebServlet(name = "proceso", urlPatterns = {"/promediar","/venta"})
public class Proceso extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String mapping = request.getServletPath();
        if (mapping.equals("/promediar")){
            promediar(request,response);
        }else if (mapping.equals("/venta")){
            Venta(request,response);
        }        
    }
    
    private void promediar (HttpServletRequest request,HttpServletResponse response) throws IOException{
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int num3 = Integer.parseInt(request.getParameter("num3"));
        int num4 = Integer.parseInt(request.getParameter("num4"));        
        // Proceso
        double promedio = (num1 + num2+ num3+ num4)/4;
        // Reporte
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Promedio Final</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Nota 1: " + num1 + "</p>");
        out.println("<p>Nota 2: " + num2 + "</p>");
        out.println("<p>Nota 3: " + num3 + "</p>");
        out.println("<p>Nota 4: " + num4 + "</p>");
        out.println("<p>Promedio Final : " + promedio + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
    
    private void Venta (HttpServletRequest request,HttpServletResponse response) throws IOException{
        double num1 = Double.parseDouble(request.getParameter("numprecio"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        
        // Proceso
        double promedio = num1*num2;
        // Reporte
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Promedio Final</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Precio Venta : " + num1 + "</p>");
        out.println("<p>Cantidad : " + num2 + "</p>");                
        out.println("<p>Venta Final : " + promedio + "</p>");
        out.println("</body>");
        out.println("</html>");        
    }
}
