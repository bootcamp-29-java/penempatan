<%-- 
    Document   : login
    Created on : Aug 31, 2019, 1:27:00 AM
    Author     : asus
--%>

<%@page import="java.util.List"%>
<%@page import="models.EmployeeRole"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String status = (String) session.getAttribute("status");
    List<EmployeeRole> username = (List<EmployeeRole>) session.getAttribute("sessionlogin");
    out.print(status);
    if (username != null) {
        response.sendRedirect("../index.jsp");
    } else {
%>
<html>
    <head>
       <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <!-- Bootstrap core CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.9/css/mdb.min.css" rel="stylesheet">
        <!-- JQuery -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.9/js/mdb.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script><title>Login</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row justify-content-center align-items-center" style="height:100vh">
                <div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">
                    <form action="../loginservlet" method="POST" id="loginForm" autocomplete="off">

                        <div class="form-group">
                            <h3><p align="center">LOGIN</h3>
                           <!-- Material input -->
                            <div class="md-form">
                                <input type="text" id="form1" class="form-control" name="email" id="email">
                                <label for="form1">Login</label>
                            </div>

                            <div class="md-form">
                                <input type="password" id="form1" class="form-control" name="password" id="password">
                                <label for="form1">Password</label>
                            </div>


                            <div class="form-group ">
                                <div class=" d-flex justify-content-center">
                                    <!-- Forgot password -->
                                    <a href="">Forgot my password</a>
                                </div>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary btn-lg btn-block" type="submit" onclick="">Login</button>
                            </div>
                        </div>
                    </form>   
                </div>
            </div>
        </div>
        <script>$('.alert').alert();</script>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <%
            if (status != null) {
                if (status.equalsIgnoreCase("Cek Email Untuk Verifikasi Akun !") || status.equalsIgnoreCase("Email Reset Password Telah Dikirimkan!") || status.equalsIgnoreCase("Password Sudah Dirubah") || status.equalsIgnoreCase("Akun Anda Telah Aktif")) {
                    out.println("<script type=\"text/javascript\">;");
                    out.println("swal(\"Good job!\", \"" + status + "\", \"success\");");
                    out.println("</script>;");
                } else {
                    out.println("<script type=\"text/javascript\">;");
                    out.println("swal(\"Oops!\", \"" + status + "\", \"error\");");
                    out.println("</script>;");
                }
            }
        %>

    </body>
</html>
<%
    }
    session.removeAttribute("status");
%>
