<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<%@ include file="../boot/head.jsp"%>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<%@ include file="../boot/left_column.jsp"%>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<%@ include file="../boot/topbar.jsp"%>

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div class="d-sm-flex align-items-center justify-content-between mb-4">
						<form method="post" action="/writeTRY" class="form-group">
							<div>
								<input class="form-control" type="text" name="bp_name" placeholder="제목" />
							</div>
							
							<br>

							<div>
								<textarea class="form-control" rows="10" cols="60" name="bp_content" placeholder="내용"></textarea>
							</div>
							<br>
							<div>
								<button type="submit" name="content" class="btn btn-sm btn-primary">
								작성
								</button>
							</div>
						</form>
					</div>
					<!-- /.container-fluid -->

				</div>
				<!-- End of Main Content -->

				<%@ include file="../boot/main_footer.jsp"%>

			</div>
			<!-- End of Content Wrapper -->

		</div>
	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>
	
	<%@ include file="../boot/logoutModal.jsp"%>
	<%@ include file="../boot/plugin_js.jsp"%>

</body>

</html>
