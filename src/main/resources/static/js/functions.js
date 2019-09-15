	
	
	 function loadTable(){
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
			                           + '<div class="btn-group" role="group" aria-label="...">'
			                           + '<button  class="btn btn-success" data-toggle="modal" data-target="#myModal2"><i class="fa fa-edit" style="color:white"></i></button>'
			                           + '<button  class="btn btn-danger" data-toggle="modal" data-target="#myModal3"><i class="fas fa-trash-alt" style="color:white"></i></button>'
			                           + '</div>'
			                           + '</td>'
			             + "</tr>");
			            });
			    }
			  });
	 };
	 
	 
	 /* eleman ekleme fonk. */
	 function addEmployee(){

		var captchaResponse = grecaptcha.getResponse();
		
		var employee = {
				  "name": $("#nameInput").val() ,
				  "surname" :$("#surnameInput").val(),
 				  "tel": $("#telInput").val(),
 				  "email" : $("#mailInput").val()
 				  };
		
		var employeeDTO={
				"employee":employee,
				"captchaResponse" : captchaResponse
				}
		
		$.ajax({
			 type:"POST",
			 contentType:"application/json",
			 /* dataType ekleme yoksa success'e girmiyor */
			 async:"true",
			 url:"http://127.0.0.1:8080/employee/add",
			 data: JSON.stringify(employeeDTO),
			success:function(data){
				/* önce tabloyu boşalt */
				$('#mytable tbody').find('tr').remove();
				loadTable();
				alert("Successfull");
			},
			error:function(xhr, status, error) {
				/* springin döndürdüğü cevaptaki @NotNull() vb içindeki message */
				  alert(xhr.responseJSON.errors[0].defaultMessage);
				}
		 });
	 };
	 
	 function updateEmployee(){
		 /* $('input').attr('readonly', false);		 
		 console.log($('idInput2').val()+$("#nameInput2").val()+$("#surnameInput2").val()+$("#telInput2").val()+$("#mailInput2").val()) */
		 $.ajax({
			 type:"PUT",
			 contentType:"application/json",
			 /* dataType ekleme yoksa success'e girmiyor */
			 async:"true",
			 url:"http://127.0.0.1:8080/employee/update",
			 data: JSON.stringify({
				  "employeeId":$('#idInput2').val(),
				  "name": $("#nameInput2").val() ,
				  "surname" :$("#surnameInput2").val(),
				  "tel": $("#telInput2").val(),
				  "email" : $("#mailInput2").val()
				  }),
			success:function(data){
				$('#mytable tbody').find('tr').remove();
				loadTable();
				alert("Successfull");
			},
			error:function(xhr, status, error) {
				/* springin döndürdüğü cevaptaki @NotNull() vb içindeki message */
				  alert(xhr.responseJSON.errors[0].defaultMessage);
				}
		 });
	 };
	 
		/* tablodaki update butonu için  */  
	$('#mytable').on('click','.btn-success',function(){
		 $('#idInput2').val($(this).closest('tr').find('td:eq(0)').text());
		 $('#nameInput2').val( $(this).closest('tr').find('td:eq(1)').text());
		 $('#surnameInput2').val( $(this).closest('tr').find('td:eq(2)').text());
		 $('#telInput2').val( $(this).closest('tr').find('td:eq(3)').text());
		 $('#mailInput2').val( $(this).closest('tr').find('td:eq(4)').text());
		 
	});
	
	/* tablodaki silme butonu için */
	$('#mytable').on('click','.btn-danger', function(){
		 let row=$(this).closest('tr');
		 let id=row.find('td:eq(0)').text();
		 console.log(id);
		 $('#myModal3').on('click','.btn-primary' , function(){
			 $.ajax({
				    type:"DELETE",
				    contentType: "application/json",
				        async:true,
				    url:"http://127.0.0.1:8080/employee/delete/" + id,
				    success:function(data){
				    	console.log("deleted");
				    	/* önce tabloyu boşalt */
						$('#mytable tbody').find('tr').remove();
						loadTable();
				    }
			 })
		 });
		 
	 });
