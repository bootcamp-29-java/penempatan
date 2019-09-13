/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.AccountController;
import controllers.EmployeeController;
import icontrollers.IAccountController;
import icontrollers.IEmployeeController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import tools.AllMethod;
import tools.HibernateUtil;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "ResgisterServlet", urlPatterns = {"/registerservlet"})
public class ResgisterServlet extends HttpServlet {
    private String status;
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private IEmployeeController iec = new EmployeeController(factory);
    private IAccountController iac = new AccountController(factory);
    

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
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String birthPlace = request.getParameter("birthPlace");
        String birthDate = request.getParameter("birthDate");
        String gender = request.getParameter("gender");
        String nationality = request.getParameter("nationality");
        String token = AllMethod.generateToken();
        String religion = request.getParameter("religion");
        String phone = request.getParameter("phone");
        status = iec.save(id, firstName, lastName, email, birthPlace, birthDate, gender, nationality, "", religion, phone, false);
        if (status.equalsIgnoreCase("Save data berhasil")) {
            if (iac.createAccount(id, "", token, "-1", "").equalsIgnoreCase("Berhasil")) {
                AllMethod.sendEmail(email, firstName+" "+lastName, token);
                request.getSession().setAttribute("status", status);
                response.sendRedirect("index.jsp");
            }else{
                request.getSession().setAttribute("status", status);
                response.sendRedirect("index.jsp");
            }
        }
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
