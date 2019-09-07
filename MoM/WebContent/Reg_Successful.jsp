<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> </title>

<script src="js/view.js"></script>


<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="lib/bootstrap/css/bootstrap-grid.css" rel="stylesheet">
<link href="lib/bootstrap/css/bootstrap-grid.min.css" rel="stylesheet">
<link href="lib/bootstrap/css/bootstrap-reboot.css" rel="stylesheet">
<link href="lib/bootstrap/css/bootstrap-reboot.min.css" rel="stylesheet">





<link href="css/style2.css" rel="stylesheet">

<style>
.card {
        top: 20%;
		left:40%;
		
		
		display: block;
		position: absolute;
}
body{
	max-height: 798px;
}
</style>
</head>
<body>





<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="images/tick.gif" alt="Card image cap">
  <div class="card-body">
    <center><p class="card-text">Registration Successful</p></center>
    <center>Employee Id : ${employee.getemp_id()}</center>
     <center>Employee Name : ${employee.getemp_name()}</center>
      <center>Employee Email : ${employee.getemp_mail()}</center>
      <br>
        <center><button onclick= location.replace("AdminDashboard.jsp") style="background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s; box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}">Back</button></center>
  </div>
</div>

</body>
</html>