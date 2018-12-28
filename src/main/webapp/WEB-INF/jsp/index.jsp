<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<h2>Hello World!</h2>
<a href="${ctx}/toHome">欢迎页1</a>
<a href="${ctx}/input/celcome">欢迎页2</a>
<a href="${ctx}/input/book/addBook">新增书本</a>
<a href="${ctx}/input/book/bookList">查询书本信息</a>
</body>
</html>
