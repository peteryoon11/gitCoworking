<%@page import="com.entity.BoardDTO"%>
<%@page import="java.util.List"%>
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
    List<BoardDTO> list =
      (List<BoardDTO>)request.getAttribute("boardList");
%>
<h1>게시판</h1>
<table border="1">
  <tr>
    <th>글번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>작성일</th>
    <th>조회수</th>
  </tr>
<%  
    for(BoardDTO dto: list){
      int num= dto.getNum();
      String title = dto.getTitle();
      String author = dto.getAuthor();
      String writeday = dto.getWriteday();
      int readcnt = dto.getReadcnt();
    		  
%>

  <tr>
    <td><%= num %></td>
    <td><a href="BoardRetrieveServlet?num=<%= num %>"><%= title%></a></td>
    <td><%=author%></td>
    <td><%= writeday%></td>
    <td><%= readcnt%></td>
  </tr>
<%
    }//end for
%>  
</table>
<a href="BoardWriteUIServlet">글쓰기화면</a>
</body>
</html>







