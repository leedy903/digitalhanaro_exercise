<%--
  Created by IntelliJ IDEA.
  User: campus2H038
  Date: 2024-11-26
  Time: 오후 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/board/modify" method="POST">
    게시글 번호: <input type="text" name="bno" value="${board.bno}"> <br/>
    제목: <input type="text" name="title" value="${board.title}"> <br/>
    내용: <input type="text" name="content" value="${board.content}"> <br/>
    작성자: <input type="text" name="writer" value="${board.writer}"> <br/>
    등록일: <input type="text" name="regDate" value="${board.regDate}"> <br/>
    조회수: <input type="text" name="hit" value="${board.hit}"> <br/>
    <input type="submit" value="수정하기">
</form>

</body>
</html>
