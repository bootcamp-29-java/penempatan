<%-- 
    Document   : employee
    Created on : Sep 11, 2019, 10:40:49 PM
    Author     : ASUS
--%>

<%@page import="models.EmployeeRole"%>
<%@page import="models.Employee"%>
<%@page import="java.util.List"%>
<%@page import="models.Class"%>
<%@page import="models.Participant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
<!DOCTYPE html>

<%
    List<EmployeeRole> logSession = (List<EmployeeRole>) session.getAttribute("sessionlogin");
    List<Participant> participants = (List<Participant>) session.getAttribute("participants");
    List<Class> classes = (List<Class>) session.getAttribute("classes");
    List<EmployeeRole> employees = (List<EmployeeRole>) session.getAttribute("employees");
    String status = (String) session.getAttribute("status");
    out.print(status);

    if (logSession == null) {
        out.print(logSession);
        out.println("<script>alert('Anda belum login!')</script>");
        out.println("<script>window.location.href=\"admin/login.jsp\"</script>");
    } else if (participants == null || classes == null || employees == null) {
        response.sendRedirect("participantservlet");
    } else {
        if(logSession.contains("3")||logSession.contains("")){
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
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
    </head>

    <body>
        <!--card atas-->
        <div class="container">
            <%if(logSession.contains("2")){ %>
            <div class="card w-100" style="margin-top: 20px;">
                <h5 class="card-header">Create Participant</h5>
                <div class="card-body">
                    <h5 class="card-title">Input New Participant</h5>
                    <p class="card-text">You can input new participant data in here</p>
                    <button type="button" onclick="getData('', '', '')" class="btn btn-primary" data-toggle="modal" data-target="#addParticipant">
                        Add Participant    
                    </button>
                </div>
            </div>
            <% } %>
            <br>
            <div class="card w-100">
                <h5 class="card-header text-center">List Participant</h5>
                <div class="card-body">
                    <table id="example" class="table table-hover table-sm table-bordered" style="width:100%">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Employee Name</th>
                                <th scope="col">Grade</th>
                                <th scope="col">Class</th>
                                <th scope="col">Edit</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Participant empl : participants) {
                            %>
                            <tr>
                                <td scope="row"><%=empl.getId()%></td>
                                <td scope="row"><%=empl.getEmployee().getFirstName()%></td>
                                <td scope="row"><%=(empl.getGrade() == null) ? "" : empl.getGrade()%></td>
                                <td scope="row"><%=(empl.getClass1() == null) ? "" : empl.getClass1().getId()%></td>
                                <td class="text-center">
                                    <button onclick="getData('<%=empl.getId()%>', '<%=(empl.getGrade() == null) ? "" : empl.getGrade()%>', '<%=(empl.getClass1() == null) ? "" : empl.getClass1().getId()%>')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addParticipant">
                                       <i class="far fa-edit"></i> EDIT</button>
                                </td>
                                <td class="text-center"><button onclick='setAlert("<%=empl.getId()%>")' type=""class="btn btn-danger"><i class="far fa-trash-alt"></i> HAPUS</button></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <!--DATA TABLE HERE-->
                </div>
            </div></div>
        <!--card atas-->
        <!--table here-->

        <div class="modal fade" id="addParticipant" role="dialog" aria-labelledby="addEmployeeAccount" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Create Participant</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="participantservlet" method="POST">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputID">ID</label>
                                    <select id="id" name="par_id" class="form-control">
                                        <option value="">-Pilih-</option>
                                        <%for (EmployeeRole e : employees) {%>
                                        <option value="<%=e.getEmployee().getId()%>"><%=e.getEmployee().getId()%> - <%=e.getEmployee().getFirstName()%></option>
                                        <% } %>
                                    </select>
                                </div>

                                <div class="form-group col-md-12">
                                    <label for="inputGrade">Grade</label>
                                    <select id="grade" name="par_grade" class="form-control">
                                        <option value="">-Pilih-</option>
                                        <option value="A">A</option>
                                        <option value="B">B</option>
                                        <option value="C">C</option>
                                    </select>
                                </div>


                                <div class="form-group col-md-12">
                                    <label>Class</label>
                                    <select id="class" name="par_class" class="form-control">
                                        <option value="">-Pilih-</option>
                                        <%for (Class c : classes) {%>
                                        <option value="<%=c.getId()%>" ><%=c.getId()%> - <%=c.getTrainer().getFirstName()%></option>
                                        <% } %>
                                    </select>
                                </div>

                                <div class="modal-footer">

                                    <button type="submit" class="btn btn-primary">Add Participant</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!--        <script type="text/javascript">
                    $(document).ready(function () {
                        $('#class').select2({
                            placeholder: 'Class',
                            allowClear: true
                        });
                    });
                </script>-->
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>

        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
                                    function getData(id, grade, class1) {
                                        document.getElementById("id").value = id;
                                        document.getElementById("class").value = class1;
                                        document.getElementById("grade").value = grade;

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
                        window.location.href = "participantservlet?action=delete&&id=" + id;
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
    session.removeAttribute("participants");
    session.removeAttribute("classes");
    session.removeAttribute("employees");
%>