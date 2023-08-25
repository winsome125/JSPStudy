<%@page import="utils.JSFunction"%>
<%@page import="model1.board.BoardDTO"%>
<%@page import="model1.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String title = request.getParameter("title");
String content = request.getParameter("content");

//DB연결을 위해 DAO객체를 생성한다.
BoardDTO dto = new BoardDTO();
//입력값이 저장된 DTO객체를 인수로 전달하여 insert쿼리문을 실행한다.
dto.setTitle(title);
dto.setContent(content);
dto.setId(session.getAttribute("UserId").toString());

BoardDAO dao = new BoardDAO(application);
int iResult = dao.insertWrite(dto);
dao.close();

if (iResult == 1) {
	response.sendRedirect("List.jsp");
}
else {
	JSFunction.alertBack("글쓰기에 실패하였습니다.", out);
}
%>