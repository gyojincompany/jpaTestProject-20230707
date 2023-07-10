<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 찾기</title>
</head>
<body>
	<h2>회원 이름으로 찾기</h2>
	<hr>
	<form action="searchOk">
		<input type="text" name="searchName">
		<input type="submit" value="이름검색1" >		
	</form>
	<form action="searchOkNew">
		<input type="text" name="mname">
		<input type="submit" value="이름검색2" >		
	</form>
</body>
</html>