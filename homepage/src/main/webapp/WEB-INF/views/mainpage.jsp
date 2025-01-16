<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/member/loginCheck">
		<div class="login_block">
			<table id="login_table">
				<tr>
					<th  class="login_input"
						bgcolor="lightgrey">아이디</th>
					<td bgcolor="white"><input type="text" name="id" required></td>
				</tr>
				<tr>
					<th class="login_input" bgcolor="lightgrey">비번</th>
					<td bgcolor="white"><input type="password" name="pass"
						required></td>
				</tr>
				<br>
			</table>
			<input type="submit" value="로그인"> <input type="button"
				onclick="location.href = 'mainPage.jsp?flag=regform'" value="회원가입">
			<input type="button"
				onclick="location.href = 'mainPage.jsp?flag=findMemberForm'"
				value="아이디찾기"> <input type="button"
				onclick="location.href = 'mainPage.jsp?flag=findPassForm'"
				value="비밀번호찾기">
		</div>
	</form>
</body>
</html>