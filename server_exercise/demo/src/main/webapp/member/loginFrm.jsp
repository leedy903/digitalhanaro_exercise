<%--
  Created by IntelliJ IDEA.
  User: campus2H038
  Date: 2024-11-22
  Time: 오전 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/member/login.action" method="GET">
    아이디: <input type="text" name="userId"> <br />
    비밀번호: <input type="text" name="userPwd"> <br />
    <input type="submit" value="로그인">
</form>
</body>
</html>
