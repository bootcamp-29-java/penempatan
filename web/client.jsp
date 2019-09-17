<%@page import="models.EmployeeRole"%>
<%@page import="models.Client"%>
<%@page import="java.util.List"%>
<%@include file = "header.jsp" %>

<%
    List<EmployeeRole> logSession = (List<EmployeeRole>) session.getAttribute("sessionlogin");
    List<Client> cli = (List<Client>) session.getAttribute("clients");
    String status = (String) session.getAttribute("status");
    String genId = (String) session.getAttribute("genCId");

    if (logSession == null) {
        out.print(logSession);
        out.println("<script>alert('Anda belum login!')</script>");
        out.println("<script>window.location.href=\"admin/login.jsp\"</script>");
    } else if (cli == null || genId == null) {
        response.sendRedirect("clientservlet");
    } else {
        if(logSession.contains("1")||logSession.contains("4")){
            out.println("<script>alert('Anda Tidak Memiliki Akses Ke Menu Ini!')</script>");
            out.println("<script>window.location.href=\"participant.jsp\"</script>");
        }
        else{
%>
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
        <!--card atas-->
        <div class="container">
            <% if(logSession.contains("1")||logSession.contains("4")){ %>
            <div class="card w-100 " style="margin-top: 20px;">
                <h5 class="card-header ">Create Client</h5>
                <div class="card-body">
                    <h5 class="card-title">Input Client</h5>
                    <p class="card-text">You can input new client data in here</p>
                    <button type="button" onclick="getData('<%=genId%>', '', '')" class="btn btn-primary" data-toggle="modal" data-target="#addClient">
                        Add Client    
                    </button>
                </div>
            </div>
            <% } %>
            <br>
            <div class="card">
                <h5 class="card-header text-center">List Client</h5>
                <div class="card-body">
                    <table id="example" class="table table-striped table-bordered" style="width:100%">


                        <thead>
                            <tr class="text-center">
                                <th scope="col">ID</th>
                                <th scope="col">Name</th>
                                <th scope="col">Location</th>
                                <th scope="col">Edit</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Client empl : cli) {%>
                            <tr>
                                <td scope="row" class="text-center"><%=empl.getId()%></td>
                                <td scope="row" ><%=empl.getName()%></td>
                                <td scope="row"><%=empl.getLocation()%></td>
                                <td class="text-center">
                                <% if(logSession.contains("1")||logSession.contains("4")){
                                    <button onclick="getData('<%=empl.getId()%>', '<%=empl.getName()%>', '<%=empl.getLocation()%>')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addClient">
                                       <i class="far fa-edit"></i> EDIT</button>
                                </td>
                                <td class="text-center"><button onclick='setAlert(<%=empl.getId()%>)' type=""class="btn btn-danger"><i class="far fa-trash-alt"></i> HAPUS</button></td>
                                <% } %>
                            </tr>
                            <% } %>
                            </div> 
                    </table>
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
                                                <input type="text" class="form-control" id="location" name="location" placeholder="Location" value="">
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
            function setAlert(id) {
                swal({
                    title: "Apakah Anda Yakin?",
                    text: "Tekan Ok, Jika Anda Yakin Untuk Menghapus Data!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true
                }).then((willDelete) => {
                    if (willDelete) {
                        window.location.href = "clientservlet?action=delete&&id=" + id;
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
    request.removeAttribute("clients");
    request.removeAttribute("status");
    request.removeAttribute("genCId");
%>
