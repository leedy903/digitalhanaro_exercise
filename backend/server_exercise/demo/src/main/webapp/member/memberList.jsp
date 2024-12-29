<%--
  Created by IntelliJ IDEA.
  User: campus2H038
  Date: 2024-11-21
  Time: 오후 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>모든 멤버 정보 보기</h2>
<table>
  <tr><th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일</th></tr>
  <c:forEach items="${mList}" var="item">
    <tr>
      <td><a href="${pageContext.request.contextPath}/read.action?userId=${item.userId}">${item.userId}</a></td>
      <td>${item.userPwd}</td>
      <td>${item.userName}</td>
      <td>${item.email}</td>
      <td>${item.regDate}</td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
