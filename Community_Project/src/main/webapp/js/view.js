$('.commentActive').click(function(){

    let d = $(this).siblings('.commentInput').css('display');

    if(d=='block'){
        $('.commentInput').removeClass('on')
    }
    else{
        $('.commentInput').removeClass('on')
        $(this).next().addClass('on')
    }
    return false
})


function checkComment(frm){
	if(frm.content.value == ""){
		alert("빈 값을 제출할 수 없습니다.");
		frm.content.focus();
		return false;
	}
}

$('.subCommentAreaActive').click(function(){
	
	let d = $(this).prev().css('display');
	
	if(d=="block"){
		$(this).prev().removeClass('on')
		$(this).text('답글보기')
	}else{
		$(this).prev().addClass('on')
		$(this).text('답글접기')
	}
})