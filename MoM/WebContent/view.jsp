<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*, com.mom.DAO.*, com.mom.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>

<script src="js/view.js"></script>


<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="lib/bootstrap/css/bootstrap-grid.css" rel="stylesheet">
<link href="lib/bootstrap/css/bootstrap-grid.min.css" rel="stylesheet">
<link href="lib/bootstrap/css/bootstrap-reboot.css" rel="stylesheet">
<link href="lib/bootstrap/css/bootstrap-reboot.min.css" rel="stylesheet">





<link href="css/style2.css" rel="stylesheet">

</head>
<body>
<script>
	if(${delstatus}){
		alert("Delete Successfull");
	}
</script>
	<% List<Employees> list=ConnectionDAO.getAllEmployees(); %>
	<nav>
	<ul>
		<li class="home-button btn-info "><a href="Admin.html"> Home</a></li>
		<li><center>
				<h3 class="text-centeremp">EMPLOYEE DETAILS</h3>
			</center></li>
			<div style="float:right;margin:2%;color:lightblue;" class="text-info"><strong>Number of Employees : <%= list.size() %></strong></div>

	</ul>


	</nav>



	<br>
	<div class="card-body">
		<div id="table" class="table-editable">
			<span class="table-add float-right mb-3 mr-2"><a href="#!"
				class="text-success"><i aria-hidden="true"></i></a></span>
				
			<table
				class="table table-bordered table-responsive-md table-striped text-center">
				<thead>
					<tr>
						<th class="text-center">Employee ID</th>
						<th class="text-center">Name</th>
						<th class="text-center">Email</th>
						<th class="text-center">Password</th>
						<th class="text-center">Designation</th>
						<th class="text-center">Department ID</th>
						<th class="text-center">Start Date</th>
						<th class="text-center">Edit</th>
						<th class="text-center">Remove</th>
					</tr>
				</thead>
				<tbody>
					
					<% for(Employees i:list){%>
					<TR>
						<td class="pt-3-half"><%=i.getemp_id() %></td>
						<td class="pt-3-half"><%=i.getemp_name()%></td>
						<td class="pt-3-half"><%=i.getemp_mail()%></td>
						<td class="pt-3-half"><%=i.getemp_pass()%></td>
						
						<td class="pt-3-half"><%=i.getemp_desg()%></td>
						<td class="pt-3-half"><%=i.getdept_id()%></td>
						<td class="pt-3-half"><%=i.getemp_startdate()%></td>
						<td class="pt-3-half"><span class="table-remove"><a class="btn  btn-rounded btn-sm my-0 font btn btn-info" href='editcustomer.jsp?id=<%=i.getemp_id() %>'>Edit</a></span></td>
						<td class="pt-3-half"><span class="table-remove"><a class="btn btn-rounded btn-sm my-0 font btn btn-danger" href='DeactivateServlet?id=<%=i.getemp_id() %>'>Delete</a></span></td>
						<%} %>
					</TR>
				</tbody>
			</table>

		</div>
		<div class="modal fade" id="modalConfirmDelete" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm modal-notify modal-danger"
				role="document">
				<!--Content-->
				<div class="modal-content text-center">
					<!--Header-->
					<div class="modal-header d-flex justify-content-center">
						<p class="heading">Are you sure?</p>
					</div>

					<!--Body-->


					<!--Footer-->
					<div class="modal-footer flex-center text-center">
						<center>
							<a href="" class="btn btn btn-danger">Yes</a> <a href=""
								class="btn btn btn-danger">No</a>
					</div>
				</div>
				<!--/.Content-->
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="elegantModalForm" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<!--Content-->
				<div class="modal-content form-elegant">
					<!--Header-->
					<div class="modal-header text-center">
						<h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3"
							id="myModalLabel">
							<strong>Sign in</strong>
						</h3>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<!--Body-->
					<div class="modal-body mx-4">
						<!--Body-->
						<div class="md-form mb-3">
							<label data-error="wrong" data-success="right" for="Form-email1">Employee
								Name</label> <input type="text" id="Form-email1"
								class="form-control validate" required="">

						</div>

						<div class="md-form pb-3">
							<label data-error="wrong" data-success="right" for="Form-pass1">Email</label>
							<input type="email" id="Form-pass1" class="form-control validate">


						</div>

						<div class="md-form pb-3">
							<label data-error="wrong" data-success="right" for="Form-pass1">Password</label>
							<input type="password" id="Form-pass1"
								class="form-control validate">


						</div>

						<div class="md-form pb-3">
							<label data-error="wrong" data-success="right" for="Form-pass1">Designation</label>
							<input type="text" id="Form-pass1" class="form-control validate">


						</div>
						<label data-error="wrong" data-success="right" for="Form-pass1">Department
							ID</label>
						<div class="md-form pb-3">
							<input type="text" id="Form-pass1" class="form-control validate">
						</div>

						<div class="text-center mb-3">
							<button type="button"
								class="btn btn-block btn-rounded z-depth-1a font" id="grad1">Make
								Changes</button>
						</div>


					</div>

				</div>
			</div>

		</div>
	</div>


	<!--Modal: modalConfirmDelete-->

	<!--Modal: modalConfirmDelete-->
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/jquery/jquery-migrate.min.js"></script>
	\
	<script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script src="lib/bootstrap/js/bootstrap.bundle.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>

	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/superfish/hoverIntent.js"></script>
	<script src="lib/superfish/superfish.min.js"></script>
	<script src="lib/wow/wow.min.js"></script>
	<script src="lib/waypoints/waypoints.min.js"></script>
	<script src="lib/counterup/counterup.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="lib/isotope/isotope.pkgd.min.js"></script>
	<script src="lib/lightbox/js/lightbox.min.js"></script>
	<script src="lib/touchSwipe/jquery.touchSwipe.min.js"></script>
	<!-- Contact Form JavaScript File -->
	<script src="contactform/contactform.js"></script>

	<!-- Template Main Javascript File -->
	<script src="js/main1.js"></script>
</body>
</html>
