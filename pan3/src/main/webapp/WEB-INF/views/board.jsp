<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="en">

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

					<!-- Page Heading -->
					<div class="d-sm-flex align-items-center justify-content-between mb-4">
						<div class="board">
							<table class="table table-hover" border="1px solid black"
								style="padding: 3px">
								<tr>
									<th>no</th>
									<th>title</th>
									<th>content</th>
									<th>writer</th>
									<th>date</th>
								</tr>
								<c:forEach var="list" items="${list}">
									<tr>
										<td>${list.bp_no}</td>
										<td>${list.bp_name}</td>
										<td>${list.bp_content}</td>
										<td>${list.bp_writer}</td>
										<td>${list.bp_date}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
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
