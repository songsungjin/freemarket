<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<fmt:requestEncoding value="utf-8"/>

<style>
<!-- 
.menu_table 
li.menu_item
a:hover{
	background-image:url("<%=request.getContextPath()%>/image/arrow.gif");
	background-repeat:no-repeat;
	background-position:5px 7px;
	background-color:#ffffff;
}   -->
</style> 

<div class="menu_table">
	<ul style="width:100%;">
		<li class="title">일정관리</li>
		<li class="subtitle">일정관리</li>
		<li class="menu_item">
			<a href="#none" onclick="url_calendar()" title="일정달력">일정달력</a>
		</li>
		<li class="menu_item">
			<a href="#none" onclick="url_calwrite()" title="일정쓰기">일정쓰기</a>
		</li>
	</ul>
</div> 

<<script type="text/javascript">
function url_calwrite(){ 
	alert('url_calwrite');
	self.location.href="calwrite.do";
	return false;
}
function url_calendar(){ 
	alert('url_calendar');
	self.location.href="calendar.do";
	return false;
}
</script>



