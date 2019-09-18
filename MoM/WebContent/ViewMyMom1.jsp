<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.mom.DAO.*, java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>view my mom</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Your custom styles (optional) -->
<link href="css/style.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<style>
	@import url(https://fonts.googleapis.com/css?family=Roboto);
* {
  margin: 0;
  padding: 0;
}
*,
*:after,
*:before {
  box-sizing: border-box;
}
html {
  line-height: 1.2;
}
body {
  background-color: #f5f5f5;
  color: #333;
  font-family: "Roboto", arial, sans-serif;
  font-size: 16px;
}
.selected-item {
  margin: 20px 0;
  text-align: center;
}
.selected-item p {
  font-size: 18px;
}
.selected-item p span {
  font-weight: bold;
}
/* dropdown list */
.dropdown {
  margin: 20px auto;
  width: 300px;
  position: relative;
  -webkit-perspective: 800px;
          perspective: 800px;
}
.dropdown.active .selLabel:after {
  content: '\25B2';
}
.dropdown.active .dropdown-list li:nth-child(1) {
  -webkit-transform: translateY(100%);
          transform: translateY(100%);
}
.dropdown.active .dropdown-list li:nth-child(2) {
  -webkit-transform: translateY(200%);
          transform: translateY(200%);
}
.dropdown.active .dropdown-list li:nth-child(3) {
  -webkit-transform: translateY(300%);
          transform: translateY(300%);
}
.dropdown.active .dropdown-list li:nth-child(4) {
  -webkit-transform: translateY(400%);
          transform: translateY(400%);
}
.dropdown > span {
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
  width: 100%;
  height: 60px;
  line-height: 60px;
  color: #fff;
  font-size: 18px;
  letter-spacing: 2px;
  background: #34495e;
  display: block;
  padding: 0 50px 0 30px;
  position: relative;
  z-index: 9999;
  cursor: pointer;
  -webkit-transform-style: preserve-3d;
          transform-style: preserve-3d;
  -webkit-transform-origin: 50% 0%;
          transform-origin: 50% 0%;
  -webkit-transition: -webkit-transform 300ms;
  transition: -webkit-transform 300ms;
  transition: transform 300ms;
  transition: transform 300ms, -webkit-transform 300ms;
  -webkit-backface-visibility: hidden;
  -webkit-touch-callout: none;
  -webkit-user-select: none;
     -moz-user-select: none;
      -ms-user-select: none;
          user-select: none;
}
.dropdown > span:after {
  content: '\25BC';
  position: absolute;
  right: 0px;
  top: 15%;
  width: 50px;
  text-align: center;
  font-size: 12px;
  padding: 10px;
  height: 70%;
  line-height: 24px;
  border-left: 1px solid #ddd;
}
.dropdown > span:active {
  -webkit-transform: rotateX(45deg);
          transform: rotateX(45deg);
}
.dropdown > span:active:after {
  content: '\25B2';
}
.dropdown-list {
  position: absolute;
  top: 0px;
  width: 100%;
}
.dropdown-list li {
  display: block;
  list-style: none;
  left: 0;
  opacity: 1;
  -webkit-transition: -webkit-transform 300ms ease;
  transition: -webkit-transform 300ms ease;
  transition: transform 300ms ease;
  transition: transform 300ms ease, -webkit-transform 300ms ease;
  position: absolute;
  top: 0;
  width: 100%;
}
.dropdown-list li span {
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
  -webkit-backface-visibility: hidden;
  -webkit-touch-callout: none;
  -webkit-user-select: none;
     -moz-user-select: none;
      -ms-user-select: none;
          user-select: none;
  width: 100%;
  font-size: 18px;
  line-height: 60px;
  padding: 0 30px;
  display: block;
  color: #fff;
  cursor: pointer;
  letter-spacing: 2px;
}
	
</style>
<script>
$(document).ready(function() {
	  
	  $(".selLabel").click(function () {
	    $('.dropdown').toggleClass('active');
	  });
	  
	  $(".dropdown-list li").click(function() {
	    $('.selLabel').text($(this).text());
	    $('.dropdown').removeClass('active');
	    $('.selected-item p span').text($('.selLabel').text());
	  });
	  
	});
</script>
<body>
<%	 Connection con=ConnectionDAO.getConnection();
	PreparedStatement ps = con.prepareStatement("select * from mom where MOM_CREATORID=?");
	ps.setInt(1,(Integer)session.getAttribute("Emp_id"));
	ResultSet rs=ps.executeQuery();
%>
	<div class="container-fixed">
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Select Your Meating</a>
    <div class="nav navbar-nav navbar-right">
 	<a class="btn btn-info" style="margin-left:75vw;" href="DashRedirect">home</a>
 	</div>
  </nav>
</div>
	
</div>
	
	<div class="container">
	<div class="col-md-3"></div>
	<div class="col-md-6">	
   <form action="ActionDetails.jsp">
	<div class="form-group">
  <label for="sel1">SELECT MOM:</label>
  <select class="form-control" id="sel1" name="mom_id">
  <%while(rs.next()){%>
      <option value=<%=rs.getInt(1)%>>
        <%=rs.getString(2)%></option>
      <%} %>

   
  </select>
 
	</div>
	<center>
	<button type="submit" class="btn btn-primary">submit</button>
	</center>
</form>
</div>
	
		
</body>
</html>