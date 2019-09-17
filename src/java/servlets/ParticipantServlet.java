/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.EmployeeRoleController;
import controllers.ParticipantController;
import daos.GeneralDAO;
import icontrollers.IEmployeeRoleController;
import icontrollers.IParticiantController;
import models.Class;
import idaos.IGeneralDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.EmployeeRole;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "ParticipantServlet", urlPatterns = {"/participantservlet"})
public class ParticipantServlet extends HttpServlet {

    private String status;
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private IParticiantController ipc = new ParticipantController(factory);
    private IGeneralDAO<Class> igdao = new GeneralDAO<>(factory, Class.class);
    private IEmployeeRoleController ierc = new EmployeeRoleController(factory);

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
            request.getSession().setAttribute("participants", ipc.getAll());
            request.getSession().setAttribute("classes", igdao.getAll());
            request.getSession().setAttribute("employees", ierc.getParticipant());
            request.getSession().setAttribute("status", status);
            List<String>Ses =new ArrayList<>();
            for (EmployeeRole empl : ierc.getById("mii.bootcamp29@gmail.com")) {
                Ses.add(String.valueOf(empl.getRole().getId()));
            }

            response.sendRedirect("participant.jsp");
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
            status = ipc.delete(id);
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
        String par_id = request.getParameter("par_id");
        String par_grade = request.getParameter("par_grade");
        String par_class = request.getParameter("par_class");

        status = ipc.save(par_id, par_grade, par_class);
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
