<%-- 
    Document   : invitation
    Created on : Sep 16, 2019, 10:59:06 AM
    Author     : ASUS
--%>

<%@page import="models.EmployeeRole"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<EmployeeRole> logSession = (List<EmployeeRole>) session.getAttribute("sessionlogin");
            String id = (String) session.getAttribute("interviewId");
            out.print(id);

            if (logSession == null) {
                out.print(logSession);
                out.println("<script>alert('Anda belum login!')</script>");
                out.println("<script>window.location.href=\"admin/login.jsp\"</script>");
            } else if (id == null) {
                response.sendRedirect("invitationservlet");
            } else {
                Connection con = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_user_management", "root", "");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                File report = new File(application.getRealPath("/report/invitationInterview.jasper"));
                Map param = new HashMap();
                param.put("id", id);
                byte[] bytes = JasperRunManager.runReportToPdf(report.getPath(), param, con);

                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream outStreaam = response.getOutputStream();
                outStreaam.write(bytes, 0, bytes.length);
                outStreaam.flush();
                outStreaam.close();

                request.removeAttribute("interviewId");
            }
        %>
    </body>
</html>
