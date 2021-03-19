<%@page import="java.util.List"%>
<%@page import="tommy.spring.web.board.BoardVO"%>
<%@page import="tommy.spring.web.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<BoardVO> boardList = (List<BoardVO>) session.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 목록</h1>
	<h3>
		테스트 회원님 환영합니다.<a href="logoutProc.jsp">Log-Out</a>
	</h3>
	<!-- 검색 시작 -->
	<form action="getBoardList.do" method="post">
		<table border="1">
			<tr>
				<td><select name="searchCondition">
						<option value="TITLE">제목</option>
						<option value="CONTENT">내용</option>
				</select> <input type="text" name="searchKeyword" /> <input type="submit"
					value="검색" /></td>
			</tr>
		</table>
	</form>
	<br />
	<!-- 검색 종료 -->
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<%
		for (BoardVO board : boardList) {
		%>
		<tr>
			<td><%=board.getSeq()%></td>
			<td><a href="getBoard.do?seq=<%=board.getSeq()%>"><%=board.getTitle()%></a>
			</td>
			<td><%=board.getWriter()%></td>
			<td><%=board.getRegDate()%></td>
			<td><%=board.getCnt()%></td>
		</tr>
		<%} %>
	</table>
	<br />
	<a href="insertBoard.jsp">새글 작성</a>
</body>
</html>