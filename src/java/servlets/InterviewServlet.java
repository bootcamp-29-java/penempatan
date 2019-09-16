/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.InterviewController;
import controllers.ParticipantController;
import daos.GeneralDAO;
import icontrollers.IInterviewController;
import icontrollers.IParticiantController;
import idaos.IGeneralDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Client;
import org.hibernate.SessionFactory;
import tools.AllMethod;
import tools.HibernateUtil;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "InterviewServlet", urlPatterns = {"/interviewservlet"})
public class InterviewServlet extends HttpServlet {

    private String status;
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private IInterviewController iic = new InterviewController(factory);
    private IParticiantController ipac = new ParticipantController(factory);
    private IGeneralDAO<Client> igdao = new GeneralDAO<>(factory, Client.class);

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
            request.getSession().setAttribute("interviews", iic.getAll());
            request.getSession().setAttribute("participants", ipac.getAll());
            request.getSession().setAttribute("clients", igdao.getAll());
            response.sendRedirect("interview.jsp");
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
        
        String idInterview = request.getParameter("idInterview") + "";
        String emailInterview = request.getParameter("emailInterview") + "";
        String firstNameInterview = request.getParameter("firstNameInterview") + "";
        
        
        if (action.equals("delete")) {
            status = iic.delete(id);
            request.getSession().setAttribute("status", status);
        }
        if(action.equals("sendInterview")){
            AllMethod.sendInterview(emailInterview, firstNameInterview, idInterview);
            status = "Email Berhasil Dikirimkan";
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
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String location = request.getParameter("location");
        String department = request.getParameter("department");
        String pic = request.getParameter("pic");
        String participant = request.getParameter("participant");
        String client = request.getParameter("client");

        status = iic.save(id, date, time, location, department, pic, "0", participant, client);
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
