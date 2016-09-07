<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="utf-8"/>

<div class="box_border" style="margin-top: 5px; margin-bottom: 10px;">
<table class="list_table" style="width:85%">
<colgroup>
	<col style="width:70px;"/>
	<col style="width:auto;"/>
	<col style="width:100px"/>
</colgroup>

<thead>
	<tr>
		<th>순서</th><th>제목</th><th>작성자</th>
	</tr>
</thead>

<tbody>
	<c:if test="${empty bbslist}">
	<tr>
		<td colspan="3">작성된 글이 없습니다.</td>
	</tr>	
	</c:if>
	
	<!-- for(array n:arrays) -->
	<c:forEach items="${bbslist }" var="bbs" varStatus="vs">
	<c:if test="${bbs.del == 3}">
		<tr class="_hover_tr">
			<td>${vs.count }</td>
			<td style="text-align: left">
				이 글은 삭제 되었습니다.
			</td>	
			<td>${bbs.id }</td>
		</tr>
	</c:if>
	<c:if test="${bbs.del == 0}">
		<jsp:setProperty property="depth" name="ubbs" value="${bbs.depth }"/>
		<tr class="_hover_tr">
			<td>${vs.count }</td>
			<td style="text-align: left">
				<jsp:getProperty property="arrow" name="ubbs"/>
				<a href='bbsdetail.do?seq=${bbs.seq }'>${bbs.title }</a>
			</td>	
			<td>${bbs.id }</td>
		</tr>
	</c:if>
	</c:forEach>
</tbody>
</table>
</div>