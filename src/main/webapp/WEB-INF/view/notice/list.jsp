<%@page import="com.simple.board.web.entity.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
				<c:forEach var="notice" items="${list }">
				<div>
					<div class="num">${notice.id }</div>
					<div class="title">
						<a href="detail?id=${notice.id }">${notice.title }</a>
					</div>
					<div class="writer">${notice.writer_id }</div>
					<div class="date">${notice.regdate }</div>
					<div class="count">${notice.hit }</div>
				</div>
				</c:forEach>
			</div>
			<div class="board_page">
				<a href="#" class="bt fisrt"><<</a> 
				<a href="#" class="bt prev"><</a>
				<c:forEach var="i" begin="0" end="4">
				<a href="?p=${1+i }&t=&q=" class="num">${1+i }</a> 
				</c:forEach>
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