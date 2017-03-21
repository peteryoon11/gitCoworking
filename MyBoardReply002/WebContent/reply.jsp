<%@page import="com.entity.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BoardDTO dto = (BoardDTO) request.getAttribute("replyUI");
		int num = dto.getNum();
		String title = dto.getTitle();
		String author = dto.getAuthor();
		String content = dto.getContent();
		String writeday = dto.getWriteday();
		int readcnt = dto.getReadcnt();
		int reproot = dto.getReproot();
		int repstep = dto.getRepstep();
		int repindent = dto.getRepindent();
	%>
	<form action="BoardReplyServlet" method="post">
	<input type="hidden" name=num value=<%=num %>>
	<input type="hidden" name=reproot value=<%=reproot %>>
	<input type="hidden" name=repstep value=<%=repstep %>>
	<input type="hidden" name=repindent value=<%=repindent %>>
	
		원 글번호:<%=num%>&nbsp; 작성일:<%=writeday%>&nbsp; 조회수:<%=readcnt%>&nbsp;<br>
		제목<input type="text" name="title" value="<%=title%>"><br>
		작성자<input type="text" name="author" value="<%=author%>"><br>
		내용
		<textarea rows="10" cols="10" name="content"><%=content%></textarea>
		<input type="submit" value="답변글 달기">
	</form>
	<a href="BoardListServlet">목록 보기</a>
</body>
</html>



