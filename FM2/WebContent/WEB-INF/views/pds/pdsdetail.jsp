<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="utf-8"/>

<table class="list_table" style="width:85%;">
<colgroup>
	<col width="200"/>
	<col width="500"/>
</colgroup>

<tr>
	<th>게시자</th>
	<td style="text-align: left">${pds.id }</td>
</tr>

<tr>
	<th>제목</th>
	<td style="text-align: left">${pds.title }</td>
</tr>

<tr>
	<th>다운로드</th>
	<td style="text-align: left">
		<input type="button" name="btnDown2" value="다운로드"
			onclick="filedowns('${pds.filename}', '${pds.seq }')"/>
	</td>
</tr>

<tr>
	<th>조회수</th>
	<td style="text-align: left">${pds.readcount }</td>
</tr>

<tr>
	<th>다운수</th>
	<td style="text-align: left">${pds.downcount }</td>
</tr>

<tr>
	<th>파일명</th>
	<td style="text-align: left">${pds.filename }</td>
</tr>

<tr>
	<th>등록일</th>
	<td style="text-align: left">${pds.regidate }</td>
</tr>

<tr>
	<th>내용</th>
	<td style="text-align: left">
		<textarea rows="10" cols="50" 
		name='content' id="_content">${pds.content }</textarea>
	</td>
</tr>
</table>



<form name="delfileup" action="fileDownload.do" method="post">
	<input type="hidden" name="filename"/>
	<input type="hidden" name="seq"/>
</form>

<form name="frmForm2" id="_frmForm2" action="pdsupdate.do" method="post">
	<input type="hidden" name="seq" value="${pds.seq }"/>
</form>

<div id="button_wrap">
	<span class="button blue">
		<button type="button" id="_btnAdd">수정하기</button>	
	</span>
</div>

<script type="text/javascript">

$("#_btnAdd").click(function() {
	alert('수정하기');
	$("#_frmForm2").attr({"target":"_self", "action":"pdsupdate.do"}).submit();
});

function filedowns(filename, pdsid) {
	alert(filename + ' ' + pdsid);
	
	var doc=document.delfileup;
	doc.filename.value = filename;
	doc.seq.value = pdsid;
	doc.submit();
}


</script>



