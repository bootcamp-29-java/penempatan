<%-- 
    Document   : employee
    Created on : Sep 11, 2019, 10:40:49 PM
    Author     : ASUS
--%>

<%@page import="models.Participant"%>
<%@page import="models.Client"%>
<%@page import="java.util.List"%>
<%@page import="models.Interview"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
<!DOCTYPE html>

<%
    List<Interview> interviews = (List<Interview>) session.getAttribute("interviews");
    List<Participant> participants = (List<Participant>) session.getAttribute("participants");
    List<Client> clients = (List<Client>) session.getAttribute("clients");

    if (interviews == null) {
        response.sendRedirect("interviewservlet");
    } else {
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.7/css/select2.min.css" rel="stylesheet" />
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.7/js/select2.min.js"></script>
    </head>

    <body>
        <!--card atas-->
        <div class="container">
            <div class="card w-100" style="margin-top: 20px;">
                <h5 class="card-header">Create Interview</h5>
                <div class="card-body">
                    <h5 class="card-title">Input New Interview</h5>
                    <p class="card-text">You can input new interview data in here</p>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addInterview">
                        Add Interview  
                    </button>
                </div>
            </div>
        </div>
        <div class="card w-100">
            <h5 class="card-header">List Employee Role</h5>
            <div class="card-body">
                <table id="example" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Date Time</th>
                            <th scope="col">Location</th>
                            <th scope="col">Department</th>
                            <th scope="col">PIC</th>
                            <th scope="col">Participant</th>
                            <th scope="col">Client Name</th>
                            <th scope="col">Edit</th>
                            <th scope="col">Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Interview empl : interviews) {
                        %>
                        <tr>
                            <td scope="row"><%=empl.getId()%></td>
                            <td scope="row"><%=empl.getDateTime()%></td>
                            <td scope="row"><%=empl.getLocation()%></td>
                            <td scope="row"><%=empl.getDepartment()%></td>
                            <td scope="row"><%=empl.getPic()%></td>
                            <td scope="row"><%=empl.getParticipant().getEmployee().getFirstName()%></td>
                            <td scope="row"><%=empl.getClient().getName()%></td>
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
        <!--card atas-->

        <!--table here-->

        <div class="modal fade" id="addInterview"  role="dialog" aria-labelledby="addEmployeeAccount" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Create Interview</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputID">ID</label>
                                    <input type="number" class="form-control" id="id" name="id" placeholder="ID" value="">
                                </div>
                            </div>

                            <div class="form-group ">
                                <label>Date Time</label>
                                <input type="date" class="form-control" id="firstName" name="firstName">
                            </div>

                            <div class="form-group">
                                <label for="inputLocation">Location</label>
                                <input type="text" class="form-control" id="location" name="location" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="inputDepartment">Department</label>
                                <input type="text" class="form-control" id="department" name="location" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="inputPic">PIC</label>
                                <input type="text" class="form-control" id="pic" name="pic" placeholder="">
                            </div>

                            <div class="form-group">
                                <label for="inputGender">Participant</label>
                                <select id="provinsi" name="provinsi" class="form-control">
                                    <option value="">-Pilih-</option>
                                    <%for (Participant p : participants) { %>
                                    <option value="<%=p.getId()%>" ><%=p.getId()%> - <%=p.getEmployee().getFirstName()%></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="inputNationality">Client</label>
                                <select id="dor" name="provinsi" class="form-control">
                                    <option ></option>
                                    <%for (Client c : clients) { %>
                                    <option value="<%=c.getId()%>" ><%=c.getId()%> - <%=c.getName()%></option>
                                    <% } %>
                                </select>
                            </div>


                            <div class="modal-footer">

                                <button type="submit" class="btn btn-primary">Add Interview</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#provinsi').select2({
                    placeholder: 'Participant',
                    allowClear: true
                });
            });
        </script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#dor').select2({
                    placeholder: 'Client',
                    allowClear: true
                });
            });
        </script>
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