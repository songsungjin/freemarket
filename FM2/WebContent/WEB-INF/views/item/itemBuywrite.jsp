<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이탬 삽니다</title>

<script>
	<%for(int i =0; i<8; i++){%>
	$(document).ready(function(){
		$(".box_photo<%=i%>").click(function() {
	    	window.open("imgupload.do", "popup_window", "width=400, height=200, scrollbars=no");
	    });
	});
	<%}%>
	
	$(document).ready(function(){
		$("#submit_btn").click(function() {
			alert('등록되었습니다');
			$("#_frmForm").attr({"target":"_self", "action":"itemwriteAf.do"}).submit();
			 
		});
	});
	
	<%for(int i =0; i<8; i++){%>
	$(document).ready(function(){
		$(".delete_photo<%=i%>").click(function() {
	    	alert('삭제하시겠습니까?<%=i%>');
	    	
	    });
	});
	<%}%>
	
	
</script>

</head>

<body>
<form id="_frmForm" method="post" action="itemwriteAf.do">
	<img width="185" height="37"src="image/item_buy.png" />
		
	<div>
    	<%for(int i=0; i<4; i++){ %>
	    	<%if(session.getAttribute("fullpath"+i) == null){
	    		%><img src="//image.hellomarket.com/web/background/ico_itemsubmit_photo.png" height="150" width="150" class="box_photo<%=i%>"/>
	    	<%} else{%> <img src="<%=session.getAttribute("fullpath"+i)%>" height="150" width="150" id="photo"/>
	    				<img src="//image.hellomarket.com/web/button/btn_seller_contact_popup_close.png" alt="삭제 버튼" width="15" height="15" class="delete_photo<%=i%>"/>
	    	<%}
    	}%>
		<br>
   		<%for(int i=4; i<8; i++){ %>
	    	<%if(session.getAttribute("fullpath"+i) == null){
	    		%><img src="//image.hellomarket.com/web/background/ico_itemsubmit_photo.png" height="150" width="150" class="box_photo<%=i%>"/>
	    	<%} else{%> <img src="<%=session.getAttribute("fullpath"+i)%>" height="150" width="150" id="photo"/>
	    				<img src="//image.hellomarket.com/web/button/btn_seller_contact_popup_close.png" alt="삭제 버튼" width="15" height="15" class="delete_photo<%=i%>"/>
	    	<%}
    	}%>
    </div>

	<div class="box_title">
		<img src="//image.hellomarket.com/web/tag/img_itemsubmit_itemtitle.png" alt="제목" width="86" height="32"/>
		<input type="text" value="아이템 제목을 입력하세요" id="itemTitle" maxlength="25" value="" />
	</div>
	<div class="box_content">
		<img src="//image.hellomarket.com/web/tag/img_itemsubmit_contents.png" alt="내용" width="86" height="32"/>
		<textarea>아이템에 대한 설명을 작성해주세요. </textarea>
	</div>
	<div class="box_category">
		<img src="//image.hellomarket.com/web/tag/img_itemsubmit_category.png" alt="카테고리" width="86" height="32"/>	
		<select name="category">
			<option>패션잡화</option>
			<option>전자기기</option>
			<option>남성의류</option>
			<option>여성의류</option>
			<option>가구</option>
			<option>예술,미술</option>
			<option>뷰티</option>
			<option>스포츠,레저</option>
			<option>도서,문구</option>
			<option>기타</option>
		</select>
	</div>
	
	<div class="box_address">
		<img src="image/buy_address.png" alt="판매주소" width="86" height="32"/>
		<select name="address">
			<option>서울</option>
			<option>경기</option>
			<option>인천</option>
			<option>강원</option>
			<option>충청</option>
			<option>전북</option>
			<option>전남</option>
			<option>경북</option>
			<option>경남</option>
			<option>제주</option>
		</select>
	
	</div>
	

	<div class="box_price">
		<img src="image/buy_price.png" alt="판매가격" width="86" height="32"/>
		<input type="text" value="희망가격을 입력하세요" id="price"/>
		<img src="//image.hellomarket.com/web/tag/img_itemsubmit_price_won.png" alt="원" width="23" height="32"/>
	</div>
		
		
	<br>
	<div class="button_area">
		<img src="//image.hellomarket.com/web/button/btn_itemsubmit_submit_disable.png" alt="등록 버튼 이미지" width="148" height="41" id="submit_btn"/>
		<img src="//image.hellomarket.com/web/button/btn_itemsubmit_cancel_normal.png" alt="취소" width="148" height="41" id="Cancle_btn" />
	</div>
</form>
</body>
</html>