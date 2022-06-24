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
		<div class="board_search">
			<form>
				<select name="f">
					<option ${(param.f=="title")?"selected":"" } value="title">題目</option>
					<option ${(param.f=="writer_id")?"selected":"" } value="writer_id">作成者</option>
				</select>
				<input type="text" name="q" value="${param.q }"/>
				<input class="btn-search" type="submit" value="検索" />
			</form>
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
				<c:forEach var="notice" items="${list }" begin="0" end="9">
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
			<c:set var="page" value="${(param.p == null)?1:param.p }" />
			<c:set var="startNum" value="${page-(page-1)%5 }" />
			<c:set var="LastNum" value="23" />
				<a href="#" class="bt fisrt"><<</a> 
				<c:if test="${startNum>1 }">
					<a href="?p=${startNum-1 }&t=&q=" class="bt prev"><</a>
				</c:if>
				<c:if test="${startNum<=1 }">
					<a class="bt prev" onclick="alert('前のページがありません。')"><</a>
				</c:if>
				<c:forEach var="i" begin="0" end="4">
				<a href="?p=${startNum+i }&f=${param.f }&q=${param.q }" class="num">${startNum+i }</a> 
				</c:forEach>
				<c:if test="${startNum+5<LastNum }">
					<a href="?p=${startNum+5 }&t=&q=" class="bt next">></a> 
				</c:if>
				<c:if test="${startNum+5>=LastNum  }">
					<a class="bt next" onclick="alert('次のページがありません。')">></a> 
				</c:if>
				<a href="#" class="bt last">>></a>
			</div>
			<div class="bt_wrap">
				<a href="write.html" class="on">登録</a>
			</div>
		</div>
	</div>
</body>
</html>