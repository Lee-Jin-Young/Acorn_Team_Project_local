/* main*/
$(document).ready(function(){
	//글씨 타이핑 js
    const content = "함께 하는 독서 모임 , 북메이트 ";
    const text = document.querySelector(".text");
    text.textContent = "";
    let txtIdx = 0;
    function typing(){
        let txt = content[txtIdx++];
        if (txt == undefined) return;
        text.innerHTML += txt=== "\n" ? "<br/>": txt;
        if (txtIdx > content.length) {
            txtIdx = 0;
        }else{
            setTimeout(typing, 200)
        }
    }
    typing();
    
    //스크롤 top 버튼 js
    const scrollTop = function () {
    // create HTML button element
    const scrollBtn = document.createElement("button");
    scrollBtn.innerHTML = "TOP";
    scrollBtn.setAttribute("id", "scroll-btn");
    document.body.appendChild(scrollBtn);
    // hide/show button based on scroll distance
    const scrollBtnDisplay = function () {
        window.scrollY > window.innerHeight
        ? scrollBtn.classList.add("show")
        : scrollBtn.classList.remove("show");
    };
    window.addEventListener("scroll", scrollBtnDisplay);
    // scroll to top when button clicked
    const scrollWindow = function () {
        if (window.scrollY != 0) {
        setTimeout(function () {
            window.scrollTo(0, window.scrollY - 50);
            scrollWindow();
        }, 10);
        }
    };
    scrollBtn.addEventListener("click", scrollWindow);
    };
    scrollTop();
    
    //
    var swiper = new Swiper("main .swiper", {
    	 initialSlide : 0,

         slidesPerView: 'auto',

         observer: true,

         observeParents: true,

         loop: true,
    	pagination: {
          el: ".swiper-pagination",
          type: "fraction",
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
        autoplay: {
            delay: 3000,
        }
    });
    
    var swiper = new Swiper(".our-business .swiper", {
   	 	initialSlide : 0,

        slidesPerView: 'auto',

        observer: true,

        observeParents: true,

        loop: true,
   	pagination: {
         el: ".swiper-pagination",
         type: "fraction",
       },
       navigation: {
         nextEl: ".swiper-button-next",
         prevEl: ".swiper-button-prev",
       },
       autoplay: {
           delay: 3000,
       }
   });
});






