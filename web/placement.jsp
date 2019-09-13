<%-- 
    Document   : employee
    Created on : Sep 11, 2019, 10:40:49 PM
    Author     : ASUS
--%>

<%@page import="models.Client"%>
<%@page import="models.Participant"%>
<%@page import="java.util.List"%>
<%@page import="models.Placement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
<!DOCTYPE html>

<%
    List<Placement> placements = (List<Placement>) session.getAttribute("placements");
    List<Participant> participants = (List<Participant>) session.getAttribute("participants");
    List<Client> clients = (List<Client>) session.getAttribute("clients");

    if (placements == null) {
        response.sendRedirect("placementservlet");
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
                <h5 class="card-header">Create Placement</h5>
                <div class="card-body">
                    <h5 class="card-title">Input New Placement</h5>
                    <p class="card-text">You can input new placement data in here</p>
                    <button type="button" onclick="getData('','','','','','','','','')" class="btn btn-primary" data-toggle="modal" data-target="#addPlacement">
                        Add Placement   
                    </button>
                </div>
            </div>
            <h5 class="card-header">List Employee Role</h5>
            <div class="card-body">
                <table id="example" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Client Name</th>
                            <th scope="col">Participant</th>
                            <th scope="col">Start Date</th>
                            <th scope="col">End Date</th>
                            <th scope="col">Position</th>
                            <th scope="col">Department</th>
                            <th scope="col">Edit</th>
                            <th scope="col">Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Placement empl : placements) {
                        %>
                        <tr>
                            <td scope="row"><%=empl.getId()%></td>
                            <td scope="row"><%=empl.getClient().getName()%></td>
                            <td scope="row"><%=empl.getParticipant().getEmployee().getFirstName()%></td>
                            <td scope="row"><%=(empl.getStartDate() == null) ? "" : empl.getStartDate()%></td>
                            <td scope="row"><%=(empl.getEndDate() == null) ? "" : empl.getEndDate()%></td>
                            <td scope="row"><%=(empl.getPosition() == null) ? "" : empl.getPosition()%></td>
                            <td scope="row"><%=(empl.getDepartment() == null) ? "" : empl.getDepartment()%></td>
                            <td> 
                                <button onclick="getData('<%=empl.getId()%>', '<%=(empl.getStartDate() == null) ? "" : empl.getStartDate()%>',
                                                '<%=(empl.getEndDate() == null) ? "" : empl.getEndDate()%>', '<%=(empl.getPosition() == null) ? "" : empl.getPosition()%>', '<%=(empl.getDepartment() == null) ? "" : empl.getDepartment()%>',
                                                 '<%=empl.getParticipant().getId()%>','<%=empl.getClient().getId()%>')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addPlacement ">
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

        <div class="modal fade" id="addPlacement" role="dialog" aria-labelledby="addEmployeeAccount" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Create Placement</h5>
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
                                    <label for="inputStartDate">Start Date</label>
                                    <input type="date" class="form-control" id="startDate" name="startdate">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputEndDate">End Date</label>
                                    <input type="date" class="form-control" id="endDate" name="enddate">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPosition">Position</label>
                                <input type="text" class="form-control" id="position" name="postion" placeholder="Position">
                            </div>
                            <div class="form-group">
                                <label for="inputDepartment">Department</label>
                                <input type="text" class="form-control" id="department" name="department" placeholder="Department">
                            </div>
                            <div class="form-group">
                                <label for="inputGender">Participant</label>
                                <select id="participant" name="provinsi" class="form-control">
                                    <option value="">-Pilih-</option>
                                    <%for (Participant p : participants) {%>
                                    <option value="<%=p.getId()%>" ><%=p.getId()%> - <%=p.getEmployee().getFirstName()%></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="inputNationality">Client</label>
                                <select id="client" name="provinsi" class="form-control">
                                    <option value="">-Pilih-</option>
                                    <%for (Client c : clients) {%>
                                    <option value="<%=c.getId()%>" ><%=c.getId()%> - <%=c.getName()%></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="modal-footer">

                                <button type="submit" class="btn btn-primary">Add Placement</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!--        <script type="text/javascript">
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
                </script>-->
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>

        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
                                   function getData(id, startDate, endDate, position, department, participant, client) {
                                       document.getElementById("id").value = id;
                                       document.getElementById("startDate").value = startDate;
                                       document.getElementById("endDate").value = endDate;
                                       document.getElementById("position").value = position;
                                       document.getElementById("department").value = department;
                                       document.getElementById("participant").value = participant;
                                       document.getElementById("client").value = client;

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
    </body>
</html>
<%
    }
%>