<%--
  Created by IntelliJ IDEA.
  User: campus2H038
  Date: 2024-11-21
  Time: 오후 4:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>회원 가입 정보</h2>
<form action="${pageContext.request.contextPath}/member/join.action" method="GET">
  아이디: <input type="text" name="userId"> <br />
  비밀번호: <input type="text" name="userPwd"> <br />
  이름: <input type="text" name="userName"> <br />
  이메일: <input type="text" name="email"> <br />
  <input type="submit" value="가입하기">
</form>
</body>
</html>
