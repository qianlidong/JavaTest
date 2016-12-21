<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<body>
		<table>
		    <tr>
				<td>ID:</td>
				<td>${user.id}</td>
			</tr>
			<tr>
				<td>Name:</td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td>age:</td>
				<td>${user.age}</td>
			</tr>
			<tr>
				<td colspan="2"><a href="${ctx}/user/userList">返回</a></td>
			</tr>
		</table>
</body>