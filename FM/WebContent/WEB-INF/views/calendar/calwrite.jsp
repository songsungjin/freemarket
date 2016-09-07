<%@ page contentType="text/html; charset=UTF-8"%>

<%@page import="sist.co.help.myCal"%>
<%@page import="java.util.Calendar"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="utf-8"/>

<%
myCal jcal = (myCal)request.getAttribute("jcal");

String year = "" + jcal.getYear();
String month = "" + jcal.getMonth();
String day = "" + jcal.getDay();

Calendar cal = Calendar.getInstance();
int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH) + 1;
int tday = cal.get(Calendar.DATE);
int thour = cal.get(Calendar.HOUR_OF_DAY);	//HOUR_OF_DAY: 24시간
int tmin = cal.get(Calendar.MINUTE);

%>

<form action="calwriteAf.do" method="post">

<table class="list_table" style="width:85%;">
<colgroup>
	<col style="width:200px;">
	<col style="width:auto;">	
</colgroup>

<tr>
	<th>아이디</th>
	<td style="left">${login.id }
		<input type="hidden" name='id' value="${login.id }">
	</td>
</tr>

<tr>
	<th>제목</th>
	<td style="text-align: left">
		<input type="text" size="60" name='title'/>
	</td>
</tr>

<tr>
	<th>일정</th>
	<td style="text-align: left">
		<select name='year'>
			<%
			for(int i=tyear - 5; i < tyear + 5; i++){
				%>
				<option <%=year.equals(i+"")?"selected='selected'":"" %>
										value="<%=i %>" ><%=i %></option>
				<%
			}
			%>			
		</select>년
		
		<select name='month'>
			<%
			for(int i = 1; i <= 12; i++){
				%>
				<option <%=month.equals(i+"")?"selected='selected'":"" %>
										value="<%=i %>" ><%=i %></option>
				<%
			}
			
			%>		
		</select>월
		
		<select name='day'>
			
			<%			
			for(int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
				%>
				<option <%=day.equals(i+"")?"selected='selected'":"" %>
										value="<%=i %>" ><%=i %></option>
				<%
			}
			%>		
		</select>일
		
		<select name='hour'>		
			<%
			for(int i = 0; i < 24; i++){
				%>
				<option <%=(thour+"").equals(i+"")?"selected='selected'":"" %>
										value="<%=i %>" ><%=i %></option>
				<%
			}
			%>	
		</select>시
		
		<select name='min'>
		<%
			for(int i = 0; i < 60; i++){
				%>
				<option <%=(tmin+"").equals(i+"")?"selected='selected'":"" %>
										value="<%=i %>" ><%=i %></option>
				<%
			}
			%>		
		</select>분 	
	</td>	
</tr>

<tr>
	<td>내용</td>
	<td style="text-align: left">	
		<textarea name='content' rows="20" cols="60"></textarea>
	</td>
</tr>

<tr>
	<td colspan="2">
		<input type="submit" value="일정쓰기"/>
	</td>
</tr>

</table>
</form>






