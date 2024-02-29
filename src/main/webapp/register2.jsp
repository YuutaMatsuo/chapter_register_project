<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
	<h2>入力情報を確認して登録ボタンを押してください</h2>
	名前：
	<strong><%= request.getParameter("pass") %></strong><br>
	 パスワード：
	<strong><%= request.getParameter("pass") %></strong><br>
	<% String age = request.getParameter("age"); %>
	<% if(age.equals("child")){
			age = "18歳未満";
		} else {
			age = "18歳以上";
		}
	%>
	年齢：
	<strong><%= age %></strong>
	<br> 開発経験：
	<strong> <%
		String[] langs = request.getParameterValues("lang");
		for(String lang : langs){
			out.println(lang + " ");
		}
	%>
	</strong>
	<br> 住所：
	<strong><%= request.getParameter("address") %></strong>
	<br> ご意見お問い合わせ：
	<strong><br><%= request.getParameter("msg") %></strong>
	<br>
	(この画面はSPで出力しています)<br>
	<input type="submit" value="登録">
</body>
</html>