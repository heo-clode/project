<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<script src ="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>

	var msg = "${msg}";
	
	if(msg != ""){
		window.alert(msg);
	}
	
	
	$(document).ready(function(){
		$("#closeBtn").click(function(){
			window.close();
		});
	});
	
</script>

<!-- Custom fonts for this template-->
<link href="resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="resources/css/sb-admin-2.min.css" rel="stylesheet">

<!-- idOverlapCheck -->
<div class="idCheckForm">
	<h3>아이디 중복 체크</h3><br>
	<form method="post" action="/idOverlapCheck">
		<div class="idCheck">
			<input id="mm_id" name="mm_id" type="text" required placeholder="아이디">
			<button class="btn btn-primary" type="submit">
				<i class="fas fa-search fa-sm"></i>
			</button>
		</div>
	</form>
	<div id="closeBtn">
		<button class = "closeBtn">닫기</button>
	</div>
</div>