<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.util.*,com.mom.model.*,com.mom.DAO.*"%>
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
<script>
if(${asstatus}){
	alert("assigned successfully");
	
}
</script>
<%
	List<Action> oa=new ArrayList<Action>();
	List<Action> aa=new ArrayList<Action>();
	oa=ActionDetailsDAO.getOpenActions(Integer.parseInt(request.getParameter("mom_id")));
	aa=ActionDetailsDAO.getAssignedActions(Integer.parseInt(request.getParameter("mom_id")));
	int momid=Integer.parseInt(request.getParameter("mom_id"));
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Acrion Details</a>
    <div class="nav navbar-nav navbar-right">
 	<a class="btn btn-info" style="margin-left:75vw;" href="DashRedirect">home</a>
 	</div>
  </nav>
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
    
 	<%for(Action i: oa){ %>
    <TR>
     <td class="pt-3-half"><%=i.getActionid() %></td>
     <td class="pt-3-half"><%=i.getAction_name() %></td>
     <td class="pt-3-half"><span class="table-remove"><button class="btn btn-rounded btn-sm my-0 font btn btn-danger table-remove1">Assign</button></span></td>

    </TR>
   	<%} %>
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
   			 
 	<%for(Action i: aa){ %>
    <TR>
     <td class="pt-3-half"><%=i.getActionid() %></td>
     <td class="pt-3-half"><%=i.getAction_status() %></td>
     <td class="pt-3-half"><%=i.getEmployeeid() %></td>

    </TR>
   	<%} %>
   </tbody>
   </table>
  </div>
	<div class="modal fade" id="elegantModalForm" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<!--Content-->
				<div class="modal-content form-elegant">
					<!--Header-->
					<div class="modal-header text-center">
						<h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3"
							id="myModalLabel">
							<strong>ASSIGN Action</strong>
						</h3>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<!--Body-->
					<center>
					<form action="Assignaction">
					
						<input type="hidden" id="delid" name="actionid">
						<input type="hidden" name="mom_id" value="<%=momid%>">
						<label>Select Employee
								<input list="browsers" name="employeeid" class="form-control">
								<datalist id="browsers">
								</datalist>
								</label>
						<div class="wrap-input100 validate-input input100" data-validate = "Start Date">
					<span class="focus-input100" data-placeholder="&#xf133;"></span>
						<label>Due Date &nbsp; &nbsp;
						<input class="form-control" type="date" name="emp_duedate" placeholder="Due Date">
						
						</label>
						<br>
						<button  class="btn btn-success" type="submit">Submit</button>
					</div>
					
					</form>
					</center>
					</div>

				</div>
			</div>

		</div>
	</div>

	
  

	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/jquery/jquery-migrate.min.js"></script>
	
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
	
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script type="text/javascript">
 $(document).ready(function(){
	 $(".table-remove1").on('click',function(){
		 $('#elegantModalForm').modal('show');
		 $tr = $(this).closest("tr");
			var data=$tr.children("td").map(function(){
				return $(this).text();
			}).get();
			$('#delid').val(data[0]);
				  $.ajax({
					  url: "getParticipants", 
					  data: {momid : "<%=momid%>"},
					  success: function(result){
				    $("#browsers").html(result);
				  }});
			
	 });
  });
 </script>
</body>
</html>