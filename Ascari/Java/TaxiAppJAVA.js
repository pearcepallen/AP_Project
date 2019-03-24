const body = document.body;
const btn = document.querySelectorAll('.button')[0];

btn.addEventListener('mouseenter', () => {
    body.classList.add('show');
});

btn.addEventListener('mouseleave', () => {
    body.classList.remove('show');
});

// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function () {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}


$(document).ready(function () {
    $('.clickme').click(function (e) {
        e.preventDefault();

        boxh = $('#popup').height();
        windowh = $(window).height();

        $('#popup').css('margin-top', windowh / 2 - boxh / 2);

        $('#popup').fadeIn();
    });
    $('.clicktoclose').click(function () {
        $('#popup').fadeOut;
    });
});