<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div class="board_write_wrap">
			<div class="board_write">
                <div class="title">
                    <dl>
                        <dt>제목</dt>
                        <dd><input type="text" placeholder="제목 입력"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt>글쓴이</dt>
                        <dd><input type="text" placeholder="글쓴이 입력"></dd>
                    </dl>
                    <dl>
                        <dt>비밀번호</dt>
                        <dd><input type="text" placeholder="비밃번호 입력"></dd>
                    </dl>
                </div>
                <div class="cont">
                    <textarea placeholder="내용 입력"></textarea>
                </div>
			</div>
			<div class="bt_wrap">
				<a href="list.html" class="on">登録</a>
                <a href="list.html">취소</a>
			</div>
		</div>
	</div>
</body>
</html>