<%-- 
    Document   : employee
    Created on : Sep 11, 2019, 10:40:49 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="curriculum-vitae.jsp">CV</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="assessment.jsp">Assessment</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="home.jsp">Placement</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="asset-management.jsp">Asset Management</a>
                    </li>
                </ul>
            </div>
            <form class="form-inline my-2 my-lg-0">
                <button class="btn btn-danger my-2 my-sm-0" type="submit" onclick="window.location.href = 'login.jsp';">Logout</button>
            </form>
        </nav>

        <!--coba-->
        <div class="container-fluid">
            <div class="row">
                <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                    <div class="sidebar-sticky">
                        <ul class="nav flex-column">
                            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                                <span>Data Employee</span>
                            </h6>
                            <li class="nav-item">
                                <a class="nav-link" href="employee.jsp">
                                    <span data-feather="file"></span>
                                    Employee
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="role.jsp">
                                    <span data-feather="shopping-cart"></span>
                                    Employee Role
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="participant.jsp">
                                    <span data-feather="users"></span>
                                    Participant
                                </a>
                            </li>
                        </ul>

                        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                            <span>Interview and Placement</span>
                        </h6>
                        <ul class="nav flex-column mb-2">
                            <li class="nav-item">
                                <a class="nav-link" href="interview.jsp">
                                    <span data-feather="file-text"></span>
                                    Interview
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="placement.jsp">
                                    <span data-feather="file-text"></span>
                                    Placement
                                </a>
                            </li>
                        </ul>

                        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                            <span>Data Class</span>
                        </h6>
                        <ul class="nav flex-column mb-2">
                            <li class="nav-item">
                                <a class="nav-link" href="lesson.jsp">
                                    <span data-feather="file-text"></span>
                                    Lesson
                                </a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="class.jsp">
                                    <span data-feather="file-text"></span>
                                    Class and Batch
                                </a>
                            </li>

                            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                                <span>Data Client</span>
                            </h6>
                            <li class="nav-item">
                                <a class="nav-link" href="client.jsp">
                                    <span data-feather="file-text"></span>
                                    Client
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>

                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2">Interview</h1>
                    </div>
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
                </main>

            </div>
        </div>
        <!--coba-->
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
                                    <option ></option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="inputNationality">Client</label>
                                <select id="dor" name="provinsi" class="form-control">
                                    <option ></option>
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
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </body>
</html>
