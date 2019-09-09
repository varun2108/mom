<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		  $('#datetimepicker1').datetimepicker();
		});
	$(function() {
		  $('#datetimepicker2').datetimepicker();
		});
</script>
<body>
<section class="testimonial py-5" id="testimonial">
    <div class="container"  style="background:white">
        <div class="row ">
            <div class="col-md-4 py-5 bg-primary text-white text-center ">
                <div class=" ">
                    <div class="card-body">
                        <img src="http://www.ansonika.com/mavia/img/registration_bg.svg" style="width:30%">
                        <h2 class="py-3">Create MOM</h2>
                        <p>Meeting minutes are the written or recorded documentation that is used to inform attendees and non attendees about what was discussed or what happened during a meeting.

</p>
				
                    </div>
                </div>
            </div>
                <div class="col-md-8 py-5 border">
                <h4 class="pb-4">Please fill following details</h4>
                <form action="CreateMom">
                    <div class="form-row" >
                        <div class="form-group col-md-6" >
                          <input id="Full Name" name="subject" placeholder="Subject" class="form-control" type="text">
                        </div>
                        <div class="form-group col-md-6">
                                   <input id="inputState" name="no_of_p" placeholder="number of participents" class="form-control" type="number">
                                
                        </div>
                        <div id="forpart" class="col-md-12">
                        
                        </div>
                       <div class="form-row col-md-12">
                        <div class="form-group col-md-6">
							<div class="input-group date" id="datetimepicker1">
								<input type="text" name="startdate" class="form-control" placeholder="start date" /> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
						<div class="form-group col-md-6">
							<div class='input-group date' id='datetimepicker2'>
								<input type='text' name="enddate" class="form-control" placeholder="end date" /> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
						</div>
						<div class="form-row col-md-12">
                        <div class="form-group col-md-12">
                                  <textarea id="comment" name="pointsdiscussed" cols="40" rows="5" class="form-control" placeholder="pointsdiscussed"></textarea>
                        </div>
                    </div>
        			<div class="form-row col-md-12">
                        <div class="form-group col-md-12">
                                  <textarea id="comment" name="desisionstaken" cols="40" rows="5" class="form-control" placeholder="desissions taken"></textarea>
                        </div>
                        
                    </div>
                    <div class="form-row col-md-12">
                     <div class="form-group col-md-6">
                                   <input id="no_of_act" name="no_of_oct" placeholder="number of actions" class="form-control" type="number">
                    </div>
                    <div class="form-group col-md-6" id="foract">
                                  
                    </div>
                    </div>
                    <div class="form-row col-md-12">
                        <div class="form-group col-md-12">
                                  <textarea id="openitems" name="mom_open" cols="40" rows="5" class="form-control" placeholder="open Items"></textarea>
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
                    
                    <div class="form-row">
                        <button type="submit" class="btn btn-danger">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>



</body>
</html>