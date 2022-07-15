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