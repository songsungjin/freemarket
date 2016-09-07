<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="utf-8"/>

<%@ page import="sist.co.help.DateUtil" %>
<%@ page import="sist.co.model.SistPollDTO" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>


<%@ page contentType="text/html; charset=UTF-8"%>

<%
List<SistPollDTO> plists = new ArrayList<SistPollDTO>();
Object Oflist = request.getAttribute("plists");
if(Oflist != null){
	plists = (List<SistPollDTO>)Oflist;
}
%>

<c:if test="${login.auth eq '3' }">	<%-- 사용자 --%>

<table class="list_table" style="width:95%;">
	<col width="50"/><col width="50"/><col width="300"/>
	<col width="100"/><col width="100"/><col width="50"/>
	<col width="50"/><col width="100"/><col width="100"/>
	
	<tr>
		<th>번호</th><th>아이디</th><th>질문</th>
		<th>결과</th><th>시작일</th><th>끝나는 날</th>
		<th>질문항수</th><th>투표수</th><th>등록일</th>
	</tr>
	
	<%
	for(int i = 0;i < plists.size(); i++){
		SistPollDTO poll = plists.get(i);
	%>
		<tr bgcolor="#aabbcc">
			<td><%=(i+1) %></td>
			
			<td><%=poll.getId() %></td>			
			
			
		<% // 질문-----------------------------------
		boolean isS = poll.isVote();
		if(isS || DateUtil.isEnd(poll.getEdate())){	// 투표기간이 지났을 때
			%>
			<td>[마감]<%=poll.getQuestion() %></td>
			<%
		}else{	// 투표가 가능	
			%>		
			<td>
				<a href='polldetail.do?pollid=<%=poll.getPollid() %>'>
					<%=poll.getQuestion() %>
				</a>
			</td>
			<%
		}	// 질문-----------------------------------
		%>
				
			<td>
			<%
			if(isS || DateUtil.isEnd(poll.getEdate())){
				%>
				<a href="pollresult.do?pollid=<%=poll.getPollid() %>">
					결과
				</a>	
				<%
			}else{	// 투표를 안해서 못보는 부분
				%>
				<img src="image/pen.gif"/>
				<%
			}
			%>				
			</td>	
			<td><%=poll.getSdate() %></td>
			<td><%=DateUtil.pollState(poll.getEdate()) %><%=poll.getEdate() %></td>
			<td><%=poll.getItemcount() %></td>
			<td><%=poll.getPolltotal() %></td>
			<td><%=poll.getRegdate() %></td>
		</tr>
		<%
	}
%>
</table>
</c:if>

<c:if test="${login.auth eq '1' }">	<%-- 관리자 --%>

<table class="list_table" style="width:95%;">
	<col width="50"/><col width="50"/><col width="300"/>
	<col width="100"/><col width="100"/><col width="50"/>
	<col width="50"/><col width="100"/><col width="100"/>
	
	<tr>
		<th>번호</th><th>아이디</th><th>질문</th>
		<th>시작일</th><th>끝나는 날</th><th>질문항수</th>
		<th>투표수</th><th>등록일</th>
	</tr>
	
	<%
	for(int i = 0;i < plists.size(); i++){
		SistPollDTO poll = plists.get(i);
		%>
		<tr bgcolor="#aabbcc">
			<td><%=(i+1) %></td>
			<td><%=poll.getId() %></td>
			<td><%=poll.getQuestion() %></td>
			<td><%=poll.getSdate() %></td>
			<td><%=DateUtil.pollState(poll.getEdate()) %><%=poll.getEdate() %></td>
			<td><%=poll.getItemcount() %></td>
			<td><%=poll.getPolltotal() %></td>
			<td><%=poll.getRegdate() %></td>
		</tr>		
		<%
	}
	%> 
	<%-- <c:forEach var="i" items="${plists}" varStatus="pool">
		<tr bgcolor="#aabbcc">
			<td>${pool.count }</td>
			<td>${i.id }</td>
			<td>${i.question }</td>
			<td>${i.sdate }</td>
			<td>${i.edate }</td>
			<td>${i.itemcount }</td>
			<td>${i.polltotal }</td>
			<td>${i.regdate }</td>
		</tr>
	</c:forEach> --%>
</table>

</c:if>














