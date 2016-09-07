<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="utf-8"/>

<%@ page contentType="text/html; charset=UTF-8"%>

<table class="list_table" style="width:95%;">

<colgroup>
	<col width="200px"/>
	<col width="500px"/>
</colgroup>

<tr>
	<th>투표 번호</th>
	<td style="text-align: left">
		<input type="text" name="pollid" value="${poll.pollid }" 
			size="50" readonly="readonly"/>
	</td>
</tr>

<tr>
	<th>아이디</th>
	<td style="text-align: left">
		<input type="text" name="id" value="${login.id }" 
			size="50" readonly="readonly"/>
	</td>
</tr>

<tr>
	<th>투표 기한</th>
	<td style="text-align: left">
		${poll.sdate}~${poll.edate}
	</td>
</tr>

<tr>
<th>투표 내용</th>
<td style="text-align: left">
<textarea rows="10" name='question' readonly="readonly" 
cols="50">${poll.question }</textarea>
</td>
</tr>

<tr>
	<th>투표 상세 문항</th>
	<td style="text-align: left">
	
	<c:forEach items="${pollsublist }" var="psub" varStatus="vs">
	
	<table class="list_table" style="width:95%;">
	<col width="50"/>
	<col width="500"/>
	
		<tr>
			<th>${vs.count }번</th>
			<td style="text-align: left">
				<input type="text" size='60px' readonly="readonly"
					name='answer' value='${psub.answer }'/>
			</td>
		</tr>	
	</table>	
	</c:forEach>
		
	</td>	
</tr>

<tr>
	<th>투표 결과(전체 투표자: ${poll.polltotal }명)</th>
	<td>
		<jsp:useBean id="vbean" class="sist.co.help.VoteBean"/>
			
		<c:forEach items="${pollsublist }" var="psub" varStatus="vs">
		
		<jsp:setProperty property="acount" name="vbean" value="${psub.acount }"/>
		<jsp:setProperty property="total" name="vbean" value="${poll.polltotal }"/>
		
		<table class="list_table" style="width:95%;">
		<col width="50"/><col width="500"/>
		<tr>
			<th>${vs.count }번</th>
			<td style="text-align: left;">
				<jsp:getProperty property="makeBar" name="vbean"/>
			</td>		
		</tr>
		</table>		
		</c:forEach>	
	</td>
</tr>

<a href='polllist.do'>투표 목록</a> 	


</table>



