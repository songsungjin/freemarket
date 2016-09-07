<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<fmt:requestEncoding value="utf-8"/>

<c:if test="${(empty login) or (login.id eq '')}">
<%
session.invalidate();
%>
<script>
alert("로그인 해 주십시오.");	
self.location.href="login.do";
</script>

</c:if>


