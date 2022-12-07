<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "dto.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<header>
<h2>일렉기타 등록</h2>
</header>
<section>
<form action="guitarreg.do" method="post">
<%
	ArrayList<Purchase> apu = (ArrayList)request.getAttribute("TS");
%>
<table border="1">
	<tr><td>번호</td><td><input type="text" name="ELENUM"></td></tr>
	<tr><td>모델</td><td><input type="text" name="MODEL"></td></tr>
	<tr><td>픽업</td><td><input type="text" name="PICK"></td></tr>
	<tr><td>지판</td><td><input type="text" name="NECK"></td></tr>
	<tr><td>가격</td><td><input type="text" name="PRICE"></td></tr>
	<tr><td>판매처</td>
	<td>
	<select name="MADNAME">
	<% for( Purchase r : apu ){ %>
		<option value="<%= r.getSell_numb()%>" selected="selected">
		<%= r.getMad_name() %>
		</option>
	<% } %>	
	</select></td></tr>
	<tr><td>판매자 번호</td>
	
	</tr>
</table>
<div align="center">
	<input type="submit" value="버튼">
</div>
</form>
</section>
<footer>
<h2>CopyRight 2022. KDH_GPJ All Right Reserved</h2>
</footer>
</div>
</body>
</html>