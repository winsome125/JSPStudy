<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시어 - errorPage, isErrorpage 속성</title>
</head>
<body>
<%
/*
해당 파일을 처음 실행했을때는 피라미터가 없는 상태이므로 NumberFormatException이 발생된다.
실행 후 주소창에 파일명 뒤에 ?age=20 rhk rkxdl rltnfgkaus dpdhlsms tkfkwlsek.
*/
int myAge = Integer.parseInt(request.getParameter("age")) + 10;
out.println("10년 후 당신의 나이는 " + myAge + "입니다.");
%>
</body>
</html>