let AccBtn = document.getElementById("AccordionBtn");
let AccordionMenu = document.getElementById("AccordionMenu");

let AccordionToggle = false;

AccBtn.addEventListener("click", function(){
	if (AccordionToggle == false){
		AccordionMenu.classList.remove('off')
		AccordionMenu.classList.add('on');
		AccordionToggle = true;
	}
	else{
		AccordionMenu.classList.add('off')
		AccordionMenu.classList.remove('on');
		AccordionToggle = false;
	}
});

$('.loginBtn').click(function(){
    $('.modal_login').addClass('on')
    document.body.style.overflow = "hidden";
    return false
})

$('.signUpBtn').click(function(){
    $('.modal_signUp').addClass('on')
    document.body.style.overflow = "hidden";
    return false
})

$('.loginExit').click(function(){

    $('.modal_login').removeClass('on')
    document.body.style.overflow = "unset";
    return false
})

$('.signUpExit').click(function(){

    $('.modal_signUp').removeClass('on')
    document.body.style.overflow = "unset";
    return false
})



