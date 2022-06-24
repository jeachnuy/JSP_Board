<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Notice</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/customer/layout.css">
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
					${notice.title }
				</div>
				<div class="info">
					<dl>
						<dt>番号</dt>
						<dd>${notice.id }</dd>
					</dl>
					<dl>
						<dt>作成者</dt>
						<dd>${notice.writer_id }</dd>
					</dl>
					<dl>
						<dt>作成日</dt>
						<dd>${notice.regdate }</dd>
					</dl>
					<dl>
						<dt>照会</dt>
						<dd>${notice.hit }</dd>
					</dl>
				</div>
				<div class="cont">
					${notice.content }
				</div>
			</div>
			<div class="bt_wrap">
				<a href="/notice/list" class="on">リスト</a> <a href="#">修正</a>
			</div>
		</div>
	</div>
</body>
</html>