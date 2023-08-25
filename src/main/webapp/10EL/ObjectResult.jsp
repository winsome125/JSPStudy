<%@page import="common.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어(EL) - 객체 매개변수</title>
</head>
<body>
	<h2>영역을 통해 전달된 객체 읽기</h2>
	<ul>
		<!-- 
		 영역에 저장된 속성에 EL로 접근할때는 속성명이 중복되지 않는다면 EL내장객체없이 속성명 만으로 출력할 수 있다.
		 즉 requestScope.personObj.name 형태로 기술하지 않아도 된다.
		 
		 "속성명.멤버변수" 형태로 기술하면 객체에 선언된 getter()를 자동으로 호출하여 값을 출력한다.
		 즉 아래 문장은 getter()를 호출하므로 Person클래스에서 getName()을 주석처리하면 에러가 발생한다.
		 또한 출력시 형변환이 자동으로 되므로 더욱 편리하다.
		 -->
		<li>Person 객체 => 이름 :${ personObj.name }, 나이 : ${ personObj.age }</li>
		<li>String 객체 => ${ requestScope.stringObj }</li>
		<li>Integer 객체 => ${ integerObj }</li>
	</ul>
	
	<h2>JSP 내장객체를 통해 영역의 값 읽어오기</h2>
	<%
	 // 영역에는 모든 객체를 저장할 수 있는 공간이므로 Object형으로 저장된다.
	 Object object = request.getAttribute("personObj");
	 // 따라서 영역에서 객체를 꺼낸 후 사용시에는 원래의 타입으로 형변환해야한다.
	 Person person = (Person) object;
	 // 출력시에는 멤버변수에 직접 접근할 수 없으므로 getter()를 사용한다.
	 out.println("이름:"+ person.getName());
	 // 이런 모든 절차를 EL은 자동으로 처리해준다.
	%>
	
	<!-- 
	 파라미터 전달된 값을 읽을때 아래 3가지 방법을 사용할 수 있다.
	 	param.파라미터명
	 	param.['파라미터명']
	 	param.["파라미터명"]
	 -->
	<h2>매개변수로 전달된 값 읽기</h2>
	<ul>
        <li>${ param.firstNum + param['secondNum'] }</li>  
        <li>${ param.firstNum } + ${param["secondNum"] }</li> 
	</ul>
</body>
</html>