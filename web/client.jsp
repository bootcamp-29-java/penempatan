<%@page import="models.Client"%>
<%@page import="java.util.List"%>
<%@include file = "header.jsp" %>

<%
    List<Client> cli = (List<Client>) session.getAttribute("Clients");

    if (cli == null) {
        response.sendRedirect("clientservlet");
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
        <!--card atas-->
        <div class="container">
            <div class="card w-100" style="margin-top: 20px;">
                <h5 class="card-header">Create Client</h5>
                <div class="card-body">
                    <h5 class="card-title">Input Client</h5>
                    <p class="card-text">You can input new client data in here</p>
                    <button type="button" onclick="getData('','','')" class="btn btn-primary" data-toggle="modal" data-target="#addClient">
                        Add Client    
                    </button>
                </div>
            </div>
            <br>
            <div class="card">
                <h5 class="card-header">List Employee Role</h5>
                <div class="card-body">
                    <table id="example" class="table table-striped table-bordered" style="width:100%">
                        
                </table>
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Name</th>
                                <th scope="col">Location</th>
                                <th scope="col">Edit</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%                            for (Client empl : cli) {
                            %>
                            <tr>
                                <td scope="row"><%=empl.getId()%></td>
                                <td scope="row"><%=empl.getName()%></td>
                                <td scope="row"><%=empl.getLocation()%></td>
                                <td>
                                    <button onclick="getData('<%=empl.getId()%>','<%=empl.getName()%>','<%=empl.getLocation()%>')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addClient">
                                        EDIT</button>
                                </td>
                                <td><button onclick="" type=""class="btn btn-danger">HAPUS</button></td>
                            </tr>
                            <%
                                }
                            %>
                            </div> 
                            <!--card atas-->

                            <!--table here-->

                        <div class="modal fade" id="addClient" tabindex="-1" role="dialog" aria-labelledby="addEmployeeAccount" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-scrollable" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalCenterTitle">Create Client</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form action="clientservlet" method="POST">
                                            <div class="form-row">
                                                <div class="form-group col-md-12">
                                                    <label for="inputDI">ID</label>
                                                    <input type="number" class="form-control" id="id" name="id" placeholder="ID" value="">
                                                </div>
                                                <div class="form-group col-md-12">
                                                    <label for="inputName">Name</label>
                                                    <input type="text" class="form-control" id="name" name="name" placeholder="Name" value="">
                                                </div>
                                                <div class="form-group col-md-12">
                                                    <label for="inputLocation">Location</label>
                                                    <input type="text" class="form-control" id="location" name="location    " placeholder="Location" value="">
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-primary">Add Client</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
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
        <script>
            function getData(id, name, location) {
                document.getElementById("id").value = id;
                document.getElementById("name").value = name;
                document.getElementById("location").value = location;
              

                if (id !== '') {
                    document.getElementById("id").readOnly = true;
                } else {
                    document.getElementById("id").readOnly = false;
                }
            }
            </script>
    </body>
</html>
<%
    }
%>
