<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


<!-- 버튼 이벤트 추가 -->
<script>
	$(document).on('click', '#btnWriteForm', function(e) {
		e.preventDefault();
		location.href = "${pageContext.request.contextPath}/board/write";
	});
</script>

<!-- 가로정렬 css  -->
<style type="text/css">
li {
	list-style: none;
	float: left;
	padding: 6px;
}
</style>


<!-- 추가 -->
<script>
	var msg = "${msg}";

	if (msg != "") {
		window.alert(msg);
	}

	//이전 버튼 이벤트
	function fn_prev(page, range, rangeSize) {
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		var url = "${pageContext.request.contextPath}/list";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		location.href = url;
	}

	//페이지 번호 클릭
	function fn_pagination(page, range, rangeSize, searchType, keyword) {
		var url = "${pageContext.request.contextPath}/list";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		location.href = url;
	}

	//다음 버튼 이벤트
	function fn_next(page, range, rangeSize) {
		var page = parseInt((range * rangeSize)) + 1;
		var range = parseInt(range) + 1;

		var url = "${pageContext.request.contextPath}/list";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		location.href = url;
	}
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

						<div>
							<h2>board list</h2>
							<article>
								<div class="container">
									<div class="table-responsive">
										<table class="table table-striped table-sm">
											<colgroup>
												<col style="width: 5%;" />
												<col style="width: auto;" />
												<col style="width: 15%;" />
												<col style="width: 10%;" />
												<col style="width: 10%;" />
											</colgroup>

											<thead>
												<tr>
													<th>NO</th>
													<th>글제목</th>
													<th>작성자</th>
													<th>조회수</th>
													<th>좋아요</th>
													<th>작성일</th>
												</tr>
											</thead>

											<tbody>
												<c:choose>
													<c:when test="${empty list}">
														<tr>
															<td colspan="6" align="center">데이터가 없습니다.</td>
														</tr>
													</c:when>

													<c:when test="${!empty list}">
														<c:forEach var="list" items="${list}">
															<tr>
																<td><c:out value="${list.bp_no}" /></td>
																<td><a href="/view?bp_no=${list.bp_no}"><c:out
																			value="${list.bp_name}" /></a></td>
																<td><c:out value="${list.bp_writer}" /></td>
																<td><c:out value="${list.bp_count}" /></td>
																<td><c:out value="${list.bp_like}" /></td>
																<td><fmt:formatDate value="${list.bp_date}"
																		pattern="yyyy.MM.dd-hh:mm:ss" /></td>
															</tr>
														</c:forEach>
													</c:when>
												</c:choose>
											</tbody>
										</table>
									</div>
								</div>
							</article>
							<form method="get" style="padding-left: 24px;">
								<div class="search">
									<select name="searchType">
										<option value="n"
											<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
										<option value="t"
											<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
										<option value="c"
											<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
										<option value="w"
											<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
										<option value="tc"
											<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
									</select> <input type="text" name="keyword" id="keywordInput"
										value="${scri.keyword}" /> <input type="hidden" name="bo_num"
										value="${bo_num}">
									<button id="searchBtn" type="button">검색</button>
								</div>
							</form>
							<ul>
								<c:if test="${pageMaker.prev}">
									<li><a
										href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
								</c:if>

								<c:forEach begin="${pageMaker.startPage}"
									end="${pageMaker.endPage}" var="idx">
									<li><a href="list${pageMaker.makeSearch(idx)}">${idx}</a></li>
								</c:forEach>

								<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									<li><a
										href="list${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
								</c:if>
							</ul>
						</div>
						<div class="writeBtn"
							style="float: right; position: relative; height: 100%; top: 150px;">
							<form action="/write">
								<button type="submit" class="btn btn-sm btn-primary">글쓰기</button>
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
