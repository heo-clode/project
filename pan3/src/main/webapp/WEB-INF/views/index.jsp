<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>


<!DOCTYPE html>
<html lang="en">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(function() {
		$("#searchBtn").click(function() {
			var data = "${sc_name}";
			$.ajax({
				url : '/schoolSearch',
				type : 'POST',
				data : {
					"sc_name" : sc_name
				},
				success : function(data) {
					$('category').attr(data);
				},
				error : function(e) {
					alert('정보를 다시 입력해주시길 바랍니다.');
				}
			});
		});
	});
</script>

<%@ include file="boot/head.jsp"%>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<%@ include file="boot/left_column.jsp"%>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<%@ include file="boot/topbar.jsp"%>

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<%@ include file="boot/main_header.jsp"%>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<%@ include file="boot/main_footer.jsp"%>

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<%@ include file="boot/logoutModal.jsp"%>
	<%@ include file="boot/plugin_js.jsp"%>

</body>

</html>
