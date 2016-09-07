<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<fmt:requestEncoding value="utf-8"/>

<form name="frmForm" id="_frmForm" action="pdsupdateAf.do" method="post" 
	enctype="multipart/form-data">

<input type="hidden" name="seq" value="${pds.seq }"/>

<table class="list_table" style="width:85%;">
<colgroup>
	<col style="width:200px;"/>
	<col style="width:auto;"/>
</colgroup>

<tr>
	<td>아이디</td>
	<td style="text-align: left">${pds.id }</td>
</tr>

<tr>
	<td>제목</td>
	<td style="text-align: left">
		<input type="text" name="title" value="${pds.title }" size="50"/>
	</td>
</tr>

<tr>
	<th>파일 업로드</th>
	<td style="text-align: left">
		<input type="text" name="namefile" 
			value="${pds.filename }" size="50" readonly="readonly"/>
		<input type="file" name="fileload" style="width:400px;">			
	</td>
</tr>

<tr>
	<th>내용</th>
	<td style="text-align: left">
		<textarea rows="10" cols="50" name="content" id="_content">
			${pds.content }
		</textarea>
	</td>
</tr>

<tr>
	<td colspan="2" style="height: 50px; text-align: center;">
		<span>
			<a href="#none" id="_btnUpdate" title="수정완료">
				<img src="image/bupdate.png" alt="수정완료"/>
			</a>		
		</span>
	</td>
</tr>
</table>	
</form>

<script type="text/javascript">
$("#_btnUpdate").click(function() {
	alert('수정하기');
	$("#_frmForm").attr({"target":"_self", "action":"pdsupdateAf.do"}).submit();	
});



</script>


