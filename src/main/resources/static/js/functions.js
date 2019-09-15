$("document").ready(function(){
  $.ajax({
    type:"GET",
    contentType: "application/json",
        dataType: 'json',
        async:true,
    url:"http://127.0.0.1:8080/employee/all",
    success:function(data){

       $.each(data, function(index, item) {
         $('#mytable tbody').append(
             "<tr><td>" + item.employeeId + "</td>"
             + "<td>" + item.name + "</td>"
             + "<td>" + item.surname + "</td>"
             + "<td>" + item.tel + "</td>"
             + "<td>" + item.email + "</td>"
             + "<td>"
                           +'<div class="btn-group" role="group" aria-label="...">'
                           + '<button  class="btn btn-success"><i class="fa fa-edit" style="color:white"></i></button>'
                           + '<button  class="btn btn-danger" onclick="deleteEmployee()"><i class="fas fa-trash-alt" style="color:white"></i></button>'
                         + '</div>'
                       + '</td>'
             + "</tr>");
            });
    }
  });
});
