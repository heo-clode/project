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
	
	
$(function() {
	$("#alert-success").hide();
	$("#delete").click(function() {
		$("#alert-success").show();
		$("#delete").hide();
		
		 $("#alert-success").removeAttr("display");	//지우기
        $("#delete").attr("disabled", "disabled");	//추가
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


<div class="idCheckForm">
	<h3>정말로 삭제하시겠습니까?</h3><br>
	<form method="post" action="/myPageDelete">
	
	<div class="alert alert-success" id="alert-success">탈퇴되었습니다.</div>
	
	<div>
			<button class="myPageCloseBtn" id="delete" type="submit">확인</button>
			<button class = "myPageCloseBtn" id="closeBtn" >닫기</button>
	</div>
	</form>
			
	
</div>



