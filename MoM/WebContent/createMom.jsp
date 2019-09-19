<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if(session.getAttribute("Emp_id")!=null){
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mom Creation</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css">
<script src="js/createmom.js"></script>
<div class="container">
</head>
<style>
img {width:100%;}
body{
background: #1f253d;
}
</style>

	<script>
	
	$(function() {
		  $('#datetimepicker1').datetimepicker({format: 'YYYY-MM-DD HH:mm'
			 
		});
		  $("#datetimepicker1").on("dp.change", function (e) {
			  alert(e.date);
	            $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
	        });
		  $('#datetimepicker2').datetimepicker({format: 'YYYY-MM-DD HH:mm'});
		  $("#datetimepicker2").on("dp.change", function (e) {
	            $('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
	        });
		  });
</script>
<body>
<section class="testimonial py-5" id="testimonial">
    <div class="container"  style="background:white">
        <div class="row ">
            <div class="col-md-4 py-5 bg-info text-white text-center ">
                <div class=" ">
                    <div class="card-body">
                        <img src="http://www.ansonika.com/mavia/img/registration_bg.svg" style="width:30%">
                        <h2 class="py-3"><br>Create MOM</h2>
                        <p>Meeting minutes are the written or recorded documentation that is used to inform attendees and non attendees about what was discussed or what happened during a meeting.

</p>
						<br><br><br>
						<a href="DashRedirect" class="btn btn-default">Home</a>
                    </div>
                </div>
            </div>
                <div class="col-md-8 py-5 border">
                <h4 class="pb-4">Please fill following details:</h4>
 				<div style="color:gray;font-weight: lighter">
                <form action="CreateMom">
                    <div class="form-row" >
                        <div class="form-group col-md-6" >
                        <label>Subject</label>
                          <input id="Full Name" name="subject" placeholder="Subject" class="form-control" type="text" required>
                        </div>
                        <div class="form-group col-md-6">
                        			 <label>No Of Participants <small style="color:red">*(including you)</small></label>
                                   <input id="inputState" name="no_of_p" placeholder="Number of participents" class="form-control" type="number" onblur="val(this)" required>
                                 
  									<input name="creatorid" type="hidden" value='<%=session.getAttribute("Emp_id") %>' required>                           
                        </div>
                        <div id="forpart" class="col-md-12">
                        
                        </div>
                       <div class="form-row col-md-12">
                        <div class="form-group col-md-6">
                        <label>Meeting Start Time & Date :</label>
							<div class="input-group date" id="datetimepicker1">	
								<input type="text" name="startdate" class="form-control" placeholder="Start date" required/> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
						<div class="form-group col-md-6">
						<label>Meeting End Time & Date :</label>
							<div class='input-group date' id='datetimepicker2'>
								<input type='text' name="enddate" class="form-control" placeholder="End date" required/> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
						</div>
						<div class="form-row col-md-12">
                        <div class="form-group col-md-12">
                  				<label>Points Discussed :</label>
                                  <textarea id="comment" name="pointsdiscussed" cols="40" rows="5" class="form-control" placeholder="Points discussed" maxlength = "210" required></textarea>
                        </div>
                    </div>
        			<div class="form-row col-md-12">
                        <div class="form-group col-md-12">
                        <label>Decisions Taken :</label>
                                  <textarea id="comment" name="desisionstaken" cols="40" rows="5" class="form-control" placeholder="Decisions taken" maxlength = "210" required></textarea>
                        </div>
                        
                    </div>
                    <div class="form-row col-md-12">
                     <div class="form-group col-md-6">
                     <label>Number Of Actions :</label>
                                   <input id="no_of_act" name="no_of_oct" placeholder="Number of actions" class="form-control" type="number" onblur="val(this)" required>
                    </div>
                    <div class="form-group col-md-6" id="foract">
                                  
                    </div>
                    </div>
                    <div class="form-row col-md-12">
                        <div class="form-group col-md-12">
                        <label>Open Items :</label>
                                  <textarea id="openitems" name="mom_open" cols="40" rows="5" class="form-control" placeholder="Open Items" maxlength = "210" required></textarea>
                        </div>
                        
                    </div>
                    
		                       
                    
                                    
                    <div class="form-row">
                        <div class="form-group">
                            <div class="form-group">
                                <div class="form-check">
                       
                                    
                                  </label>
                                </div>
                              </div>
                    
                          </div>
                    </div>
                    
                    <div class="form-row" style="align: center">
                        <button type="submit" class="btn btn-success forval" >Submit</button>
                    </div>
                </form>
                </div>
            </div>
        </div>
    </div>
</section>

			<div class="alert alert-danger err" style="display:none;position:fixed;top:2%;left:40%;width:50%;height:10%;z-index:100">
		
  			
  			</div>
<script type="text/javascript">
function tempAlert(msg,duration)
{
 	$(".err").html("<center>"+msg+"</center>");
 setTimeout(function(){
	 $(".err").css("display","none");
 },duration);
 	$(".err").css("display","block");
}
function val(t){
	var number=parseInt(t.value);
	if(number<1 || number>15){
		
		t.value=0;
		tempAlert("value must be between 1 and 15",1000);
	}
}
</script>
<% }
else{
	response.sendRedirect("index.html");
}%>
</body>
</html>