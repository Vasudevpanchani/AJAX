<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Clothes</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" />
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-dark navbar-light bg-light">
		<a class="navbar-brand text-light" href="/">Clothes</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link text-light"
					href="/" id="home">Home</a></li>
			</ul>

			<button type="button" class="btn btn-primary float-end"
				data-toggle="modal" data-target="#exampleModal">Add Clothes</button>
		</div>
	</nav>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Price</th>
				<th scope="col">Brand</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody id="tData">

		</tbody>
	</table>
	<div class="modal fade p-2" id="exampleModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"
		style="box-shadow: 1px 1px 1px 1p">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add Cloth</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="price">Enter cloth name: </label> <input type="text"
								class="form-control" id="name" name="name"
								placeholder="Enter cloth name: " />
						</div>
						<div class="form-group">
							<label for="brand">Enter your brand: </label> <input type="text"
								class="form-control" id="brand" name="brand"
								placeholder="Enter brand" />
						</div>
						<div class="form-group">
							<label for="price">Enter your price: </label> <input type="text"
								class="form-control" id="price" name="price"
								placeholder="Enter price" />
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="submit">
						Save</button>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		updateTable();
		function updateTable() {

			$.ajax({
				url : '/getCloth',
				type : 'GET',
				contentType : 'application/json',
				success : function(response) {
					setTableData(response);
				}
			});
			function setTableData(response)
			{
				$("#tData").empty();
				for(var i of response)
					{
						var tRow = tRow += "<tr><td>" + i.clothId + "</td><td>" + i.clothName + "</td><td>" + i.clothPrice + "</td><td>" + i.clothBrand + "</td><td><button class=\"btn btn-success\" onClick=\"deleteData(" + i.clothId + ")\" data-id=\"\">Delete</button> | <button class=\"btn btn-danger\" onClick=\"editData(" + i.clothId + ", '" + i.clothName + "', '" + i.clothPrice + "','" + i.clothBrand + "')\" data-id=\"\" >Edit</button> </td>" + "</tr>";
						$("#tData").append(tRow);
					}
			}
		}
		$(document).ready(function () {
			
	        $("#submit").click(function () {
	          var realData = {
	            clothName: $("#name").val(),
	            clothBrand: $("#brand").val(),
	            clothPrice: $("#price").val()
	          };
	          $.ajax({
	        	  url:"/addCloth",
	        	  type:"POST",
	        	  contentType:"application/json",
	        	  data:JSON.stringify(realData),
                  success:function(response){
                    console.log("Added");
                    updateTable();
                    
                  },
                  error:function(response){
                    console.log("Not added");
                    updateTable();
                  }
	          })
	         
	        });
	      });
		function deleteData(id)
		{		
			$.ajax({
				url:"/deleteCloth?clothId="+id,
				type:"DELETE",
				contentType:"application/json",
				success:function(response)
				{
					console.log("Deleted");
					updateTable();
				},
				error:function(response)
				{
					console.log("Not deleted");
				}
				
			});
		}
		function editData(id,name,price,brand)
		{
			  $("#name").attr("value", name);
	          $("#brand").attr("value", brand);
	          $("#price").attr("value", price);
			 $("#exampleModal").show('slow');
		}
		
	</script>
</body>

</html>
