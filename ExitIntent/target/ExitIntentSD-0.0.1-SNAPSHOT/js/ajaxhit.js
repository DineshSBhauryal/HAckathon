/**
 * Dinesh
 */
$(document).ready(function(){

	$("button#111").click(function(){
		var a = {
				"token" : "mykdf",
				"totalTime" : "45",
				"pageTime" : "12",
				"mouseHover" : "2",
				"initScore" : "421",
				"pageVisited" : "2"
			}
	    $.ajax({url: "http://exit.intent.com:9090/getIntent",data:a, type : "POST", success: function(result){
	        $("#div1").html(result);
	    }});
	});	
});
