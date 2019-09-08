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
});
function test(){
	var n=$("#inputState").val()
	if(n>0){
		partcontrol(n);
	}
}
function partcontrol(n){
	var dyn='';
	for(var i=1;i<=n;i++){
	dyn+=' <div class="form-row col-md-12">'
		+'<div class="form-group col-md-6">'
          +'<input id="Full Name" name="part'+i+'" placeholder="Participent'+i+'" class="form-control" type="text">'
                       +'</div>'
                       +'<div class="form-group col-md-6>'
                       +'<input type="radio" name="presence" value="dont know">'
                       +'<input type="radio" name="presence'+i+'" value="present"> present &nbsp;&nbsp;'
                       +'<input type="radio" name="presence'+i+'" value="absent"> absent'
                       +'</div></div>';
	}
	alert(dyn);
	$("#forpart").append(dyn);
	
}