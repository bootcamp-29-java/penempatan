<%-- 
    Document   : index
    Created on : Sep 11, 2019, 7:48:37 AM
    Author     : Lenovo
--%>

<%@page import="models.Account"%>
<%@page import="models.Employee"%>
<%@page import="models.EmployeeRole"%>
<%@page import="java.util.List"%>
<%@include file = "header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<EmployeeRole> logSession = (List<EmployeeRole>) session.getAttribute("sessionlogin");
    List<Account> accounts = (List<Account>) session.getAttribute("accounts");
    String status = (String) session.getAttribute("status2");
    out.print(status);
    if (logSession == null) {
        out.print(logSession);
        out.println("<script>alert('Anda belum login!')</script>");
        out.println("<script>window.location.href=\"admin/login.jsp\"</script>");
    } else if (accounts == null) {
        response.sendRedirect("accountservlet");
    } else {
%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body>
        <!-- Pemanggilan-->
<!--        <div class="container">
            <div class="card w-100" style="margin-top: 20px;">
                <h5 class="card-header">Create Employee Account</h5>
                <div class="card-body">
                    <h5 class="card-title">Input New Employee</h5>
                    <p class="card-text">You can input new employee data in here</p>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addEmployee">
                        Launch demo modal
                    </button>
                </div>
            </div>
            <br>
        </div>-->
        <div class="card w-100">
            <h5 class="card-header">List Account</h5>
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">First Name</th>
                            <th scope="col">Last Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Status Account</th>
                            <th scope="col">Reset Password</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Account empl : accounts) {
                        %>
                        <tr>
                            <td scope="row"><%=empl.getId()%></td>
                            <td scope="row"><%=empl.getEmployee().getFirstName()%></td>
                            <td scope="row"><%=empl.getEmployee().getLastName()%></td>
                            <td scope="row"><%=empl.getEmployee().getEmail()%></td>
                            <td scope="row"><%=empl.getStatus().getName()%></td>
                            <td><button onclick='setAlert("<%=empl.getId()%>","<%=empl.getEmployee().getEmail()%>","<%=empl.getEmployee().getFirstName()%>","<%=empl.getEmployee().getLastName()%>")' type="button" class="btn btn-primary" data-toggle="" data-target="">Send Email</button></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
                <!--DATA TABLE HERE-->
            </div>
        </div>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

        <%
            if (status != null) {
                if (status.equalsIgnoreCase("Login Berhasil") || status.equalsIgnoreCase("Save data berhasil")) {
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

        <script>
            function setAlert(id, email, first, last) {
                swal({
                    title: "Kirim Email Reset Password?",
                    text: "Tekan Ok, Jika Anda Yakin Untuk Mengirim!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true
                }).then((willDelete) => {
                    if (willDelete) {
                        window.location.href = "accountservlet?action=sendReset&&id=" + id + "&&email=" + email + "&&firstName=" + first + "&&lastName=" + last;
                    } else {
                        swal("Anda Membatalkan Mengirim Email!");
                    }
                });
            }
        </script>
    </body>
</html>

<%
    }

    session.removeAttribute("status2");
    session.removeAttribute("accounts");
%>
