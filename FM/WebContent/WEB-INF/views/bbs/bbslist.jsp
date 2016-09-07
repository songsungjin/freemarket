<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="utf-8"/>

<div class="box_border" style="margin-top: 5px; margin-bottom: 10px;">

<form name="frmForm1" id="_frmFormSearch" method="post" action="">

<table style="margin-left: auto; margin-right:auto; margin-top: 3px; margin-bottom: 3px; border: 0; padding: 0;">
<tr>
	<td>검색:</td>
	<td style="padding-left: 5px">
		<select id="_s_category" name="s_category">
			<option value="" selected="selected">선택</option>
			<option value="title">제목</option> 
			<option value="contents">내용</option>
		</select>
	</td>
	<td style="padding-left: 5px;">
		<input type="text" id="_s_keyword" name="s_keyword" value="${s_keyword }"/>
	</td>
	<td style="padding-left: 5px;">
		<span class="button blue">
			<button type="button" id="_btnSearch">검색</button>		
		</span>
	</td>
</tr>
</table>

<input type="hidden" name="pageNumber" id="_pageNumber" 
	value="${(empty pageNumber)?0:pageNumber }"/>
<input type="hidden" name="recordCountPerPage" id="_recordCountPerPage"	
	value="${(empty recordCountPerPage)?0:recordCountPerPage }"/>

</form>
</div> 

<jsp:useBean id="ubbs" class="sist.co.help.BBSHelp"/>

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

<div id="button_wrap">
	<span class="button blue">
		<button type="button" id="_btnAdd">글쓰기</button>	
	</span>
</div>

<!-- <a href="bbswrite.do">글쓰기</a> -->

<div id="paging_wrap">
<jsp:include page="/WEB-INF/views/common/paging.jsp" flush="false">
	<jsp:param value="${pageNumber }" name="pageNumber"/>
	<jsp:param value="${pageCountPerScreen }" name="pageCountPerScreen"/>
	<jsp:param value="${recordCountPerPage }" name="recordCountPerPage"/>
	<jsp:param value="${totalRecordCount }" name="totalRecordCount"/>
</jsp:include>
</div>

<form name="frmForm2" id="_frmForm" method="get" action="bbswrite.do">
</form>

<script type="text/javascript">
$(document).ready(function() {	
	$("._hover_tr").mouseover(function() {
		$(this).children().css("background-color", "#F0F5FF");		
	}).mouseout(function() {
		$(this).children().css("background-color", "#FFFFFF");
	});
});

$("#_btnAdd").click(function() {
//	alert("글쓰기");
	$("#_frmForm").attr({"target":"_self", "action":"bbswrite.do"}).submit();
});

$("#_btnSearch").click(function() {
//	alert("글검색");
	$("#_frmFormSearch").attr({"target":"_self", "action":"bbslist.do"}).submit();
});

function goPage(pageNumber) {
	$("#_pageNumber").val(pageNumber);
	$("#_frmFormSearch").attr("target", "_self").attr("action", "bbslist.do").submit();
}

</script>







