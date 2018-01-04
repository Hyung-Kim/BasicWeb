<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!--  form 태그가 전체를 감싼 이유 : 수정 작업에 필요한 모든 데이터를 <form>태그로 묶어서 전송해야 하기 때문이다. -->
<form role="form" method="post">  
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">BNO</label>
			<input type="text" name='bno' class="form-control" value="${boardVO.bno }" readonly ="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text" name='title' class="form-control" value="${boardVO.title }">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea class="form-control" name='content' rows="3">${boardVO.content }</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text" name='writer' class="form-control" value="${boardVO.writer }" readonly="readonly">
		</div>
	</div>
</form>
<div class="box-footer">
	<button type="submit" class="btn btn-primary">SAVE</button>
	<button type="submit" class="btn btn-warning">CANCEL</button>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		var formObj = $("form[role='form']");		
		console.log(formObj);
		
		$(".btn-warning").on("click", function(){
			self.location="/board/listAll";
		});
		$(".btn-primary").on("click",function(){
			formObj.submit();
		});
	});
</script>
<%@include file="../include/footer.jsp" %>