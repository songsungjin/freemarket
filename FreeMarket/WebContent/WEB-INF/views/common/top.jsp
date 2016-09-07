<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style>
#titlespace{
	border-bottom: 1px solid black;
	background-color: #6799FF;
}
</style>
<jsp:useBean id="nows" class="java.util.Date"/>

<div id="titlespace">
			<c:choose>
				<c:when test="${login.id eq '' || login.name eq ''}">
				어서오세요 ㅋㅋㅋ	
				</c:when>
				<c:otherwise>
					<form action="loginAf.do" id="_frmFormlogin" method="post">
					ID:<input type="text" name="id" size="20" id="_userid" data-msg="ID를" placeholder="ID">&nbsp;&nbsp;
					PW:<input type="password" name="pwd" size="20" id="_pwd" data-msg="암호를" placeholder="PW">
					<a href="#none" id="_btnlogin" title="로그인"><img src="image/login_btn.jpg" alt="로그인"/></a>
					</form>
				</c:otherwise>
			</c:choose>
</div>
<script type="text/javascript">
$('#_btnlogin').click(function (){
	if($("#_userid").val() == ""){
		alert($("#_userid").attr("data-msg") + " 입력해 주십시오");
		$("#_userid").focus();
	}else if($('#_pwd').val() == ""){
		alert($("#_pwd").attr("data-msg") + " 입력해 주십시오");
		$("#_pwd").focus();
	}else{
		$("#_frmFormlogin").attr("target", "_self").submit();	//위의 두조건에 해당하지 않으면 원래 작업실행
	}
});

$("#_btnRegi").click(function(){
	location.href="regi.do";
});

$("#_userid").keypress(function(){
	if(event.which == '13'){	//입력정보가 13자를 넘을 수 없음
		event.preventDefault();	//실행한 부분을 유지시켜주는 함수.
		$("#_pwd").focus();
	}
});

$("#_pwd").keypress(function(){
	if(event.which == '13'){	
		event.preventDefault();	
		$("#_btnlogin").click();
	}
});

$(function(){
    $("#popbutton").click(function(){
        $('div.modal').modal();
    })
})
</script>