/**
 * Dinesh
 */

var b = true;
var run = true ;
function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}

$(document).ready(function() {

	var time = new Date().getTime();

	var user = getCookie("eid");

	

	setTimeout(function(b) {
		b = true;
		if(run){
		sendAjax(b);
	}
	}, 30000);

	if (b) {
		setInterval(function(b) {
			if(run){
			sendAjax(b);
			}
			b = false;
		}, 30000);
	}

	function sendAjax(b) {

		pdpTimeDataM();

		var a = {
			myData : JSON.parse(window.localStorage.getItem("myData")),
			currUrl : window.location.pathname,
			user : user
		}
		$.ajax({
			headers : {
				'Content-Type' : 'application/json'
			},
			url : "http://localhost:9090/getIntent",
			data : JSON.stringify(a),
			method : "POST",
			success : function(result) {
				window.sessionStorage.setItem("userscore", result);
				if(result==0){
					run = false;
				}
			}
		});
	}
});
