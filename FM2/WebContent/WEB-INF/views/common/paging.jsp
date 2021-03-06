<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int totalRecordCount;	// 전체 글수 	List.size()		16개라고 가정하면
	int pageNumber;			// 페이지 번호	0~1~2			0, 1
	int pageCountPerScreen;	// 화면에 보일 페이지 번호 			10
	int recordCountPerPage;	// 페이지의 글수     여기서는 10로 잡겠다	10
	int totalPageCount;		// 모든 페이지수					2	
	int screenStartPageIndex;	// 화면의 글의 시작 번호			0
	int screenEndPageIndex;	// 화면의 글의 끝 번호				2
	
	String st1 = request.getParameter("totalRecordCount");
	if(st1 == null) totalRecordCount = 0;
	else			totalRecordCount = Integer.parseInt(st1);
	
	String st2 = request.getParameter("pageNumber");
	if(st2 == null) pageNumber = 0;
	else			pageNumber = Integer.parseInt(st2);
	
	String st3 = request.getParameter("pageCountPerScreen");
	if(st3 == null) pageCountPerScreen = 0;
	else			pageCountPerScreen = Integer.parseInt(st3);
	
	String st4 = request.getParameter("recordCountPerPage");
	if(st4 == null) recordCountPerPage = 0;
	else			recordCountPerPage = Integer.parseInt(st4);
	
	// 총 페이지 수를 구한다
	totalPageCount = totalRecordCount / recordCountPerPage;	
	// 남은 글수를 구한다
	if((totalRecordCount % recordCountPerPage) != 0){
		totalPageCount++;
	}
	
		
	screenStartPageIndex = ((pageNumber+1)/pageCountPerScreen) * pageCountPerScreen;	
	screenEndPageIndex = (((pageNumber+1)/pageCountPerScreen) * pageCountPerScreen) + pageCountPerScreen;
								
	
	if(screenEndPageIndex > totalPageCount)
		screenEndPageIndex = totalPageCount;
	
	// 33 		screenStartPageIndex = 0	screenEndPageIndex=4
	if(((pageNumber+1) % pageCountPerScreen) == 0){		
		screenStartPageIndex = (((pageNumber+1)/pageCountPerScreen)*pageCountPerScreen)
							-pageCountPerScreen;
		screenEndPageIndex = pageNumber+1;		
	}	
	
	System.out.println("totalRecordCount:" + totalRecordCount);
	System.out.println("pageNumber:" + pageNumber);
	System.out.println("pageCountPerScreen:" + pageCountPerScreen);
	System.out.println("recordCountPerPage:" + recordCountPerPage);
	System.out.println("totalPageCount:" + totalPageCount);
	System.out.println("screenStartPageIndex:" + screenStartPageIndex);
	System.out.println("screenEndPageIndex:" + screenEndPageIndex);
	
	

%>



<div style="float:left; width:96%; text-align:center;">
	<a href="#none" title="처음페이지" onclick="goPage(0);">
		<img src="image/arrow_first.gif" alt="처음페이지"
			style="width:9px; height:9px; "/>
	</a>&nbsp;
	<%
	if(screenStartPageIndex > 1){	
	%>
		<a href="#none" title="이전페이지" onclick="goPage('<%=screenStartPageIndex-1 %>');">
			<img src="image/arrow_back.gif" alt="이전페이지"
			style="width:9px; height:9px; "/>
		</a>&nbsp;
	<%
	}
	
	for(int i=screenStartPageIndex; i< screenEndPageIndex; i++)
	{
		if(i==pageNumber){
	%>
			<span style="font-size: 9pt; color:#000000; font-weight: bold;">
				<%=i+1 %>
			</span>&nbsp;
	<%
		}else{	
	%>
			<a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>);" 
				style="font-size: 7.5pt; color:#000000; font-weight: normal;">
				<%=i+1 %>	
			</a>&nbsp;
	<%
		}
	}
	
	// 다음 페이지
	if(screenEndPageIndex < totalPageCount)
	{
	%>
		<a href="#none" title="다음페이지" onclick="goPage(<%=screenEndPageIndex %>);">
			<img src="image/arrow_next.gif" alt="다음페이지" style="width: 9px; height: 9px;"/>
		</a>&nbsp;
	<%
	}
	
	int end_page = 0;
	if(totalPageCount > 0)
	{
		end_page = totalPageCount - 1;
	}
	%>
	<a href="#none" title="마지막페이지" onclick="goPage(<%=end_page %>);">
		<img src="image/arrow_end.gif" alt="마지막페이지" style="width: 9px; height: 9px;"/>
	</a>	
</div>

<div style="float:left; width:4%; text-align: center; ">
	<span style="font-size: 1em; color:#000000;">
		<%=pageNumber+1 %>/<%=totalPageCount %>
	</span>
</div>


totalRecordCount:${totalRecordCount }:전체 글수 	<br>
pageNumber:${pageNumber }:페이지 번호		<br>
pageCountPerScreen:${pageCountPerScreen }:화면에 보일 페이지 번호<br>
recordCountPerPage:${recordCountPerPage }:페이지의 글수     여기서는 10로 잡겠다<br>
totalPageCount:${totalPageCount }:모든 페이지수<br>
screenStartPageIndex:${screenStartPageIndex }:화면의 글의 시작 번호<br>
screenEndPageIndex:${screenEndPageIndex }:화면의 글의 끝 번호<br>



