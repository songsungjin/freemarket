<%@page import="org.apache.tools.ant.types.resources.First"%>
<%@page import="sist.co.help.myCal" %>
<%@page import="java.util.ArrayList" %>
<%@page import="sist.co.model.SistCalendar" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Calendar" %>

<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<style>
table{
	border-collapse: collapse; 
}
table, td, th{
	border: 1px solid black;
}
.sunday{
	color:red;
	text-align: left;
	vertical-align: top;
}
.satday{
	color:blue;
	text-align: left;
	vertical-align: top;
}
.otherday{
	color:black;
	text-align: left;
	vertical-align: top;
}
.days2{
	font-size:20px;
	color:#4d6bb3;
	text-align: center;
	vertical-align: middle;
}
.days3{
	font-size:20px;
	color:#4d6bb3;
	text-align: center;
	vertical-align: middle;
	background-color: #4d6bb3;
	color:#ffffff;
	line-height: 1.7em;
	font-weight: normal;
}
.innerTable{
	border: 0px;
}
</style>

<%!
public String callist(int year, int month, int day){
	String s="";	
	s+=String.format("<a href='%s?year=%d&month=%d&day=%d'>", 
					"callist.do", year, month, day);
	s+=String.format("%2d", day);
	s+="</a>";
	return s;	
}
public String showpen(int year, int month, int day){
	String s="";
	String url="calwrite.do";
	String image="<img src='image/pen.gif'/>";
	s=String.format("<a href='%s?year=%d&month=%d&day=%d'>%s</a>"
					, url, year, month, day, image);
	return s;	
}
// 1 3 -> 01 03  
public String two(String msg){
	return msg.trim().length() < 2 ? "0"+msg : msg.trim();
}
//제목이 15자 이상이면, ...로 표시하기 위한 함수
public String dot3(String msg){
	String s="";
	if(msg.length() >= 15){
		s = msg.substring(0, 15);
		s += "...";
	}else{
		s = msg.trim();
	}
	return s;
}
public String makeTable(int year, int month, int day, List<SistCalendar> lcdtos){
	String s="";
	String dates=(year+"")+two(month+"")+two(day+"");
	s="<table>";
	s+="<col width='100px'/>";	
		
	for(SistCalendar lcd:lcdtos){			
		if(lcd.getWdate().substring(0, 8).equals(dates)){
			s += "<tr bgcolor='pink'>";
			s += "<td>";
			s += "<a href='caldetail.do?seq="+lcd.getSeq()+"'>";
			s += "<font style='font-size:8px; color:#090000'>";
			s += dot3(lcd.getTitle());
			s += "</font>";
			s += "</a>";
			s += "</td>";
			s += "</tr>";			
		}
	}
	s += "</table>";
	return s;
}
%>

<%
List<SistCalendar> list=new ArrayList<SistCalendar>();
Object Oflist = request.getAttribute("flist");
if(Oflist != null){
	list = (List<SistCalendar>)Oflist;
}

myCal jcal = (myCal)request.getAttribute("jcal");

int dayOfWeek = jcal.getDayOfweek();
int lastDayOfMonth = jcal.getLastDay();

int year = jcal.getYear();
int month = jcal.getMonth();

String pp=String.format("<a href='./%s?year=%d&month=%d'><img src='image/left.gif'/></a>", 
			"calendar.do", year-1, month);

String p=String.format("<a href='./%s?year=%d&month=%d'><img src='image/prec.gif'/></a>", 
		"calendar.do", year, month-1);

String nn=String.format("<a href='./%s?year=%d&month=%d'><img src='image/last.gif'/></a>", 
		"calendar.do", year+1, month);

String n=String.format("<a href='./%s?year=%d&month=%d'><img src='image/next.gif'/></a>", 
		"calendar.do", year, month+1);

String url = String.format("%s?year=%s&month=%s", 
					"calendar3.do", year, month);
%>

<div style="text-align: left">
	<a href='<%=url %>'>
		<%=year+"년"+month+"월" %>일정보기
	</a>
</div>

<div class="box_border" style="margin-top: 5px; margin-bottom: 10px;">
<table style="width:85%;">
	<col width="100px"/>
	<col width="100px"/>
	<col width="100px"/>
	<col width="100px"/>
	<col width="100px"/>
	<col width="100px"/>
	<col width="100px"/>
	
<thead>
<tr height="100px">
	<td colspan="7" class="days2">
		<%=pp %><%=p %>	
		<font color="red" style="font-size:20">
			<%=String.format("%d년&nbsp;&nbsp;%d월", year, month) %>
		</font>
		<%=n %><%=nn %>
	</td>
</tr>

<tr height="100px">
	<th class="days3">일</th>
	<th class="days3">월</th>
	<th class="days3">화</th>
	<th class="days3">수</th>
	<th class="days3">목</th>
	<th class="days3">금</th>
	<th class="days3">토</th>
</tr>
</thead>	

<tr height="100px">
<%
for(int i = 1;i < dayOfWeek; i++){
	%>
	<td>&nbsp;</td>
	<%	
}

for(int i=1;i <= lastDayOfMonth; i++){
	String hhh=String.format(
			"<a href='%s?year=%d&month=%d&day=%d'>"+
			"<img src='image/pen.gif' alt='write'/></a>",
				"calwrite.do", year, month, i);
	
	if((i+dayOfWeek-1)%7==0){		// 토요일일 경우
		%>
		<td class="satday">
			<%=callist(year, month, i)%>&nbsp;<%=showpen(year, month, i) %>
			<%=makeTable(year, month, i, list) %>
		</td>
		<% 
	}else if((i+dayOfWeek-1)%7==1){	// 일요일일 경우
		%>
		<td class="sunday">
			<%=callist(year, month, i)%>&nbsp;<%=showpen(year, month, i) %>
			<%=makeTable(year, month, i, list) %>
		</td>
		<%
	}else{							// 나머지 요일의 경우
		%>
		<td class="otherday">
			<%=callist(year, month, i)%>&nbsp;<%=showpen(year, month, i) %>
			<%=makeTable(year, month, i, list) %>
		</td>
		<%
	}	
	if((i+dayOfWeek-1)%7 == 0){
		%>
		</tr><tr height="100px">
		<%
	}
}
for(int i = 0;i < (7-(dayOfWeek+lastDayOfMonth-1)%7)%7; i++){
	%>
	<td>&nbsp;</td>	
	<%
}
%>


</tr>







	
	
</table>
</div>






