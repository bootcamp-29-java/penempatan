<%@page import="models.Employee"%>
<%@page import="models.Role"%>
<%@page import="models.EmployeeRole"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
<!DOCTYPE html>

<%
    List<EmployeeRole> logSession = (List<EmployeeRole>) session.getAttribute("sessionlogin");
    List<EmployeeRole> employeesRole = (List<EmployeeRole>) session.getAttribute("employeesRole");
    List<Role> roles = (List<Role>) session.getAttribute("roles");
    List<Employee> employees = (List<Employee>) session.getAttribute("employees");
    String status = (String) session.getAttribute("status");
    String generateIdERole = (String) session.getAttribute("generateIdERole");
    String generateIdRole = (String) session.getAttribute("generateIdRole");
    out.print(status);

    if (logSession == null) {
        out.print(logSession);
        out.println("<script>alert('Anda belum login!')</script>");
        out.println("<script>window.location.href=\"admin/login.jsp\"</script>");
    } else if (roles == null || employeesRole == null || employees == null || generateIdERole == null || generateIdRole == null) {
        response.sendRedirect("roleservlet");
    } else {
        if(logSession.contains("")||logSession.contains("3")||logSession.contains("2")){
            out.println("<script>alert('Anda Tidak Memiliki Akses Ke Menu Ini!')</script>");
            out.println("<script>window.location.href=\"index.jsp\"</script>");
        }
        else{
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Role</title>
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
        <!--Card atas-->
        <div class="container">
            <% if(logSession.contains("1")){ %>
            <div class="card w-100" style="margin-top: 20px;">
                <h5 class="card-header">Create Role</h5>
                <div class="card-body">
                    <h5 class="card-title">Input New Role</h5>
                    <p class="card-text">You can input new role data in here</p>
                    <button onclick="getDataERole('<%=generateIdERole%>','','')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addEmployeeRole">
                        Add Employee Role   
                    </button>
                    <button onclick="getDataRole('<%=generateIdRole%>','')" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addRole">
                        Add Role   
                    </button>
                </div>
            </div>
            <% } %>
            <br>

            <div class="card w-100">
                <h5 class="card-header text-center">List Employee Role</h5>
                <div class="card-body">
                    <table id="example" class="table table-hover table-sm table-bordered" style="width:100%">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Employee ID</th>
                                <th scope="col">Employee Name</th>
                                <th scope="col">Role</th>
                                <th scope="col">Edit</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (EmployeeRole empl : employeesRole) {
                            %>
                            <tr>
                                <td scope="row"><%=empl.getId()%></td>
                                <td scope="row"><%=empl.getEmployee().getId()%></td>
                                <td scope="row"><%=empl.getEmployee().getFirstName()%></td>
                                <td scope="row"><%=empl.getRole().getName()%></td>
                                <td class="text-center">
                                <% if(logSession.contains("1")) { %>
                                    <button onclick="getDataERole('<%=empl.getId()%>', '<%=empl.getEmployee().getId()%>', '<%=empl.getRole().getId()%>')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addEmployeeRole"><i class="far fa-edit"></i>
                                         EDIT</button>
                                </td>
                                <td class="text-center"><button onclick='setAlertERole("<%=empl.getId()%>")' type=""class="btn btn-danger"><i class="far fa-trash-alt"></i> HAPUS</button></td>
                                <% } %>
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

            <br>
            <div class="container">
            <div class="card w-100">
                <h5 class="card-header">List Role</h5>
                <div class="card-body">
                    <table id="example1" class="table table-hover table-sm table-bordered" style="width:100%">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Name</th>
                                <th scope="col">Edit</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Role role : roles) {
                            %>
                            <tr>
                                <td scope="row"><%=role.getId()%></td>
                                <td scope="row"><%=role.getName()%></td>
                                <td class="text-center">
                                    <button onclick="getDataRole('<%=role.getId()%>', '<%=role.getName()%>')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addRole">
                                        <i class="far fa-edit"></i> EDIT</button>
                                </td>
                                <td class="text-center"><button onclick='setAlertRole("<%=role.getId()%>")' type=""class="btn btn-danger"><i class="far fa-trash-alt"></i> HAPUS</button></td>
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


        <!--card atas-->

        <!--disini table-->

        <div class="modal fade" id="addEmployeeRole" tabindex="-1" role="dialog" aria-labelledby="addEmployeeAccount" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Create Role</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="employeeroleservlet" method="POST">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputID">ID</label>
                                    <input type="number" class="form-control" id="idERole" name="idERole" placeholder="ID" value="">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputEmployee">Employee</label>
                                    <select id="employee" name="employee" class="form-control">
                                        <option value="">-Pilih-</option>
                                        <%for (Employee e : employees) {%>
                                        <option value="<%=e.getId()%>" ><%=e.getId()%> - <%=e.getFirstName()%></option>
                                        <% } %>
                                    </select>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputRole">Role</label>
                                    <select id="role" name="role" class="form-control">
                                        <option value="">-Pilih-</option>
                                        <%for (Role r : roles) {%>
                                        <option value="<%=r.getId()%>" ><%=r.getId()%> - <%=r.getName()%></option>
                                        <% } %>
                                    </select>
                                </div>
                            </div>


                            <div class="modal-footer">

                                <button type="submit" class="btn btn-primary">Save Employee Role</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#employee').select2({
                    placeholder: 'Employee',
                    allowClear: true
                });
            });
        </script>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#role').select2({
                    placeholder: 'Role',
                    allowClear: true
                });
            });
        </script>


        <div class="modal fade" id="addRole" tabindex="-1" role="dialog" aria-labelledby="addEmployeeAccount" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Create Role</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="roleservlet" method="POST">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputID">ID</label>
                                    <input type="number" class="form-control" id="idRole" name="role_id" placeholder="ID" value="">
                                </div>
                                <div class="form-group col-md-12">
                                    <label for="inputName">Name</label>
                                    <input type="text" class="form-control" id="nameRole" name="role_name" placeholder="Role Name" value="">
                                </div>

                            </div>


                            <div class="modal-footer">

                                <button type="submit" class="btn btn-primary">Save Role</button>
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
            function getDataERole(id, employee, role) {
                document.getElementById("idERole").value = id;
                document.getElementById("employee").value = employee;
                document.getElementById("role").value = role;

                if (id !== '') {
                    document.getElementById("id").readOnly = true;
                } else {
                    document.getElementById("id").readOnly = false;
                }
            }

            function getDataRole(id, role) {
                document.getElementById("idRole").value = id;
                document.getElementById("nameRole").value = role;

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
        <script type="text/javascript">
            $(document).ready(function () {
                $('#example1').DataTable();
            });
        </script>

        <%
            if (status != null) {
                if (status.equalsIgnoreCase("Data Berhasil Disimpan") || status.equalsIgnoreCase("Data Berhasil Dihapus")) {
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
            function setAlertRole(id) {
                swal({
                    title: "Apakah Anda Yakin?",
                    text: "Tekan Ok, Jika Anda Yakin Untuk Menghapus Data!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true
                }).then((willDelete) => {
                    if (willDelete) {
                        window.location.href = "roleservlet?action=delete&&id=" + id;
                    } else {
                        swal("Anda Membatalkan Mengahpus Data!");
                    }
                });
            }
        </script>

        <script>
            function setAlertERole(id) {
                swal({
                    title: "Apakah Anda Yakin?",
                    text: "Tekan Ok, Jika Anda Yakin Untuk Menghapus Data!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true
                }).then((willDelete) => {
                    if (willDelete) {
                        window.location.href = "employeeroleservlet?action=delete&&id=" + id;
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
    }
    session.removeAttribute("status");
    session.removeAttribute("roles");
    session.removeAttribute("employees");
    session.removeAttribute("employeesRole");
    session.removeAttribute("generateIdERole");
    session.removeAttribute("generateIdRole");
%>