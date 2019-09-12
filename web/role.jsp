<%-- 
    Document   : Role
    Created on : Sep 11, 2019, 10:50:24 PM
    Author     : ASUS
--%>

<%@page import="models.Employee"%>
<%@page import="models.Role"%>
<%@page import="models.EmployeeRole"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
<!DOCTYPE html>

<%
    List<EmployeeRole> employeesRole = (List<EmployeeRole>) session.getAttribute("employeesRole");
    List<Role> roles = (List<Role>) session.getAttribute("roles");
    List<Employee> employees = (List<Employee>) session.getAttribute("employees");

    if (employeesRole == null || roles == null) {
        response.sendRedirect("roleservlet");
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
    </head>

    <body>
        <!--Card atas-->
        <div class="container">
            <div class="card w-100" style="margin-top: 20px;">
                <h5 class="card-header">Create Role</h5>
                <div class="card-body">
                    <h5 class="card-title">Input New Role</h5>
                    <p class="card-text">You can input new role data in here</p>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addEmployeeRole">
                        Add Employee Role   
                    </button>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addRole">
                        Add Role   
                    </button>
                </div>
            </div>
            <br>
            <div class="card w-100">
                <h5 class="card-header">List Employee Role</h5>
                <div class="card-body">
                    <table id="example" class="table table-striped table-bordered" style="width:100%">
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
                                <td>
                                    <button onclick="" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                                        EDIT</button>
                                </td>
                                <td><button onclick="" type=""class="btn btn-danger">HAPUS</button></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <!--DATA TABLE HERE-->
                </div>
            </div>
            <div class="card w-100">
                <h5 class="card-header">List Employee Role</h5>
                <div class="card-body">
                    <table id="example" class="table table-striped table-bordered" style="width:100%">
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
                                for (Role empl : roles) {
                            %>
                            <tr>
                                <td scope="row"><%=empl.getId()%></td>
                                <td scope="row"><%=empl.getName()%></td>
                                <td>
                                    <button onclick="" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                                        EDIT</button>
                                </td>
                                <td><button onclick="" type=""class="btn btn-danger">HAPUS</button></td>
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
                        <form>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputID">ID</label>
                                    <input type="number" class="form-control" id="id" name="id" placeholder="ID" value="">
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

                                <button type="submit" class="btn btn-primary">Add Employee Role</button>
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
                        <form action="registerservlet" method="POST">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputID">ID</label>
                                    <input type="number" class="form-control" id="id" name="id" placeholder="ID" value="">
                                </div>
                                <div class="form-group col-md-12">
                                    <label for="inputName">Name</label>
                                    <input type="text" class="form-control" id="name" name="name" placeholder="Role Nmae" value="">
                                </div>

                            </div>


                            <div class="modal-footer">

                                <button type="submit" class="btn btn-primary">Add Role</button>
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

        <script type="text/javascript">
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>

    </body>
</html>
<%
    }
%>