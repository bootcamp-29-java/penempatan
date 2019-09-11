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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Login</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row justify-content-center align-items-center" style="height:100vh">
                <div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">
                    <form action="../loginservlet" method="POST" id="loginForm" autocomplete="off">

                        <div class="form-group">
                            <h3><p align="center">LOGIN</h3>
                            <div class="form-group">
                                <input class="form-control form-control-lg" placeholder="E-mail" type="text" onchange="" name="email">
                            </div>

                            <div class="form-group mb-2">
                                <input class="form-control form-control-lg" placeholder="Password" type="password" name="password">
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
