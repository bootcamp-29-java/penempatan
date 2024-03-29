<%-- 
    Document   : employee
    Created on : Sep 11, 2019, 10:40:49 PM
    Author     : ASUS
--%>

<%@page import="models.EmployeeRole"%>
<%@page import="models.Participant"%>
<%@page import="models.Client"%>
<%@page import="java.util.List"%>
<%@page import="models.Interview"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
<!DOCTYPE html>

<%
    List<EmployeeRole> logSession = (List<EmployeeRole>) session.getAttribute("sessionlogin");
    List<Interview> interviews = (List<Interview>) session.getAttribute("interviews");
    List<Participant> participants = (List<Participant>) session.getAttribute("participants");
    List<Client> clients = (List<Client>) session.getAttribute("clients");
    String genId = (String) session.getAttribute("genId");
    String status = (String) session.getAttribute("status");

    if (logSession == null) {
        out.print(logSession);
        out.println("<script>alert('Anda belum login!')</script>");
        out.println("<script>window.location.href=\"admin/login.jsp\"</script>");
    } else if (interviews == null || participants == null || clients == null || genId == null) {
        response.sendRedirect("interviewservlet");
    } else {
        if(logSession.contains("")||logSession.contains("3")){
            out.println("<script>alert('Anda Tidak Memiliki Akses Ke Menu Ini!')</script>");
            out.println("<script>window.location.href=\"index.jsp\"</script>");
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
            <% if(logSession.contains("1")||logSession.contains("4")){ %>
            <div class="card w-100" style="margin-top: 20px;">
                <h5 class="card-header">Create Interview</h5>
                <div class="card-body">
                    <h5 class="card-title">Input New Interview</h5>
                    <p class="card-text">You can input new interview data in here</p>
                    <button type="button" onclick="getData('<%=genId%>', '', '', '', '', '', '', '')" class="btn btn-primary" data-toggle="modal" data-target="#addInterview">
                        Add Interview  
                    </button>
                </div>
            </div>
            <% } %>
        </div>
        <br>
        <div class="card w-100">
            <h5 class="card-header text-center">List Interview</h5>
            <div class="card-body">
                <table id="example" class="table table-hover table-sm table-bordered" style="width:100%">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Date</th>
                            <th scope="col">Time</th>
                            <th scope="col">Location</th>
                            <th scope="col">Department</th>
                            <th scope="col">PIC</th>
                            <th scope="col">Participant</th>
                            <th scope="col">Client Name</th>
                            <th scope="col">Edit</th>
                            <th scope="col">Delete</th>
                            <th scope="col">Invitation</th>
                            <th scope="col">Is Accepted?</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Interview empl : interviews) {
                        %>
                        <tr>
                            <td scope="row"><%=empl.getId()%></td>
                            <td scope="row"><%=empl.getDate()%></td>
                            <td scope="row"><%=empl.getTime()%></td>
                            <td scope="row"><%=empl.getLocation()%></td>
                            <td scope="row"><%=empl.getDepartment()%></td>
                            <td scope="row"><%=empl.getPic()%></td>
                            <td scope="row"><%=empl.getParticipant().getEmployee().getFirstName()%></td>
                            <td scope="row"><%=empl.getClient().getName()%></td>
                            <td class="text-center">
                                <button onclick="getData('<%=empl.getId()%>', '<%=empl.getDate()%>', '<%=empl.getTime()%>', '<%=empl.getLocation()%>', '<%=empl.getDepartment()%>',
                                                '<%=empl.getPic()%>', '<%=empl.getParticipant().getId()%>', '<%=empl.getClient().getId()%>')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addInterview">
                                    <i class="far fa-edit"></i> EDIT</button>
                            </td>
                            <% if(logSession.contains("1")){ %>
                            <td class="text-center"><button onclick='setAlert("<%=empl.getId()%>")' type=""class="btn btn-danger"><i class="far fa-trash-alt"></i> HAPUS</button></td>
                            <% } %>
                            <td class="text-center"><button onclick='setAlertSendInvitation("<%=empl.getId()%>", "<%=empl.getParticipant().getEmployee().getEmail()%>", "<%=empl.getParticipant().getEmployee().getFirstName()%>")' type=""class="btn btn-unique"><i class="fas fa-envelope"></i>     Send Email</button></td>
                            <td class="text-center">
                                <button onclick="getDataAcc('<%=empl.getId()%>', '<%=empl.getDate()%>', '<%=empl.getTime()%>', '<%=empl.getLocation()%>', '<%=empl.getDepartment()%>',
                                                '<%=empl.getPic()%>', '<%=empl.getParticipant().getId()%>', '<%=empl.getClient().getId()%>', '<%=empl.getIsAccepted()%>')" type="button" class="btn btn-info" data-toggle="modal" data-target="#addAccepted"><i class="fas fa-question-circle"></i> Set</button>
                                <%String acc = (empl.getIsAccepted()) ? "Yes" : "No";%>
                                <a scope="row"> <%=acc%></a>
                            </td>

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
                        <form action="interviewservlet" method="POST">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputID">ID</label>
                                    <input type="number" class="form-control" id="id" name="id" placeholder="ID" value="">
                                </div>
                            </div>
                            <div class="form-group ">
                                <label>Date</label>
                                <input type="date" class="form-control" id="date" name="date">
                            </div>
                            <div class="form-group ">
                                <label>Time</label>
                                <input type="time" class="form-control" id="time" name="time">
                            </div>
                            <div class="form-group">
                                <label for="inputLocation">Location</label>
                                <input type="text" class="form-control" id="location" name="location" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="inputDepartment">Department</label>
                                <input type="text" class="form-control" id="department" name="department" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="inputPic">PIC</label>
                                <input type="text" class="form-control" id="pic" name="pic" placeholder="">
                            </div>

                            <div class="form-group">
                                <label for="inputGender">Participant</label>
                                <select id="participant" name="participant" class="form-control">
                                    <option value="">-Pilih-</option>
                                    <%for (Participant p : participants) {%>
                                    <option value="<%=p.getId()%>" ><%=p.getId()%> - <%=p.getEmployee().getFirstName()%></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="inputNationality">Client</label>
                                <select id="client" name="client" class="form-control">
                                    <option value="">-Pilih-</option>
                                    <%for (Client c : clients) {%>
                                    <option value="<%=c.getId()%>" ><%=c.getId()%> - <%=c.getName()%></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary">Save Interview</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <!--modal accepted-->
        <div class="modal fade" id="addAccepted" tabindex="-1" role="dialog" aria-labelledby="addAccepted" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Create Lesson</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="acceptedservlet" method="POST">
                            <div class="form-row">
                                <input type="hidden" class="form-control" id="idAcc" name="idAcc" value="">
                                <input type="hidden" class="form-control" id="dateAcc" name="dateAcc">
                                <input type="hidden" class="form-control" id="timeAcc" name="timeAcc">
                                <input type="hidden" class="form-control" id="locationAcc" name="locationAcc" placeholder="">
                                <input type="hidden" class="form-control" id="departmentAcc" name="departmentAcc" placeholder="">
                                <input type="hidden" class="form-control" id="picAcc" name="picAcc" placeholder="">
                                <input type="hidden" id="participantAcc" name="participantAcc" class="form-control">
                                <input type="hidden" id="clientAcc" name="clientAcc" class="form-control">
                                <div class="form-group col-md-12">
                                    <label for="inputAcc">Is Accepted?</label>
                                    <select id="accept" name="accept" class="form-control">
                                        <option value=true>Yes</option>
                                        <option value=false>No</option>
                                    </select>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary">Save</button>
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

        </script>

        <script>
            function getData(id, date, time, location, department, pic, participant, client) {
                document.getElementById("id").value = id;
                document.getElementById("date").value = date;
                document.getElementById("time").value = time;
                document.getElementById("location").value = location;
                document.getElementById("department").value = department;
                document.getElementById("pic").value = pic;
                document.getElementById("participant").value = participant;
                document.getElementById("client").value = client;

                if (id !== '') {
                    document.getElementById("id").readOnly = true;
                } else {
                    document.getElementById("id").readOnly = false;
                }
            }
        </script>

        <script>
            function getDataAcc(id, date, time, location, department, pic, participant, client, accept) {
                document.getElementById("idAcc").value = id;
                document.getElementById("dateAcc").value = date;
                document.getElementById("timeAcc").value = time;
                document.getElementById("locationAcc").value = location;
                document.getElementById("departmentAcc").value = department;
                document.getElementById("picAcc").value = pic;
                document.getElementById("participantAcc").value = participant;
                document.getElementById("clientAcc").value = client;
                document.getElementById("accept").value = accept;

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
                if (status.equalsIgnoreCase("Data Berhasil Disimpan") || status.equalsIgnoreCase("Data Berhasil Dihapus") || status.equalsIgnoreCase("Email Berhasil Dikirimkan")) {
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
                        window.location.href = "interviewservlet?action=delete&&id=" + id;
                    } else {
                        swal("Anda Membatalkan Mengahpus Data!");
                    }
                });
            }
        </script>

        <script>
            function setAlertSendInvitation(id, email, firstName) {
                swal({
                    title: "Apakah Anda Yakin?",
                    text: "Tekan Ok, Jika Anda Yakin Mengirim Undangan Interview!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true
                }).then((willDelete) => {
                    if (willDelete) {
                        window.location.href = "interviewservlet?action=sendInterview&&idInterview=" + id + "&&emailInterview=" + email + "&&firstNameInterview=" + firstName;
                    } else {
                        swal("Anda Membatalkan Mengirim Undangan!");
                    }
                });
            }
        </script>
    </body>
</html>
<%
        session.removeAttribute("status");
        }
    }
    session.removeAttribute("genId");
    session.removeAttribute("interviews");
    session.removeAttribute("participants");
    session.removeAttribute("clients");
%>