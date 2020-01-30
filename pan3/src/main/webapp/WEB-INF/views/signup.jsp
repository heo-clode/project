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
	$(document).ready(
		function() {
			$("#searchBtn").click(
				function() {
					var settings = 'toolbar=0, status=0, menubar=0, scrollbars=yes, height=400, width=550, top=270px, left=600px';
					var target = 'schoolSearchView';
					window.open(target,'schoolSearchView',settings);
		});
	});

	$(document).ready(
		function() {
			$("#idBtn").click(
				function() {
					var settings = 'toolbar=0, status=0, menubar=0, scrollbars=yes, height=300, width=450, top=270px, left=600px';
					var target = 'idOverlapCheckView';
					window.open(target,'idOverlapCheckView',settings);
		});
	});

	$(function() {
		$("#alert-success").hide();
		$("#alert-danger").hide();
		$("input").keyup(function() {
			var pwd1 = $("#mm_pw").val();
			var pwd2 = $("#mm_pwd").val();
			if (pwd1 != "" || pwd2 != "") {
				if (pwd1 == pwd2) {
					$("#alert-success").show();
					$("#alert-danger").hide();
					$("#submit").removeAttr("disabled");
				} else {
					$("#alert-success").hide();
					$("#alert-danger").show();
					$("#submit").attr("disabled", "disabled");
				}
			}
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

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<div class="signup">
							<div>
								<div class="login">
									<div class="login_header">
										<a class="login" id="login" href="/login">로그인</a> <a
											class="signup" id="signup" href="/signup">회원가입</a>
									</div>
									<br>
								</div>
								<div class="ss">
									<form method="post" action="/signupTRY" style="width: 370px;">
										<input class="form-control" id="mm_sccode" name="mm_sccode"
											type="text" required placeholder="학교코드 입력" style="width: 345px;">
										<a class="searchBtn" id="searchBtn">검색</a>
										<br><br>
										<input class="form-control" id="mm_id" name="mm_id" type="text"required placeholder="아이디" style="width: 345px;">
										<a class="idBtn" id="idBtn">아이디 중복 검사</a>
										<br><br>
										<input class="form-control" id="mm_pw" name="mm_pw" type="password" required placeholder="비밀번호" style="width: 345px;"><br>
										<input class="form-control" id="mm_pwd" name="" type="password" required placeholder="비밀번호 확인" style="width: 345px;"><br>

										<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
										<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>

										<input class="form-control" id="mm_name" name="mm_name" type="text" required placeholder="이름" style="width: 345px;"><br>
										<input class="form-control2" id="mm_email" name="mm_email" type="text" required placeholder="email">
										@
										<input class="form-control2" id="mm_email2" name="mm_email2" type="text" required placeholder="email2">
										<br><br>
										<input class="form-control" id="mm_pnum" name="mm_pnum" type="tel" required placeholder="010-1234-5678" style="width: 345px;">
										<br>
										<div>
											<button type="submit" class="signupTRYBtn" style="width: 372px;">회원가입</button>
										</div>
									</form>
								</div>
							</div>
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

	<%@ include file="boot/plugin_js.jsp"%>

</body>

</html>
