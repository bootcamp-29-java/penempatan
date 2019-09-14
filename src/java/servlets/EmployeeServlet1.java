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
import org.hibernate.SessionFactory;
import tools.AllMethod;
import tools.HibernateUtil;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "EmployeeServlet1", urlPatterns = {"/employeeservlet1"})
public class EmployeeServlet1 extends HttpServlet {

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
            request.getSession().setAttribute("employees1", iec.getAll());
            response.sendRedirect("employee.jsp");
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
        String action = request.getParameter("action") + "";
        String id = request.getParameter("id") + "";
        if (action.equals("delete")) {
            status = iec.delete(id);
            request.getSession().setAttribute("status", status);
        }
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
        String photo = request.getParameter("");
        String religion = request.getParameter("religion");
        String phone = request.getParameter("phone");
        String token = AllMethod.generateToken();

        status = iec.save(id, firstName, lastName, email, birthPlace, birthDate, gender, nationality, photo, religion, phone, false);
        request.getSession().setAttribute("status", status);
        
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
