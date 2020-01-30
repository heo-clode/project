<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	var msg = "${msg}";

	if (msg != "") {
		window.alert(msg);
	}

	$(document).ready(function() {
		$("#closeBtn").click(function() {
			window.close();
		});
	});

	$(document).ready(function() {
		$(".scBtn").click(function() {
			var data = "${sc_name}";
			$.ajax({
				url : '/scSearch',
				type : 'POST',
				data : {
					"sc_name" : sc_name
				},
				success : function(data) {
					$('sc').attr(data);
					
				},
				error : function(e) {
					alert('정보를 다시 입력해주시길 바랍니다.');
				}
			});
		});
	});
</script>

<!-- Custom fonts for this template-->
<link href="resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="resources/css/sb-admin-2.min.css" rel="stylesheet">

<!-- idOverlapCheck -->
<div class="idCheckForm">
	<h3>학교 검색</h3>
	<br>
	<form method="post" action="/scSearch">
		<div class="idCheck">
			<input id="sc_name" name="sc_name" type="text" required
				placeholder="학교">
			<button class="btn btn-primary" id="scBtn" type="submit">
				<i class="fas fa-search fa-sm" id="scBtn"></i>
			</button>
		</div>
		<br>

		<div id="sc">
			<table class="table table-striped table-sm">
				<thead>
					<tr>
						<th>학교코드</th>
						<th>학교이름</th>
					</tr>
				</thead>

				<tbody>
					<c:choose>
						<c:when test="${empty sc}">
							<tr>
								<td colspan="2" align="center">데이터가 없습니다.</td>
							</tr>
						</c:when>

						<c:when test="${!empty sc}">
							<c:forEach var="sc" items="${sc}">
								<tr>
									<td><c:out value="${sc.sc_code}" /></td>
									<td><c:out value="${sc.sc_name}" /></td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
		</div>
	</form>
	
	
	<div id="closeBtn">
		<button class="closeBtn2">닫기</button>
	</div>
</div>