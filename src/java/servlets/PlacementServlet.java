/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.ClientController;
import controllers.ParticipantController;
import controllers.PlacementController;
import daos.GeneralDAO;
import icontrollers.IClientController;
import icontrollers.IParticiantController;
import icontrollers.IPlacementController;
import idaos.IGeneralDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Client;
import models.Placement;
import org.hibernate.SessionFactory;
import tools.GenerateId;
import tools.HibernateUtil;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "PlacementServlet", urlPatterns = {"/placementservlet"})
public class PlacementServlet extends HttpServlet {

    private String status;
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private IPlacementController ipc = new PlacementController(factory);
    private IParticiantController ipac = new ParticipantController(factory);
    private IGeneralDAO<Client> igdao = new GeneralDAO<>(factory, Client.class);
    private GenerateId<Placement> generateId = new GenerateId<>(factory, Placement.class);
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
            request.getSession().setAttribute("placements", ipc.getAll());
            request.getSession().setAttribute("participants", ipac.getAll());
            request.getSession().setAttribute("clients", igdao.getAll());
//            request.getSession().setAttribute("genPId", generateId.genId());
            response.sendRedirect("placement.jsp");
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
        String id = request.getParameter("id");
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        String postion = request.getParameter("postion");
        String department = request.getParameter("department");
        String participant = request.getParameter("participant");
        String client = request.getParameter("client");
        
        status = ipc.save(id, startdate, enddate, postion, department, client, participant);
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
