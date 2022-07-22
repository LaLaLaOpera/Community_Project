$('.commentActive').click(function(){

    let d = $(this).parent().siblings('.commentInput').css('display');

    if(d=='grid'){
        $('.commentInput').removeClass('on')
    }
    else{
        $('.commentInput').removeClass('on')
        $(this).parent().next().addClass('on')
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
	
	let d = $(this).parent().parent().next().css('display');
	
	if(d=="block"){
		$(this).parent().parent().next().removeClass('on')
		$(this).text('답글보기')
	}else{
		$(this).parent().parent().next().addClass('on')
		$(this).text('답글접기')
	}
})