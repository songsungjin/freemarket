<%@ page contentType="text/html; charset=UTF-8"%>

<div style="background-color: #008299;">
<h1>검색바, 판매하기 버튼 등</h1>

<ul class="navi">
	<c:if test="${login.auth eq '3' }">
		<li><a href="FreeSaleSellwrite.do" title="판매하기">판매합니다</a></li>
		<li><a href="FreeSaleBuywrite.do" title="구매하기">구매합니다</a></li>
	</c:if>
</ul>
</div>