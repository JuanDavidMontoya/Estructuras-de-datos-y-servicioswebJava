/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JuanM
 */
@WebServlet(urlPatterns = {"/practica1"})
public class practica1 extends HttpServlet {

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

            String numeros = request.getParameter("numeros");

            String[] numsString = numeros.split(",");
            int[] nums = new int[numsString.length];

            for (int i = 0; i < numsString.length; i++) {
                nums[i] = Integer.parseInt(numsString[i]);
            }
            int media = 0;
            int Desviacionestandar = 0;
            int contadorMedia = 0;

            for (int i = 0; i < nums.length; i++) {
                contadorMedia += nums[i];
            }

            media = contadorMedia / nums.length;

            //calculo de la varianza
            
            int varianza;
            int contvarianza=0;
            for (int i = 0; i < nums.length; i++) {
                
                contvarianza = (int) Math.pow(nums[i] - media, 2);
                
                
            }
            
            varianza = contvarianza / nums.length;

            // FIn calculo de la varianza 
            //calculos desviacion con la varianza
            
             Desviacionestandar=(int) Math.sqrt(varianza);

            
            
            response.sendRedirect("practica1.jsp?media=" + media + "&Desviacionestandar=" + Desviacionestandar);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
