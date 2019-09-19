<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.mom.model.*,com.mom.DAO.ExportDAO"%>
    <% if(session.getAttribute("Emp_id")!=null && (((String)session.getAttribute("Role")).equals("admin"))){
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%List<Export> li=ExportDAO.export(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#"><strong>Employee wise Report</strong></a>
    <div class="nav navbar-nav navbar-right" style="disply:inline-block">
 	<a class="btn btn-info" style="margin-left:70vw;" href="AdminDashboard.jsp">home</a>
 	<button class="btn btn-danger" style="position:absolute;top:15%;left:81%;" onclick="window.print()">Print</button>
 	</div>
  </nav>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Employee id</th>
      <th scope="col">NO Of Meeting</th>
      <th scope="col">Present</th>
      <th scope="col">Absent</th>
       <th scope="col">Percentage of Absence</th>
    </tr>
  </thead>
  <tbody>
  <%for(Export i:li){ %>
    <tr>
      <td><%=i.getEmp_id() %></td>
      <td><%=i.getNo_of_meetings() %></td>
      <td><%=i.getPresent() %></td>
      <td><%=i.getAbsent() %></td>
      <td><%=i.getPer()%></td>
    </tr>
    <%} %>
  </tbody>
</table>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
<%}else{response.sendRedirect("index.html");} %>
</html>