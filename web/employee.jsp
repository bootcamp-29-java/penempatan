<%-- 
    Document   : employee
    Created on : Sep 11, 2019, 10:40:49 PM
    Author     : ASUS
--%>

<%@page import="models.EmployeeRole"%>
<%@page import="models.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
<!DOCTYPE html>

<%
    List<EmployeeRole> logSession = (List<EmployeeRole>) session.getAttribute("sessionlogin");
    List<Employee> employees = (List<Employee>) session.getAttribute("employees1");
    String genId = (String) session.getAttribute("genId");
    String status = (String) session.getAttribute("status");
    out.print(status);
    if (logSession == null) {
        out.print(logSession);
        out.println("<script>alert('Anda belum login!')</script>");
        out.println("<script>window.location.href=\"admin/login.jsp\"</script>");
    } else if (employees == null) {
        response.sendRedirect("employeeservlet1");
    } else {
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>

        <link rel="stylesheett" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
        <link rel="stylesheett" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">




    </head>

    <body>
        <div class="container">
            <!--Card atas-->
            <div class="card w-100" style="margin-top: 20px;">
                <h5 class="card-header">Add Employee </h5>
                <div class="card-body">
                    <h5 class="card-title">Input Employee</h5>
                    <p class="card-text">You can input employee data in here</p>
                    <button type="button" class="btn btn-primary" onclick="getData('<%=genId%>', '', '', '', '', '', '', '', '', '', '')" data-toggle="modal" data-target="#addEmployee">
                        Add Employee
                    </button>
                </div>
            </div>
        </div>
        <!--card atas-->
        <br>
        <div class="card ">
            <h5 class="card-header">List Employee Account</h5>
            <div class="card-body">
                <table id="example" class="table table-striped table-bordered" style="width:100%">
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
                            <th scope="col">Edit</th>
                            <th scope="col">Delete</th>
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
                            <td>
                                <button onclick="getData('<%=empl.getId()%>', '<%=empl.getFirstName()%>', '<%=empl.getLastName()%>', '<%=empl.getEmail()%>', '<%=empl.getPhone()%>', '<%=empl.getBirthPlace()%>', '<%=empl.getBirthDate()%>', '<%=empl.getGender()%>'
                                                , '<%=empl.getNationality()%>', '<%=empl.getPhoto()%>', '<%=empl.getReligion()%>')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addEmployee">
                                    EDIT</button>
                            </td>
                            <td><button onclick='setAlert("<%=empl.getId()%>")' class="btn btn-danger">HAPUS</button></td>
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
    <!--Modal-->
    <div class="modal fade" id="addEmployee" tabindex="-1" role="dialog" aria-labelledby="addEmployeeAccount" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalCenterTitle">Create Employee</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="employeeservlet1" method="POST">
                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label for="inputEmail4">ID</label>
                                <input type="number" class="form-control" id="id" name="id" placeholder="ID" value="">
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
                        <div class="form-group">
                            <label for="inputAddress">Phone</label>
                            <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone Number">
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
                            <label for="inputGender">Gender</label>
                            <select id="gender" name="gender" class="form-control">
                                <option value="">-Pilih-</option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="inputNationality">Nationality</label>
                            <select id="nationality" name="nationality" class="form-control">
                                <option value="">-Pilih-</option>
                                <option value="WNI">WNI</option>
                                <option value="WNA">WNA</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="inputReligion">Religion</label>
                            <select id="religion" name="religion" class="form-control">
                                <option value="">-Pilih-</option>
                                <option value="Islam">Islam</option>
                                <option value="Kristen">Kristen</option>
                                <option value="Katolik">Katolik</option>
                                <option value="Hindu">Hindu</option>
                                <option value="Budha">Budha</option>
                            </select>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary" value="save">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>

    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <script>
                                function getData(id, firstName, lastName, email, phone, birthPlace, birthDate, gender, nationality, photo, religion) {
                                    document.getElementById("id").value = id;
                                    document.getElementById("firstName").value = firstName;
                                    document.getElementById("lastName").value = lastName;
                                    document.getElementById("email").value = email;
                                    document.getElementById("phone").value = phone;
                                    document.getElementById("birthPlace").value = birthPlace;
                                    document.getElementById("birthDate").value = birthDate;
                                    document.getElementById("gender").value = gender;
                                    document.getElementById("nationality").value = nationality;
                                    document.getElementById("religion").value = religion;
                                    document.getElementById("photo").value = photo;
                                    console.log(regionid);
                                    if (id !== '') {
                                        document.getElementById("id").readOnly = true;
                                    } else {
                                        document.getElementById("id").readOnly = false;
                                    }
                                }
    </script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#example').DataTable();
        });
    </script>

    <%
        if (status != null) {
            if (status.equalsIgnoreCase("Save data berhasil") || status.equalsIgnoreCase("Delete data berhasil")) {
                out.println("<script type=\"text/javascript\">;");
                out.println("swal(\"Good job!\", \"" + status + "\", \"success\");");
                out.println("</script>;");
            } else {
                out.println("<script type=\"text/javascript\">;");
                out.println("swal(\"GAGAL!\", \"" + status + "\", \"error\");");
                out.println("</script>;");
            }
        }
    %>

    <script>
        function setAlert(id) {
            swal({
                title: "Apakah Anda Yakin?",
                text: "Tekan Ok, Jika Anda Yakin Untuk Menghapus Data!",
                icon: "warning",
                buttons: true,
                dangerMode: true
            }).then((willDelete) => {
                if (willDelete) {
                    window.location.href = "employeeservlet1?action=delete&&id=" + id;
                } else {
                    swal("Anda Membatalkan Mengahpus Data!");
                }
            });
        }
    </script>
</body>

</html>
<%
    }

    session.removeAttribute("status");
    session.removeAttribute("employees1");
    session.removeAttribute("genId");
%>