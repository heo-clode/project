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
							<form method="post">
								<div>
									<input class="form-control" type="hidden" name="bp_name" />
									<h6>${view.bp_name}</h6>
								</div>
								<hr style="width: 750px; margin-left: 0px;">
								<div>
									<input class="form-control" type="hidden" name="bp_writer" />
									<h6>${view.bp_writer}</h6>
									<input type="hidden" name="bp_mmcode" value="${view.bp_mmcode}" />
								</div>

								<div>
									<input class="form-control" type="hidden" name="bp_date" />
									<h6>
										<fmt:formatDate value="${view.bp_date}"
											pattern="yyyy.MM.dd-hh:mm:ss" />
									</h6>
								</div>

								<div>
									<textarea class="form-control" rows="10" cols="60"
										name="bp_content" readonly="readonly"
										style="margin: 0px 128.766px 0px 0px; height: 351px; width: 686px;">${view.bp_content}</textarea>
								</div>
								<div style="font-size: 14px;margin-top: 10px;width: 690px;">
									<c:if test="${view.bp_mmcode == mm_code}">
										<a href="/update?bp_no=${view.bp_no}">수정</a>
										<a href="/delete?bp_no=${view.bp_no}">삭제</a>
									</c:if>
									<a href="/list?bo_num=${bo_num}">목록보기</a>
									<a class="heart" style="float: right;">
										<img id="heart" src="" style="width: 20px;">
									</a>
								</div>
							</form>
							<br />
							<!--  댓글  -->
							<div class="reply">
								<label for="reply">댓글</label>
								<form name="commentInsertForm">
									<div class="input-group">
										<input type="text" class="form-control" id="re_content"
											name="re_content" placeholder="내용을 입력하세요."> <span
											class="input-group-btn"> <input type="hidden"
											name="re_bpno" value="${view.bp_no}" />
											<button class="btn btn-sm btn-primary" type="button"
												name="commentInsertBtn">등록</button>
										</span>
									</div>
								</form>
							</div>
							<br>
							<div class="content">
								<div class="replyList"></div>
							</div>

							<%@ include file="reply.jsp"%>

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
<script>
$(document).ready(function() {

		var heartval = '${heart}';
		
		if (heartval > 0) {
			console.log(heartval);
			$("#heart").prop("src", "/resources/img/heart_on.png");
			$(".heart").prop('name', heartval)
		} else {
			console.log(heartval);
			$("#heart").prop("src", "/resources/img/heart_off.png");
			$(".heart").prop('name', heartval)
		}

		$(".heart").on("click", function(bp_no) {

			var that = $(".heart");

			var sendData = {
				'li_bpno' : '${view.bp_no}',
				'heart' : that.prop('name')
			};
			$.ajax({
				url : '/heart',
				type : 'POST',
				data : sendData,
				success : function(data) {
					that.prop('name', data);
					if (data == 1) {
						$('#heart').prop("src", "/resources/img/heart_on.png");
					} else {
						$('#heart').prop("src", "/resources/img/heart_off.png");
					}

				}
			});
		});
	});
</script>
</html>