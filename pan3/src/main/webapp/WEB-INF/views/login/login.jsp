<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<div class="login">
							<div class="login_header">
								<a class="login" id="login" href="/login">로그인</a> <a
									class="signup" id="signup" href="/signup">회원가입</a>
							</div>

							<div class="login_body">
								<form method="post" action="/loginTRY">
									<input id="id" type="text" name="mm_id" required
										placeholder="아이디"> <br> <input id="password"
										type="password" name="mm_pw" required placeholder="비밀번호"
										title="비밀번호"> <br>
									<button type="submit" class="loginBtn" id="loginBtn">로그인</button>
								</form>

								<a type="submit" class="seaechId" href="/idPwSearch">ID/PW찾기</a>

								<br> <br>

								<!-- 네이버 로그인 창으로 이동 -->
								<div id="naver_id_login" style="text-align: center">
									<a href="${url}"> <img width="223"
										src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png" />
									</a> <br>

								</div>
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

	<%@ include file="../boot/logoutModal.jsp"%>
	<%@ include file="../boot/plugin_js.jsp"%>
</body>

</html>
