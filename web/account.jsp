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
    String status = (String) session.getAttribute("status");
    out.print(status);
    if (logSession == null) {
        out.print(logSession);
        out.println("<script>alert('Anda belum login!')</script>");
        out.println("<script>window.location.href=\"admin/login.jsp\"</script>");
    } else if (accounts == null) {
        response.sendRedirect("accountservlet");
    } else {
        if(logSession.contains("4")||logSession.contains("")||logSession.contains("3")||logSession.contains("2")){
            out.println("<script>alert('Anda Tidak Memiliki Akses Ke Menu Ini!')</script>");
            out.println("<script>window.location.href=\"participant.jsp\"</script>");
        }
        else{
%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script></head>
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
        <div class="container">
            <div class="card w-100">
                <h5 class="card-header text-center">List Account</h5>
                <div class="card-body">
                    <table class="table table-hover table-sm">
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
                                <td><button onclick='setAlert("<%=empl.getId()%>", "<%=empl.getEmployee().getEmail()%>", "<%=empl.getEmployee().getFirstName()%>", "<%=empl.getEmployee().getLastName()%>")' type="button" class="btn btn-unique" data-toggle="" data-target="">Send Email</button></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <!--DATA TABLE HERE-->
                </div>
            </div>
        </div>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

        <%
            if (status != null) {
                if (status.equalsIgnoreCase("Login Berhasil") || status.equalsIgnoreCase("Save data berhasil") || status.equalsIgnoreCase("Email Berhasil Dikirimkan")) {
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
    }
    session.removeAttribute("status");
    session.removeAttribute("accounts");
%>
