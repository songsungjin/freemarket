<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<fmt:requestEncoding value="utf-8"/>
<tiles:insertAttribute name="common"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<style type="text/css">
</style>
	<tiles:insertAttribute name="header"/>
</head>
<body>
<div id="main_wrap">
		<div id="header_wrap">
			<tiles:insertAttribute name="top_inc"/>
			<tiles:insertAttribute name="top_menu"/>
		</div>
		
		<div id="body_warp">
			<div id="main_image_wrap">
				<img alt="배너 사진" src="<%=request.getContextPath()%>/image/leva.jpg">
			</div>
			<div id="content_wrap" style="background-color: #6799FF; width: 100%;">
				<h>-----------------------------------</h>
				<h1>물건들이 올라오는 곳</h1>
				<tiles:insertAttribute name="main"/>
			</div>
		</div>
</div>
</body>
</html>