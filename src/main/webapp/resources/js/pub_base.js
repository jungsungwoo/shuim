var provFlag = 0;
function setProvMouseOut(){
	provFlag = 0;
}

$(document).ready(function(){
	/*gnb********************************************/
	$("#gnb ul li:first-child").addClass("fir");
	$("#gnb ul.list").wrap("<div class='ul_wrap'></div>");
	$("#gnb .depth01>li").each(function(){
		if($(this).hasClass("on")){
			$(this).find("img.d01").attr("src", $(this).find("img").attr("src").replace(".png","_on.png"));
		}
	});
	$("#gnb .depth01>li img.d01").hover(function(){//btn Img
		if($(this).attr("src").indexOf("_on.png")==-1){
			$(this).attr("src",$(this).attr("src").replace(".png","_on.png"));
		}
		$("#gnb .depth02").removeClass("over");
		$(this).parent().next().addClass("over");
	},function(){
		if($(this).parents("li").hasClass("on")==false){
			$(this).attr("src",$(this).attr("src").replace("_on.png",".png"));
		}
	});
	$("#gnb ul li").on("mouseover focus",function(){
		$(this).addClass("over");
	});
	$("#gnb ul li").on("mouseleave",function(){
		$("#gnb ul li").removeClass("over");
	});
	$("#gnb").on("mouseleave",function(){
		$("#gnb .depth01>li").each(function(){
			if($(this).hasClass("on")==false){
				$(this).find("img.d01").find("img.d01").attr("src",$(this).find("img.d01").attr("src").replace("_on.png",".png"));
			}
		});
		$("#gnb .depth02").removeClass("over");
	});
	
	// table
	$(".tbl_area table tr:last-child").addClass("last");
	
	// 플로팅 메뉴 - 우측
	/*
	if($("body .floating_area").length > 0){
		if($("body .floating_area").hasClass("no_script")){}
		else{jQuery('.floating_area').containedStickyScroll();}
	}
	*/
		
	// 탭메뉴
	function changeContents(idx){
		var tabAnchorList = $(".tab_shMenu").find("li");
		tabAnchorList.each(function(idx){
			if($(this).hasClass("on")){}
			else{
				if($(this).find("img")==true){
					$(this).find("img").attr("src",$(this).find("img").attr("src").replace("_on.png",".png"));
				}
			}
		});	
		$(".tab_shCont").hide();
		$($(".tab_shCont").get(idx)).show();
	}
	function initPageContents(){
		var tabAnchorList = $(".tab_shMenu").find("li");
		if($(tabAnchorList.get(0))==true){
			$(tabAnchorList.get(0)).find("img").attr("src",$(tabAnchorList.get(0)).find("img").attr("src").replace(".png","_on.png"));
		}
		$(".tab_shCont").hide();
		$($(".tab_shCont").get(0)).show();
		tabAnchorList.each(function(idx){
			this.href = "";						//링크의 형태를 만들기 위해서
			$(this).click(function(){
				if($(this).is(".no_script")){}
				else{
					$(this).parent().find("li").removeClass("on");
					$(this).addClass("on");
					
					if($(this).find("img")==true && $(this).find("img").attr("src").indexOf("_on.png")==-1){
						$(this).find("img").attr("src",$(this).find("img").attr("src").replace(".png","_on.png"));
					}
					changeContents(idx);
					return false;
				}
			});
		});
	}
	if($("body").find(".tab_shMenu").length!=0){
		initPageContents();	
	}
	
		
	// 마우스 오버,아웃 (클래스 변환)
	$(".jq_hover02").hover(function(){
		$(this).addClass("on");
	},function(){
		$(this).removeClass("on");
	});
	
	// 마우스 오버,아웃 (이미지 변환)
	$(".jq_hover01").hover(function(){
		$(this).attr("src",$(this).find("img").attr("src").replace(".png","_on.png"))
	},function(){
		$(this).removeClass("on");
		$(this).attr("src",$(this).find("img").attr("src").replace("_on.png",".png"))
	});
	
	// 마우스 오버,아웃 (클래스,이미지 변환)
	$(".jq_hover03").hover(function(){
		$(this).addClass("on");
		$(this).find("img").attr("src",$(this).find("img").attr("src").replace(".png","_on.png"))
	},function(){
		$(this).removeClass("on");
		$(this).find("img").attr("src",$(this).find("img").attr("src").replace("_on.png",".png"))
	});
	
	// Toggle	
	if($("body").find(".tgl_tit").length!=0){
		$(".tgl_con").hide(); //Hide/close all containers
		//$(".toggle_con:first").addClass("on").next().show(); //Add "active" class to first trigger, then show/open the immediate next container
		
		$(".tgl_tit").on("click",function(){
			if( $(this).next().is(":hidden") ) { //If immediate next container is closed...
				$(".tgl_tit").removeClass("on");
				$(".tgl_tit").next().hide().removeClass("on"); //Remove all .toggle_con classes and slide up the immediate next container
				$(this).addClass("on");
				$(this).next().show().toggleClass("on"); //Add .toggle_con class to clicked trigger and slide down the immediate next container
			}else {
				$(this).next().hide().removeClass("on");
				$(this).removeClass("on");
			}
			return false; //Prevent the browser jump to the link anchor
		});
	}
	
	// Toggle - 답글
	if($("body").find(".btn_reply").length!=0){
		$(".reply_reply_box").hide();
		$(".btn_reply .count").each(function(){
			if($(this).html()==0) {
				$(this).parent(".btn_reply").addClass("on");
				$(this).parent(".btn_reply").next().show().addClass("on");
			}
		});
		$(".btn_reply").on("click",function(){
			if( $(this).next().is(":hidden") ) {
				$(this).addClass("on");
				$(this).next().show().addClass("on");
			}else {
				$(this).next().hide().removeClass("on");
				$(this).removeClass("on");
			}
			return false;
		});
	}
	
	/* Smooth Page Scroll
	--------------------------------------------------*/
	$(".page_scroll li a").click(function () {
	    var full_url = this.href;
	    var parts = full_url.split("#");
	    var trgt = parts[1];
	    var target_offset = $("#" + trgt).offset();
	    var target_top = target_offset.top;
	    $('html, body').animate({
			//scrollTop: target_top
	        scrollTop: target_top- $("#navigation").height()
	    }, 400);
	    return false;
	});

	//top 버튼
	$btn = $(".btn_top");
	$btn.bind("click", function(){
		$("html, body").animate({scrollTop : 0}, 
		{
			duration : 300,
			//easing : "easeOutQuint",
			queue : false
		}); 
	});

});
/*****  플로팅 메뉴 *****/
(function( $ ){
  $.fn.containedStickyScroll = function( options ) {
	var defaults = {  
		unstick : false,
		easing: 'swing',
		duration: 500,
		queue: false,
		closeChar: 'close',
		closeTop: 10,
		closeRight:10  
	}            
	var options =  $.extend(defaults, options);
    var $getObject = $(this).selector;
	var $subWrapMinHeight = jQuery($getObject).height();
	jQuery("#container").css("min-height",$subWrapMinHeight);
	
	if(options.unstick == true){  
		this.css('position','absolute');
		this.append('<a class="scrollFixIt">' + options.closeChar + '</a>');
		jQuery($getObject + ' .scrollFixIt').css('position','absolute');
		jQuery($getObject + ' .scrollFixIt').css('top',options.closeTop + 'px');
		jQuery($getObject + ' .scrollFixIt').css('right',options.closeRight + 'px');
		jQuery($getObject + ' .scrollFixIt').css('cursor','pointer');
		jQuery($getObject + ' .scrollFixIt').click(function() {
			jQuery($getObject).animate({ top: "0px" },
				{ queue: options.queue, easing: options.easing, duration: options.duration });
			jQuery(window).unbind();
			jQuery('.scrollFixIt').remove();
		});
	} 
	
  	jQuery(window).scroll(function() {
		if(jQuery(window).scrollTop() > (jQuery($getObject).parent().offset().top) &&
		   (jQuery($getObject).parent().height() + jQuery($getObject).parent().position().top - 30) > (jQuery(window).scrollTop() + jQuery($getObject).height())){
			jQuery($getObject).animate({ top: (jQuery(window).scrollTop() - jQuery($getObject).parent().offset().top) + "px" }, 
			{ queue: options.queue, easing: options.easing, duration: options.duration });
		}
		else if(jQuery(window).scrollTop() < (jQuery($getObject).parent().offset().top)){
			jQuery($getObject).animate({ top: "0px" },
			{ queue: options.queue, easing: options.easing, duration: options.duration });
		}
	});
  };
})( jQuery );

