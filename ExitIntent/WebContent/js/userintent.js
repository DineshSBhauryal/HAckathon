var isShown = false;
$(window).on("keydown", function(e) {

	var score = window.sessionStorage.getItem("userscore");
	if (e.keyCode == 18 || e.keyCode == 9) {

		if (score > 0.4 && !isShown) {

			overlay1();
			localStorage.removeItem("myData");
			sessionStorage.removeItem("userscore");
			isShown = true;

		}
	}
});
function overlay() {
	/*el = document.getElementById("overlay");
	el.style.visibility = "visible";*/
	$("#myModal").modal();
}

function addEvent(obj, evt, fn) {
	if (obj.addEventListener) {
		obj.addEventListener(evt, fn, false);
	} else if (obj.attachEvent) {
		obj.attachEvent("on" + evt, fn);
	}
}

addEvent(document, "mouseout", function(e) {
	e = e ? e : window.event;
	var from = e.relatedTarget || e.toElement;
	var score = window.sessionStorage.getItem("userscore");
	if (!from || from.nodeName == "HTML") {

		if (score > 0.35 && !isShown) {
			overlay1();
			localStorage.removeItem("myData");
			sessionStorage.removeItem("userscore");
			isShown = true;

		}
	}
});

function overlay1() {
	$("#myModal").modal();
}
