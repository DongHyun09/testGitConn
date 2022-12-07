<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import="dto.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<header>
<h2>일렉기타 정보</h2>
</header>
<section>
<% ArrayList<Purchase> pur = (ArrayList)request.getAttribute("PUR");
//		DBExpert dao = new DBExpert();
//		ArrayList<Purchase> purinfo = dao.getEleList();
//		request.setAttribute("PUR", purinfo);
//		RequestDispatcher rd = 
//				request.getRequestDispatcher("guitarList.jsp");
//		rd.forward(request, response);
//servlet
%>
<table border="1">
<tr><th>번호</th><th>모델명</th><th>픽업</th><th>지판</th>
<th>가격</th><th>판매처</th><th>판매자 번호</th></tr>

<% for( Purchase putin : pur){ 
//향상된 for문, pur -> putin %>
<tr><td><a href=""><%= putin.getEle_num() %></a></td>
	<td><%= putin.getModel() %></td>
	<td><%= putin.getPickup() %></td>
	<td><%= putin.getNeck() %></td>
	<td><%= putin.getPrice() %></td>
	<td><%= putin.getMad_name() %></td>
	<td><%= putin.getSell_numb() %></td></tr>
<% } %>
</table><br/><br/>
<input type="button" value="등록" onClick="goPut()"/>
<script type="text/javascript">
function goPut(){
	location.href="putguitar.do"
}
</script>
</section>
<footer><h2>CopyRight 2022 KDH_PRJ All Right Reserved</h2></footer>
</div>
</body>
</html>