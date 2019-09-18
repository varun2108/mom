/**
 * 
 */
function validatealpa(evt) {
		  var theEvent = evt || window.event;

		  // Handle paste
		  if (theEvent.type === 'paste') {
		      key = event.clipboardData.getData('text/plain');
		  } else {
		  // Handle key press
		      var key = theEvent.keyCode || theEvent.which;
		      key = String.fromCharCode(key);
		  }
		  var regex = /^[A-Za-z]+$/;
		  if( !regex.test(key) ) {
		    theEvent.returnValue = false;
		    if(theEvent.preventDefault) theEvent.preventDefault();
		  }
		}
	function CheckPassword(inputtxt) 
	{ 
	var passw=  /^[A-Za-z]\w{7,11}$/;
	if(inputtxt.value.match(passw)) 
	{ 
		$("#pass").html('');

	}
	else
	{ 
		$("#pass").html('<small style="color:red">value must contain alphanumaric within the length 7-10<small>');
		inputtxt.value='';
	}
	}
	function foc(){
		$("#pass").html('');
	}

	function validate(evt) {
		  var theEvent = evt || window.event;

		  // Handle paste
		  if (theEvent.type === 'paste') {
		      key = event.clipboardData.getData('text/plain');
		  } else {
		  // Handle key press
		      var key = theEvent.keyCode || theEvent.which;
		      key = String.fromCharCode(key);
		  }
		  var regex = /[0-9]|\./;
		  if( !regex.test(key) ) {
		    theEvent.returnValue = false;
		    if(theEvent.preventDefault) theEvent.preventDefault();
		  }
		}
