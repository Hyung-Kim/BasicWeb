<script>
	var result = '${msg}';
	if(result=='SUCCESS'){
		alert("처리가 완료되었습니다.");
	}
</script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  <!-- JSTL 문법 사용 -->
<table class="table table-bordered">
	<tr>
		<th style="width : 10px">BNO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>REGDATE</th>
		<th style="width : 40px">VIEWCNT</th>
	</tr>
	
	<!-- JSTL을 사용해서 받아온 데이터를 출력해준다. 즉, BoardVO를 모두 출력-->
	<c:forEach items="${list}" var="boardVO">
		<tr>
			<td>${boardVO.bno }</td>
			<td><a href='/board/read?bno=${boardVO.bno}'>${boardVO.title}</a></td>
			<td>${boardVO.writer}</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}" /></td>
			<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
		</tr>
	</c:forEach>
</table>
<%@include file="../include/footer.jsp" %>