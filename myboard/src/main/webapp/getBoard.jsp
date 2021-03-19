<%@page import="tommy.spring.web.board.impl.BoardDAO"%>
<%@page import="tommy.spring.web.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	BoardVO board = (BoardVO)session.getAttribute("board");
    	
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글 상세</h1>
<a href="logout.do">Log Out</a><hr>
<form action="updateBoard.do" method="post">
<input type="hidden" name="seq" value="<%=board.getSeq() %>" />
<table border="1">
	<tr>
		<td>제목</td>
		<td><input name="title" type="text" value="<%=board.getTitle() %>" /></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><%=board.getWriter() %></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name="content"><%=board.getContent() %></textarea></td>
	</tr>
	<tr>
		<td>등록일</td>
		<td><%=board.getRegDate() %></td>
	</tr>
	<tr>
		<td>조회수</td>
		<td><%=board.getCnt() %></td>
	</tr>
	
		
</table>

</form><hr>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=<%=board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글목록</a>
</body>
</html>