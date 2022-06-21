<%@page import="java.util.Date"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int id = Integer.parseInt(request.getParameter("id"));

String url = "jdbc:mysql://localhost:3306/devdb";
String sql = "select * from NOTICE where ID=?";

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(url, "devuser", "devpass");
PreparedStatement st = con.prepareStatement(sql);
st.setInt(1, id);

ResultSet rs = st.executeQuery();

rs.next();

String title = rs.getString("title");
String writer_id = rs.getString("writer_id");
Date regdate = rs.getDate("regdate");
int hit = rs.getInt("hit");
String content = rs.getString("content");

rs.close();
st.close();
con.close();
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
		<div class="board_view_wrap">
			<div class="board_view">
				<div class="title">
					<%=title %>
				</div>
				<div class="info">
					<dl>
						<dt>番号</dt>
						<dd><%=id %></dd>
					</dl>
					<dl>
						<dt>作成者</dt>
						<dd><%=writer_id %></dd>
					</dl>
					<dl>
						<dt>作成日</dt>
						<dd><%=regdate %></dd>
					</dl>
					<dl>
						<dt>照会</dt>
						<dd><%=hit %></dd>
					</dl>
				</div>
				<div class="cont">
					<%=content %>
				</div>
			</div>
			<div class="bt_wrap">
				<a href="list.jsp" class="on">リスト</a> <a href="#">修正</a>
			</div>
		</div>
	</div>
</body>
</html>