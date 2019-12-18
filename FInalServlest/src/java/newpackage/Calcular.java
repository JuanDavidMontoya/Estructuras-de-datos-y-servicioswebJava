package newpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterators;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Z40
 */
@WebServlet(urlPatterns = {"/Calcular"})
public class Calcular extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            String cal = request.getParameter("cal");
            String[] val;

            double resul = 0, prom = 0, suma = 0, cant = 0;

            val = cal.split(",");
            List<Integer> num = new ArrayList<>();

            for (int i = 0; i < val.length; i++) {
                num.add(Integer.parseInt(val[i]));
            }

            for (int j = 0; j < num.size(); j++) {

                suma += num.get(j);
                cant = j+1;
                prom = suma / cant;
                out.print(num.get(j)+",");
            }

            int moda = 0, maximoNumRepeticiones = 0;
            for (int a = 0; a < num.size(); a++) {
                int numRepeticiones = 0;
                for (int b = 0; b < num.size(); b++) {
                    if (num.get(a) == num.get(b)) {
                        numRepeticiones++;
                    }
                    if (numRepeticiones > maximoNumRepeticiones) {
                        moda = num.get(a);
                        maximoNumRepeticiones = numRepeticiones;
                    }
                }
            }
            out.print("moda" + moda + "\n");
            out.print("Suma : " + suma + "\n" + " promedio : " + prom + "\n" + " cantidad  " + cant);
    }

}}