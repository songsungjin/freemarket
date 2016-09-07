<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<fmt:requestEncoding value="utf-8"/>

<form name="frmForm" id="_frmForm" action="pdsupload.do" method="post"
	enctype="multipart/form-data">

<table class="list_table" style="width:85%;">
<colgroup>
	<col style="width:200px;"/>
	<col style="width:auto;"/>
</colgroup>

<tr>
	<th>아이디</th>
	<td style="text-align: left">
		<input type="text" name="id" readonly="readonly"
			value="${login.id }" size="50"/>
	</td>
</tr>

<tr>
	<th>제목</th>
	<td style="text-align: left">
		<input type="text" name="title" size="50"/>
	</td>
</tr>

<tr>
	<th>파일 업로드</th>
	<td style="text-align: left">
		<input type="file" name="fileload" style="width:400px;"/>
	</td>
</tr>

<tr>
	<th>내용</th>
	<td style="text-align: left">
		<textarea rows="10" cols="50" name="content" id="_content">
		</textarea>
	</td>
</tr>

<tr>
	<td colspan="2" style="height:50px; text-align: center;">
	<span>
		<a href="#none" id="_btnLogin" title="글쓰기">
			<img src="image/bwrite.png"/>
		</a>	
	</span>
</tr>
</table>		
</form>

<script type="text/javascript">

$("#_btnLogin").click(function() {
	alert("자료올리기");
	$("#_frmForm").attr({"target":"_self", "action":"pdsupload.do"}).submit();
});

</script>





