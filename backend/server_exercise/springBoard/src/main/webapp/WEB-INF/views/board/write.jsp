<%--
  Created by IntelliJ IDEA.
  User: campus2H038
  Date: 2024-11-26
  Time: 오후 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/board/write" method="POST">
    제목: <input type="text" name="title"> <br/>
    내용: <input type="text" name="content"> <br/>
    작성자: <input type="text" name="writer"> <br/>
    <input type="submit" value="작성하기">
</form>
</body>
</html>
