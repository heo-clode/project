<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

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
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<div>
							<form method="post" action="/updateTRY?bp_no=${view.bp_no}">
								<div>
									<input class="form-control" type="text" name="bp_name" value="${view.bp_name}"/>
									<input class="form-control" type="text" name="bp_writer" value="${view.bp_writer}"
										readonly="readonly" /> <input type="hidden" name="bp_writer"
										value="${view.bp_mmcode}" readonly="readonly" />
									<input class="form-control" type="text" name="bp_date"
										value="<fmt:formatDate value="${view.bp_date}" pattern="yyyy.MM.dd-hh:mm:ss" />"
										readonly="readonly" />
									<textarea class="form-control" rows="10" cols="60" name="bp_content"
										placeholder="내용">${view.bp_content}</textarea>
									<button type="submit" class="btn btn-sm btn-primary">수정</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<%@ include file="../boot/main_footer.jsp"%>

		</div>
		<!-- End of Content Wrapper -->

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