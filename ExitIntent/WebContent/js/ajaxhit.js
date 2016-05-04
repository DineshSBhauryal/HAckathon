/**
 * Dinesh
 */
$(document).ready(function(){
	var time=new Date().getTime();
		setTimeout(function(b){b=true;sendAjax(b);},18000);
		function sendAjax(b){
				var a = {
						"token" : "mykdf",
						"totalTime" : "45",
						"pageTime" : "12",
						"mouseHover" : "2",
						"initScore" : "421",
						"pageVisited" : "2"
					}


				$.ajax({
					headers: { 
						'Content-Type': 'application/json' 
					},
					url: "http://localhost:9090/getIntent",
					data:JSON.stringify(a),
					method  : "POST",
					success: function(result){
						//alert(result);
						document.cookie = "userscore="+result;
					}
				});
				if(b){
					setInterval(function(b){b=false;sendAjax(b);},6000);
				}
		}
});
