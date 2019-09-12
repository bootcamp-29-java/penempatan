<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.7/css/select2.min.css" rel="stylesheet" />
        <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.7/js/select2.min.js"></script>
    </head>
    <body>
 
                        <form>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputID">ID</label>
                                    <input type="number" class="form-control" id="id" name="id" placeholder="ID" value="">
                                </div>


                                <div class="form-group col-md-6">
                                    <label for="inputGrade">Grade</label>
                                    <select id="grade" name="grade" class="form-control">
                                        <option selected=""></option>
                                        <option></option>
                                    </select>
                                </div>
                                <div>
                                <select id="provinsi" name="provinsi">
                                    <option ></option>
                                    <option value="ACEH">ACEH</option>
                                    <option value="RIAU">RIAU</option>
                                    <option value="JAMBI">JAMBI</option>
                                    <option value="SUMATERA UTARA">SUMATERA UTARA</option>
                                    <option value="BENGKULU">BENGKULU</option>
                                    <option value="LAMPUNG">LAMPUNG</option>
                                    <option value="DKI JAKARTA">DKI JAKARTA</option>
                                    <option value="JAWA BARAT">JAWA BARAT</option>
                                    <option value="JAWA TENGAH">JAWA TENGAH</option>
                                    <option value="JAWA TIMUR">JAWA TIMUR</option>
                                </select>
                                </div>

                            </div>


                            <div class="modal-footer">

                                <button type="submit" class="btn btn-primary">Add Participant</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <form method="POST">

        </form>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#provinsi').select2({
                    placeholder: 'Pilih Provinsi',
                    allowClear: true
                });
            });
        </script>
    </body>
</html>