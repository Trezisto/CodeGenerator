// http://madebyevan.com/fsm/ 

window.addEventListener('load', function () {
  // Get the canvas element.
  var elem = document.getElementById('fsm');
  if (!elem || !elem.getContext) {
    return;
  }

  // Get the canvas 2d context.
  var context = elem.getContext('2d');
  if (!context) {
    return;
  }

  // Now you are done! Let's draw something new!
  context.beginPath();
  context.arc(75, 75, 10, 0, Math.PI*2, true);
  context.stroke();
  context.closePath();
}, false);