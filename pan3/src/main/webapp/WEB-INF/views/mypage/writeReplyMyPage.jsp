<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="en">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


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
						<div class="myPage">
							<div class="myPage_header">
								<a type="submit" class="myPage" id="myPage" href="myPage">회원정보</a>
								<a type="submit" class="myPage" id="myPage"
									href="writeBoardMyPage">작성글보기</a> <a type="submit"
									class="myPage" id="myPage" href="writeReplyMyPage">작성댓글보기</a>
							</div>

							<div class="myPage_body">
								<form method="post" action="/">

									<table>
										<tr>
											<th class="no">NO.</th>
											<th class="name">게시글</th>
											<th>제목</th>
											<th class="content">내용</th>
										</tr>

										<c:forEach var="b" items="${bList }" varStatus="status">

											<tr>
												<td class="no">${status.count}</td>
												<td class="name">${b.bo_name }</td>
												<td>${b.bp_name }</td>
												<td class="content">${b.re_content }</td>
											</tr>

										</c:forEach>
									</table>
								</form>
							</div>


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


	<%@ include file="../boot/plugin_js.jsp"%>
	<%@ include file="../boot/logoutModal.jsp"%>

</body>

</html>
