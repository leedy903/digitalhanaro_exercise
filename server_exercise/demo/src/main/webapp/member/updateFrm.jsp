<%--
  Created by IntelliJ IDEA.
  User: campus2H038
  Date: 2024-11-22
  Time: 오전 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/member/update.action" method="GET">
  아이디: <input type="text" name="userId" value="${member.userId}" disabled> <br />
  비밀번호: <input type="text" name="userPwd" value="${member.userPwd}"> <br />
  이름: <input type="text" name="userName" value="${member.userName}"> <br />
  이메일: <input type="text" name="email" value="${member.email}"> <br />
  <input type="submit" value="수정하기">
</form>
</body>
</html>
