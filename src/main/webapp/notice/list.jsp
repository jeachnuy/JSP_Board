<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String url = "jdbc:mysql://localhost:3306/devdb";
String sql = "select * from NOTICE";

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(url, "devuser", "devpass");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(sql);
%>    

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Notice</title>
	<link rel="stylesheet" href="../css/customer/layout.css">
</head>
<body>
	<div class="board_wrap">
		<div class="board_title">
			<strong>お知らせ</strong>
			<p>お知らせを迅速かつ正確にご案内いたします。</p>
		</div>
		<div class="board_list_wrap">
			<div class="board_list">
				<div class="top">
					<div class="num">番号</div>
					<div class="title">題目</div>
					<div class="writer">作成者</div>
					<div class="date">作成日</div>
					<div class="count">照会</div>
				</div>
				<%while(rs.next()) {%>
				<div>
					<div class="num"><%=rs.getInt("ID") %></div>
					<div class="title"><a href="detail.jsp?id=<%=rs.getInt("ID") %>"><%=rs.getString("TITLE") %></a></div>
					<div class="writer"><%=rs.getString("WRITER_ID") %></div>
					<div class="date"><%=rs.getDate("REGDATE") %></div>
					<div class="count"><%=rs.getInt("HIT") %></div>
				</div>
				<%}%>
			</div>
			<div class="board_page">
				<a href="#" class="bt fisrt"><<</a>
				<a href="#" class="bt prev"><</a>
				<a href="#" class="num on">1</a>
				<a href="#" class="num">2</a>
				<a href="#" class="num">3</a>
				<a href="#" class="num">4</a>
				<a href="#" class="num">5</a>
				<a href="#" class="bt next">></a>
				<a href="#" class="bt last">>></a>
			</div>
			<div class="bt_wrap">
				<a href="write.html" class="on">登録</a>
			</div>
		</div>
	</div>
</body>
</html>
<%
rs.close();
st.close();
con.close();
%>