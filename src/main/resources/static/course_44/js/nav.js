
$(function () {
  $('.navbar-toggler').click(function () {
    $('body').toggleClass('noscroll');
  })
});

$(window).on("scroll", function () {
  var scroll = $(window).scrollTop();

  if (scroll >= 80) {
    $("#site-header").addClass("nav-fixed");
  } else {
    $("#site-header").removeClass("nav-fixed");
  }
});

$(".navbar-toggler").on("click", function () {
  $("header").toggleClass("active");
});
$(document).on("ready", function () {
  if ($(window).width() > 991) {
    $("header").removeClass("active");
  }
  $(window).on("resize", function () {
    if ($(window).width() > 991) {
      $("header").removeClass("active");
    }
  });
});

var stars = '';
for (var i = 0; i < 5; i++) {
  stars += '<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="s1 bi bi-star-fill" viewBox="0 0 16 16">';
  stars += '<path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z" />';
  stars += '</svg>';
}

$('s1').html(stars);


window.onscroll = function () {
  scrollFunction()
};
function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    document.getElementById("movetop").style.display = "block";
  } else {
    document.getElementById("movetop").style.display = "none";
  }
}
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}
