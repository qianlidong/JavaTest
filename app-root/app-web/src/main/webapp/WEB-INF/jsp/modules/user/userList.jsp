<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<body>
	<h2>${message}</h2>
	<h2>Hello World!-- User</h2>
	<a href="${ctx}/user/userEdit">添加用户</a>
	<table>
	    <tr><td>ID</td><td>姓名</td><td>年龄</td><td>操作</td></tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
				<td><a href="${ctx}/user/getUserById?id=${user.id}">详情</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
