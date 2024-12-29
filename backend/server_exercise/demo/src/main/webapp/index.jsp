<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="/member/login.action">로그인</a>

<a href="hello-servlet">Hello Servlet</a>

<p>
  <strong>${msg}</strong>
  <a href="${pageContext.request.contextPath}/world.do">바로가기</a>
</p>

<form action="${pageContext.request.contextPath}/welcome.do" method="POST">
  <input type="submit" value="doPost 실행">
</form>

<h2>annotation으로 매핑 후 JSP에서 출력</h2>

<form action="${pageContext.request.contextPath}/form.do" method="POST">
  아이디: <input type="text" name="id"> <br />
  비밀번호: <input type="text" name="pwd"> <br />
  <input type="submit" value="전송">
</form>

<a href="world.do">Show World Page</a>
</body>
</html>