 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.oreilly.servlet.MultipartRequest,com.oreilly.servlet.multipart.DefaultFileRenamePolicy,java.util.*,java.io.*" %>
<%@ page import="java.sql.*" %>
<%
 request.setCharacterEncoding("euc-kr");
 String realFolder = "";
 String filename1 = "";
 int maxSize = 1024*1024*5;
 String encType = "euc-kr";
 ServletContext scontext = getServletContext();
 realFolder = "C:\\upload\\";
 
 try{
 	 MultipartRequest multi=new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
 	 Enumeration<?> files = multi.getFileNames();
     String file1 = (String)files.nextElement();
     filename1 = multi.getFilesystemName(file1);

 } catch(Exception e) {
  e.printStackTrace();
 }
 
 String fullpath = "http://localhost:8090/upload/"+ filename1;//////////////////////// ���
 System.out.println("fullpath"+fullpath);
 
 for(int i=0; i<8; i++){
	 if(session.getAttribute("fullpath"+i) == null){
		 session.setAttribute("fullpath"+i, fullpath);
		 break;
 	}
 }
 


%>
<title>Insert title here</title>
<script type="text/javascript">
window.opener.location.reload();
window.close();
</script>
</head>
<body>
</body>
</html>