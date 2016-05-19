document.captureEvents(Event.MOUSEMOVE)

var x = null;
var y = null;
var d = null;
document.addEventListener('mousemove', onMouseUpdate, false);
document.addEventListener('mouseenter', onMouseUpdate, false);

function onMouseUpdate(e) {
	d =new Date();
    x = e.pageX;
    y = e.pageY;
	my = document.elementFromPoint(x, y);

	return my ;
}

function getMouseX() {
    return x;
}

function getMouseY() {
    return y;
}
