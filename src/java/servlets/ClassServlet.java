/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.BatchControler;
import controllers.ClassController;
import controllers.EmployeeController;
import controllers.EmployeeRoleController;
import controllers.LessonController;
import icontrollers.IBatchController;
import icontrollers.IClassController;
import icontrollers.IEmployeeController;
import icontrollers.IEmployeeRoleController;
import icontrollers.ILessonController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "ClassServlet", urlPatterns = {"/classservlet"})
public class ClassServlet extends HttpServlet {
    String status;
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private IClassController ican = new ClassController(factory);
    private IBatchController ib = new BatchControler(factory);
    private ILessonController ilc = new LessonController(factory);
    private IEmployeeRoleController ierc = new EmployeeRoleController(factory);
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getSession().setAttribute("Kelass", ican.getall());
            request.getSession().setAttribute("Batchs", ib.getall());
            request.getSession().setAttribute("lessons", ilc.getall());
            request.getSession().setAttribute("trainers", ierc.getTrainer());
            
            response.sendRedirect("class.jsp");
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
        String batch_id = request.getParameter("batch_id");
        String trainer_id = request.getParameter("trainer_id");
        String lesson_id = request.getParameter("lesson_id");
        String kelas_id = lesson_id+"/"+batch_id;
        
        if (batch_id!= "" && lesson_id=="") {
            status = ib.save(batch_id);
            request.getSession().setAttribute("status",status);
            //request.getSession().setAttribute("batch_name", batch_id);
            response.sendRedirect("class.jsp");
            System.out.println(status);
            request.removeAttribute(status);
        }
       else if (!"".equals(lesson_id)){
            status = ican.save(lesson_id+"/"+batch_id, lesson_id, batch_id, trainer_id);
            request.getSession().setAttribute("status",status);
            //request.getSession().setAttribute("kelas_name", kelas_id);
            System.out.println(status);
            request.removeAttribute(status);
        }
        else{
            request.getSession().setAttribute("status",status);
            response.sendRedirect("class.jsp");
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
