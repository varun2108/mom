/**
 * 
 */
$(document).ready(function(){
	$("#inputState").blur(function(){ 
		test();
	});
	$("#inputState").focus(function(){
		$("#forpart").html('');
	});
	$("#no_of_act").blur(function(){
		add_act();
	});
	$("#no_of_act").focus(function(){
		$("#foract").html('');
	});
	$("#inputState").blur(function(){
	        $.ajax({
	            type: "GET",
	            url: "GetEmployees",
	            success: function(data){
	                $(".FullName").html(data)
	            }
	        });
	});
});
function test(){
	var n=$("#inputState").val()
	if(n>0){
		partcontrol(n);
	}
}
function add_act(){
	var n=$("#no_of_act").val()
	if(n>0){
		actcontrol(n);
	}
}
function partcontrol(n){
	var dyn='';
	for(var i=1;i<=n;i++){
	dyn+=' <div class="form-row col-md-12">'
		+'<div class="form-group col-md-6">'
          +'<select id="" name="part'+i+'" placeholder="Participent Id'+i+'" list="json-datalist" class="form-control FullName" type="text" style="height:100%"><option selected>choose employee</option></select>'
                       +'</div>'
                       +'<div class="form-group col-md-6>'
                       +'<input type="radio" name="presence" value="dont know">'
                       +'<input type="radio" name="presence'+i+'" value="present" checked> present &nbsp;&nbsp;'
                       +'<input type="radio" name="presence'+i+'" value="absent"> absent'
                       +'</div></div>';
	}
	$("#forpart").append(dyn);
	
}
function actcontrol(n){
	var dyn='';
	for(var i=1;i<=n;i++){
	dyn+='<input id="Full Name" name="action'+i+'" placeholder="Action'+i+'" class="form-control" type="text">';
                      
	}
	
	$("#foract").append(dyn);
}