$(window).load( function() {
	$("input").each(function(){
		if($(this).val() != ""){
			$(this).addClass("on");		
		}
	});
})

/***** INPUT 배경이미지 *****/
function clearImg(obj){
	$(obj).addClass("on");
	$(obj).addClass("over");
	if($(obj).parent().hasClass("fm_input")){
		$(obj).parent().addClass("on")
	}
}
function backImg(obj){
	$(obj).removeClass("over");
	if (obj.value=="")
	$(obj).removeClass("on");
	if($(obj).parent().hasClass("fm_input")){
		$(obj).parent().removeClass("on")
	}
}

/***** INPUT 배경 텍스트 *****/
function clearText(thefield){
if (thefield.defaultValue==thefield.value)
	$(thefield).addClass("over");
        thefield.value = "";
} 
function backText(thefield){
	$(thefield).removeClass("over");
if (thefield.value=="")
        thefield.value = thefield.defaultValue;
} 

/***** TEXTAREA 도움말 *****/ 
function OnEnter( field ) { if( field.value == field.defaultValue ) { field.value = ""; } } 
function OnExit( field ) { if( field.value == "" ) { field.value = field.defaultValue; } } 


//오른쪽 마우스 클릭 금지...
/*
var isNS = (navigator.appName == "Netscape") ? 1 : 0;
var EnableRightClick = 0;
if(isNS) 
document.captureEvents(Event.MOUSEDOWN||Event.MOUSEUP);

function mischandler(){
  if(EnableRightClick==1){ return true; }
  else {return false; }
}

function mousehandler(e){
  try{clickMouse();}catch(e){}
	// select box와의 충돌 때문에 수정
  if(EnableRightClick==1){ return true; }
  var myevent = (isNS) ? e : event;
  var eventbutton = (isNS) ? myevent.which : myevent.button;
  if((eventbutton==2)||(eventbutton==3)) return false;
}

function keyhandler(e) {
  var myevent = (isNS) ? e : window.event;
  if (myevent.keyCode==96)
    EnableRightClick = 1;
  return;
}

document.oncontextmenu = mischandler;
document.onkeypress = keyhandler;
document.onmousedown = mousehandler;
document.onmouseup = mousehandler;
document.onselectstart=new Function("return false"); 

function viewSearch(txt){
	location.href="/front/search/search.jsp?wn_query="+txt;
}
function getSelectedText(obj){
	var text = "";
	try{
		if(!isNull(obj.options[obj.selectedIndex].value)){
			text = obj.options[obj.selectedIndex].text;
		}
	}catch(e){
	}
	return text;
}
*/
