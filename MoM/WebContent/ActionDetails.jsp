<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Action Details</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="css/mdb.min.css" rel="stylesheet">
<!-- Your custom styles (optional) -->
<link href="css/style.css" rel="stylesheet">
</head>
<body>
<%
		List<Action> list = MomDAO.getActionDetail();
	%>
	<div class="container">
		<div class="row">
			<div class="col-6 mt-5 text-center">
				<h2>Open Items</h2>
				<table class="table table-bordered table-responsive-md table-striped text-center">
					<thead>
						<tr>
							<th class="text-center font-weight-bold">Action ID</th>
							<th class="text-center  font-weight-bold">Action Name</th>
							<th class="text-center  font-weight-bold">Assign</th>

						</tr>
					</thead>
					<tbody>
					
					<% for(Action i:list){%>
					<TR>
						<td class="pt-3-half"><%=i.getaction_id() %></td>
						<td class="pt-3-half"><%=i.getaction_name()%></td>
						<td class="pt-3-half"><span class="table-remove"><a class="btn btn-rounded btn-sm my-0 font btn btn-danger" href='#'>Assign</a></span></td>
						<%} %>
					</TR>
				</tbody>
				</table>
			</div>
			<div class="col-6 mt-5 text-center">
				<h2>Assigned Items</h2>
				<table class="table table-bordered table-responsive-md table-striped text-center ">
					<thead>
						<tr>
							<th class="text-center font-weight-bold">Action ID</th>
							<th class="text-center  font-weight-bold">Current Status</th>
							<th class="text-center  font-weight-bold">Employee ID</th>

						</tr>
					</thead>
					<tbody>
					
					<% for(Action j:list){%>
					<TR>
						<td class="pt-3-half"><%=j.getaction_id() %></td>
						<td class="pt-3-half"><%=j.getCurrent_status()%></td>
						<td class="pt-3-half"><%=j.getemp_id()%></td>
						<%} %>
						
					</TR>
				</tbody>
				</table>
			</div>
				<div class="modal fade" id="DeleteSucess" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm modal-notify modal-danger"
				role="document">
				<!--Content-->
				<div class="modal-content text-center">
					<!--Header-->
					<div class="modal-header d-flex justify-content-center">

						<p class="heading">Successfully assigned</p>
					</div>

					<!--Body-->


					<!--Footer-->
					<div class="modal-footer flex-center text-center">
						<center>
							<a href="" class="btn btn btn-info">OK</a>
							</form>
					</div>
				</div>
				<!--/.Content-->
			</div>
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
							<form action="DeactivateServlet">
								<input type="hidden" name="id" id="delid" />
								<button type="submit" class="btn btn btn-success" name="sbtn">Yes</button>
								&nbsp;&nbsp; <a href="" class="btn btn btn-danger">No</a>
							</form>
					</div>
				</div>
				<!--/.Content-->
			</div>
		</div>
		<script type="text/javascript">
		$(document).ready(function(){
			$('.table-remove').on('click',function(){
				$('#modalConfirmDelete').modal('show');
				$tr = $(this).closest("tr");
				var data=$tr.children("td").map(function(){
					return $(this).text();
				}).get();
				$('#delid').val(data[0]);
			});
		</script>
			
</body>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="js/mdb.min.js"></script>
</html>