/**
 * Dinesh
 */

var b=true;

$(document).ready(function(){

	var time=new Date().getTime();

	setTimeout(function(b){
		b=true;sendAjax(b);
	},
	180000);
	
	if(b){
		setInterval(function(b){
			sendAjax(b);b=false;
		},
		60000);
	}
	
	function sendAjax(b){

		pdpTimeDataM();

		var a ={myData:JSON.parse(window.localStorage.getItem("myData")),currUrl:window.location.pathname}
		$.ajax({
			headers: { 
				'Content-Type': 'application/json' 
			},
			url: "http://localhost:9090/getIntent",
			data:JSON.stringify(a),
			method  : "POST",
			success: function(result){
				window.sessionStorage.setItem("userscore",result);
			}
		});	
	}
});
