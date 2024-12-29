<%--
  Created by IntelliJ IDEA.
  User: campus2H038
  Date: 2024-11-26
  Time: 오후 3:28
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
<table>
    <tr>
        <th>게시글 번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>
        <th>등록일</th>
        <th>조회수</th>
    </tr>
    <c:forEach items="${bList}" var="item">
        <tr>
            <td><a href="${pageContext.request.contextPath}/board/read?bno=${item.bno}">${item.bno}</a></td>
            <td>${item.title}</td>
            <td>${item.content}</td>
            <td>${item.writer}</td>
            <td><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
            <td>${item.hit}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
