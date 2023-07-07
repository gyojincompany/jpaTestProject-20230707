<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 명단</title>
</head>
<body>
	<h2>회원 리스트</h2>
	<hr>
	<c:forEach items="${memberlist}" var="member">
		회원번호 : ${member.mnum }<br>
		아이디 : ${member.mid }<br>
		회원이름 : ${member.mname }<br>
		회원나이 : ${member.mage }<br>
		<hr>
	</c:forEach>

</body>
</html>