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
		<div class="board_write_wrap">
			<form method="post" action="reg">
				<div class="board_write">
					<div class="title">
						<dl>
							<dt>題目</dt>
							<dd>
								<input type="text" name="title" placeholder="題目入力">
							</dd>
						</dl>
					</div>
					<div class="info">
						<dl>
							<dt>作成者</dt>
							<dd>
								<input type="text" name="writer_id" placeholder="作成者入力">
							</dd>
						</dl>
						<dl>
							<dt>パスワード</dt>
							<dd>
								<input type="text" placeholder="パスワード入力">
							</dd>
						</dl>
					</div>
					<div class="cont">
						<textarea name="content" placeholder="内容入力"></textarea>
					</div>
				</div>
				<div class="bt_wrap">
					<input href="/notice/list" class="on" type="submit" value="登録"/> 
					<a href="/notice/list">キャンセル</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>