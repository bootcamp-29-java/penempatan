/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.EmployeeController;
import controllers.EmployeeRoleController;
import controllers.RoleController;
import icontrollers.IEmployeeController;
import icontrollers.IEmployeeRoleController;
import icontrollers.IRoleController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.EmployeeRole;
import models.Role;
import org.hibernate.SessionFactory;
import tools.GenerateId;
import tools.HibernateUtil;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "EmployeeRoleServlet", urlPatterns = {"/employeeroleservlet"})
public class EmployeeRoleServlet extends HttpServlet {

    private String status;
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private IEmployeeRoleController ierc = new EmployeeRoleController(factory);
    private IRoleController irc = new RoleController(factory);
    private IEmployeeController iec = new EmployeeController(factory);
    private GenerateId<EmployeeRole> generateEId = new GenerateId<>(factory, EmployeeRole.class);
    private GenerateId<Role> generateId = new GenerateId<>(factory, Role.class);
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
            request.getSession().setAttribute("employeesRole", ierc.getAll());
            request.getSession().setAttribute("roles", irc.getAll());
            request.getSession().setAttribute("employees", iec.getAll());
            request.getSession().setAttribute("generateIdERole", generateEId.genId());
            request.getSession().setAttribute("generateIdRole", generateId.genId());
//            response.sendRedirect("role.jsp");
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
            status = ierc.delete(id);
            request.getSession().setAttribute("status", status);
            response.sendRedirect("role.jsp");
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
        String id = request.getParameter("idERole");
        String employee = request.getParameter("employee");
        String role = request.getParameter("role");
        
        status = ierc.save(id, employee, role);
        request.getSession().setAttribute("status", status);
        response.sendRedirect("role.jsp");
        
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
