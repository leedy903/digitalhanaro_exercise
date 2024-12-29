<%--
  Created by IntelliJ IDEA.
  User: campus2H038
  Date: 2024-11-21
  Time: 오전 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/book" method="POST">
    책 아이디: <input type="text" name="bookId"> <br />
    책 제목: <input type="text" name="bookName"> <br />
    출판사: <input type="text" name="publisher"> <br />
    가격: <input type="text" name="price"> <br />
    <input type="submit" value="제출">
</form>

</body>
</html>
