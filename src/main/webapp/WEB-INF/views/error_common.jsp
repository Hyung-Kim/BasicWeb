<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<html>
	<h4>${exception.getMessage() }</h4>
	<ul>
		<c:forEach items="${exception.getStackTrace() }" var="stack">
			<li>${stack.toString() }</li>
		</c:forEach>
	</ul>
</html>