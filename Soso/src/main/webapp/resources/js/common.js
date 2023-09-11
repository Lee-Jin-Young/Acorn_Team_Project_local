//gnb
$(document).ready(function(){

    	$(window).scroll(function(){ 
		var top = $(window).scrollTop(); 

		if(top > 0){
			$('header').addClass('active');
			$('header').css('border-bottom','1px solid #ccc');
			$('header').css('background-color','rgba(209, 199, 177, 0.947)');
		}else{
			$('header').removeClass('active');
			$('header').css('border-bottom','0');
			$('header').css('background-color','rgba(0, 89, 81, 0)');
		}
	});

	
	$(window).trigger('scroll');

    var subBg = $('<div class="subBg"></div>');

    $('header').append(subBg);
    
    var gnb = 'header';
    var main = '.gnb .mainNav';
    var sub = '.gnb .subNav' ;
    var bg = 'header .subBg' ;
    var speed = 'fast';
    
    $(gnb).hover(function(){
        $(sub + ',' + bg).stop().slideDown(speed);
        $(main).removeClass('active');
        $(gnb).css('background-color','rgba(209, 199, 177, 0.947)');
        $(gnb).css('border-bottom','1px solid #fff');
    },function(){
        $(sub + ',' + bg).stop().slideUp(speed);
        $(main).removeClass('active');
        $(gnb).css('background-color','rgba(209, 199, 177, 0.947)');
        $(gnb).css('border-bottom','0');
    }); 
    
  //panel
    $(".btn").click(function(){
    	  $('.panel').toggleClass("active");
    });

});

let c1 = document.querySelector('.btn');
let c2 = document.querySelector('.panel');


c1.addEventListener('click', function() {
  c2.classList.toggle('active');
});








