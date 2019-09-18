/**
 * 
 */
function tempAlert(cls,msg,duration)
{	$(".err").addClass(cls);
 	$(".err").html("<center>"+msg+"</center>");
 setTimeout(function(){
	 $(".err").css("display","none");
 },duration);
 	$(".err").css("display","block");
}