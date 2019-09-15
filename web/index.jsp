<%-- 
    Document   : index
    Created on : Sep 11, 2019, 7:48:37 AM
    Author     : Lenovo
--%>

<%@page import="models.Employee"%>
<%@page import="models.EmployeeRole"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<EmployeeRole> logSession = (List<EmployeeRole>) session.getAttribute("sessionlogin");
    String employeeId = (String) session.getAttribute("employeeId");
    List<Employee> employees = (List<Employee>) session.getAttribute("employees");
    String status = (String) session.getAttribute("status");
    out.print(status);
    if (logSession == null) {
        out.print(logSession);
        out.println("<script>alert('Anda belum login!')</script>");
        out.println("<script>window.location.href=\"admin/login.jsp\"</script>");
    } else if (employees == null) {
        response.sendRedirect("employeeservlet");
    } else {
%>
<%@include file = "header.jsp" %>
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
            <h5 class="card-header">List Employee Account</h5>
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">First Name</th>
                            <th scope="col">Last Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Birth Place</th>
                            <th scope="col">Birth Date</th>
                            <th scope="col">Gender</th>
                            <th scope="col">Nationality</th>
                            <th scope="col">Photo</th>
                            <th scope="col">Religion</th>
                            <th scope="col">Phone Number</th>
                            <th scope="col">Account Status</th>
                            <th scope="col">Create Account</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Employee empl : employees) {
                        %>
                        <tr>
                            <td scope="row"><%=empl.getId()%></td>
                            <td scope="row"><%=empl.getFirstName()%></td>
                            <td scope="row"><%=empl.getLastName()%></td>
                            <td scope="row"><%=empl.getEmail()%></td>
                            <td scope="row"><%=empl.getBirthPlace()%></td>
                            <td scope="row"><%=empl.getBirthDate()%></td>
                            <td scope="row"><%=empl.getGender()%></td>
                            <td scope="row"><%=empl.getNationality()%></td>
                            <td scope="row"><%=empl.getPhoto()%></td>
                            <td scope="row"><%=empl.getReligion()%></td>
                            <td scope="row"><%=empl.getPhone()%></td>
                            <%String statusAccount = (empl.getAccount() == null) ? "Belum Punya Akun" : empl.getAccount().getStatus().getName();%>
                            <td scope="row"><%=statusAccount%></td>
                            <td><button onclick='setAlertKirim("<%=empl.getId()%>","<%=empl.getEmail()%>","<%=empl.getFirstName()%>","<%=empl.getLastName()%>")' type="button" class="btn btn-primary" data-toggle="" data-target="" <%if (!statusAccount.equals("Belum Punya Akun")) {%> disabled <% } %> >Send Email</button></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
                <!--DATA TABLE HERE-->
            </div>
        </div>


        <!-- Button trigger modal -->


        <!-- Modal -->
<!--        <div class="modal fade" id="addEmployee" tabindex="-1" role="dialog" aria-labelledby="addEmployeeAccount" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Create Employee Account</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="registerservlet" method="POST">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputEmail4">ID</label>
                                    <input type="number" class="form-control" id="id" name="id" placeholder="First Name" value="<%=employeeId%>">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputEmail4">First Name</label>
                                    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputPassword4">Last Name</label>
                                    <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputAddress">Email</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="yourmail@example.com">
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputEmail4">Birth Place</label>
                                    <input type="text" id="birthPlace" name="birthPlace" class="form-control" placeholder="Birth Place">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputPassword4">Birth Date</label>
                                    <input type="date" id="birthDate" name="birthDate" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputState">Gender</label>
                                <select id="gender" name="gender" class="form-control">
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="inputState">Nationality</label>
                                <select id="nationality" name="nationality" class="form-control">
                                    <option value="WNI">WNI</option>
                                    <option value="WNA">WNA</option>
                                </select>
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Create Account</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>-->
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
            function setAlertKirim(id, email, first, last) {
                swal({
                    title: "Kirim Email Verifikasi Account?",
                    text: "Tekan Ok, Jika Anda Yakin Untuk Mengirim!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true
                }).then((willDelete) => {
                    if (willDelete) {
                        window.location.href = "registerservlet?action=sendEmail&&id=" + id + "&&email=" + email + "&&firstName=" + first + "&&lastName=" + last;
                    } else {
                        swal("Anda Membatalkan Mengirim Email!");
                    }
                });
            }
        </script>
    </body>
</html>

<%
    session.removeAttribute("status");
    }

    session.removeAttribute("employees");
    session.removeAttribute("employeeId");
%>
