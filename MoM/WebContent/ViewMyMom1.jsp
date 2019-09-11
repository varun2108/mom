<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.mom.DAO.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>view my mom</title>
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
<body
	style="background: url(images/a3.jpg); background-size: 100% 100%; background-repeat: no-repeat;">
	<style>
.p {
	display: none;
}

body {
	height: 900px;
	width: 100%;
	background-repeat: no-repeat;
	overflow: hidden;
}

#btn {
	position: absolute;
	top: 53%;
	left: 38%;
	background: transparent !important;
}
</style>
	<!-- Button trigger modal-->
	<button type="button" class="btn btn-primary z-depth-5"
		data-toggle="modal" data-target="#modalConfirmDelete" id="btn">MOM
		DETAILS</button>

	<!--Modal: modalConfirmDelete-->
	<div class="modal fade" id="modalConfirmDelete" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm modal-notify modal-danger"
			role="document">
			<!--Content-->
			<div class="modal-content text-center"
				style="margin-top: 200px; margin-left: -75px;">
				<!--Header-->
				<div class="modal-header d-flex justify-content-center">
					<p class="heading">MoM Details</p>
				</div>

				<!--Body-->


				<!--Footer-->
				<div class="modal-footer flex-center">
					<%@ page import="java.sql.*"%>
					<%
						ResultSet resultset = null;
					%>
					<%
						try {
							Connection connection = ConnectionDAO.getConnection();
							PreparedStatement ps = connection.prepareStatement("select * from mom where mom_creatorid=?");
							ps.setInt(1, Integer.parseInt((String) session.getAttribute("Emp_id")));
							resultset = ps.executeQuery();
					%>
					<center>
						<select
							class="mdb-select md-form colorful-select dropdown-primary p">
							<option value="Mom List" disabled selected>MoM list</option>
							<%
								while (resultset.next()) {
							%>
							<option><%=resultset.getString(2)%></option>
							<%
								}
							%>
						</select>
					</center>
					<%
						//**Should I input the codes here?**
						} catch (Exception e) {
							out.println("wrong entry" + e);
						}
					%>
				</div>
			</div>
			<!--/.Content-->
		</div>
	</div>
	<!--Modal: modalConfirmDelete-->
</body>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="js/mdb.min.js"></script>
<script type="text/javascript">
	$("#date").mouseout(function() {
		$(".p").toggle();
	})
	$(".modal-content").addClass("animated zoomIn")
</script>
<script type="text/javascript">
	//Material Select Initialization
	$(document).ready(function() {
		$('.mdb-select').materialSelect();
	});
</script>
</html>