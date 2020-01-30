<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="en">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(
		function() {
			$("#idBtn").click(
				function() {
					var settings = 'toolbar=0, status=0, menubar=0, scrollbars=yes, height=300, width=450, top=270px, left=600px';
					var target = 'myPageDeleteView';
					window.open(target,'myPageDeleteView',settings);
		});
	});
</script>

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
							<div class="myPage_header" style="margin-left: 16px;">
								<a type="submit" class="myPage" id="myPage" href="myPage">회원정보</a>
								<a type="submit" class="myPage" id="myPage"
									href="writeBoardMyPage">작성글보기</a> <a type="submit"
									class="myPage" id="myPage" href="writeReplyMyPage">작성댓글보기</a>
							</div>

							<div class="myPage_body">
								<form method="post" action="/myPageUpdate">

									<table>
										<c:forEach var="mm" items="${List }">
											<tr>
												<td>아이디</td>
												<td>${mm.mm_id }</td>
											</tr>
											<tr>
												<td>이름</td>
												<td>${mm.mm_name }</td>
											</tr>
											<tr>
												<td>전화번호</td>
												<td>${mm.mm_pnum }</td>
											</tr>
											<tr>
												<td>이메일</td>
												<td>${mm.mm_email}</td>
											</tr>
											<tr>
												<td>가입일</td>
												<td><fmt:formatDate value="${mm.mm_date }"
																	pattern="yyyy.MM.dd-hh:mm:ss" /></td>
											</tr>
										</c:forEach>
									</table>

									<button type="submit" class="myPageBtn" id="myPageBtn"
										style="font-size: 15px;">정보수정</button>
									<a class="idBtn" id="idBtn">회원탈퇴</a>
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
