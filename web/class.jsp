<%@page import="models.EmployeeRole"%>
<%@page import="models.Lesson"%>
<%@page import="models.Batch"%>
<%@page import="models.Class"%>
<%@page import="java.util.List"%>
<%@include file = "header.jsp" %>
<%
    List<Class> cl = (List<Class>) session.getAttribute("Kelass");
    List<Batch> bc = (List<Batch>) session.getAttribute("Batchs");
    List<Lesson> lessons = (List<Lesson>) session.getAttribute("lessons");
    List<EmployeeRole> trainers = (List<EmployeeRole>) session.getAttribute("trainers");
    
    
    if(cl == null || bc == null){
        response.sendRedirect("classservlet");
    }
    else{
        
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
                            <h5 class="card-header">Create Class and Batch</h5>
                            <div class="card-body">
                                <h5 class="card-title">Input Class and Batch</h5>
                                <p class="card-text">You can input new class and batch data in here</p>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addClass">
                                    Add Class    
                                </button>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addBatch">
                                    Add Batch    
                                </button>
                            </div>
                        </div>
                        <div class="card w-100">
                <h5 class="card-header">List Employee Role</h5>
                <div class="card-body">
                    <table id="example" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Lesson</th>
                                <th scope="col">Batch</th>
                                <th scope="col">Edit</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Class empl : cl) {
                            %>
                            <tr>
                                <td scope="row"><%=empl.getId()%></td>
                                <td scope="row"><%=empl.getLesson().getName()%></td>
                                <td scope="row"><%=empl.getBatch().getId()%></td>
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
                    </div>
                            
                            <div class="card w-100">
                <h5 class="card-header">List Employee Role</h5>
                <div class="card-body">
                    <table id="examplee" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Edit</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Batch empl : bc) {
                            %>
                            <tr>
                                <td scope="row"><%=empl.getId()%></td>
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
                    </div>
             <!--card atas-->
             
             <!--table here-->
                

        <div class="modal fade" id="addClass"  role="dialog" aria-labelledby="addEmployeeAccount" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Create Employee Account</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputIDClass">ID</label>
                                    <input type="text" class="form-control" id="id" name="id" placeholder="ID" value="">
                                </div>
                                <div class="form-group">
                               <!--lesson-->
                                <select id="lesson" name="lesson" class="form-control">
                                    <option ></option>
                                    <%for (Lesson l : lessons) { %>
                                    <option value="<%=l.getId()%>" ><%=l.getId()%> - <%=l.getName()%></option>
                                    <% } %>
                                </select>
                          
                                
                                <!--batch-->
                                <select id="batch" name="batch" class="form-control">
                                    <option ></option>
                                    <%for (Batch b : bc) { %>
                                    <option value="<%=b.getId()%>" ><%=b.getId()%></option>
                                    <% } %>
                                </select>
                           
                                
                                <!--trainer-->
                                <select id="trainer" name="trainer" class="form-control">
                                    <option ></option>
                                    <%for (EmployeeRole t : trainers) { %>
                                    <option value="<%=t.getId()%>" ><%=t.getId()%> - <%=t.getEmployee().getFirstName()%></option>
                                    <% } %>
                                </select>
                            </div>
                               
                                
                            </div>   
                            <div class="modal-footer">
                                    <button type="submit" class="btn btn-primary">Add Class</button>
                                </div>
                        </form>
                    </div>
                </div>
            </div>>
        </div>
    </div>

    <div class="modal fade" id="addBatch" role="dialog" aria-labelledby="addEmployeeAccount" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable" role="document">
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
                                <label for="inputIDBatch">ID</label>
                                <input type="text" class="form-control" id="id" name="id" placeholder="ID" value="">
                            </div>

                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary">Add Batch</button>
                            </div>
                    </form>
                </div>
            </div>
        </div>>
    </div>
</div>
    <script type="text/javascript">
            $(document).ready(function () {
                $('#lesson').select2({
                    placeholder: 'Lesson',
                    allowClear: true
                });
            });
        </script>
    <script type="text/javascript">
            $(document).ready(function () {
                $('#batch').select2({
                    placeholder: 'Batch',
                    allowClear: true
                });
            });
        </script>
    <script type="text/javascript">
            $(document).ready(function () {
                $('#trainer').select2({
                    placeholder: 'Trainer',
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
    <script type="text/javascript">
        $(document).ready(function () {
            $('#examplee').DataTable();
        });
    </script>

</body>
</html>
<%
  }  
%>