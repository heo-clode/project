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
					<form action="/mDel">
						<!-- Page Heading -->
						<div
							class="d-sm-flex align-items-center justify-content-between mb-4">

							<c:choose>
								<c:when test="${m_num == 1}">

									<table>
										<tr>
											<th class="no"></th>
											<th class="no">NO</th>
											<th>학교 코드</th>
											<th>학교 이름</th>
											<th>지역 코드</th>
										</tr>
										<c:forEach var="mlist" items="${mlist}" varStatus="status">
											<tr>
												<td class="no"><input type="checkbox" name="sc_code"
													value="${mlist.sc_code}" /></td>
												<td class="no">${status.count}</td>
												<td>${mlist.sc_code}</td>
												<td>${mlist.sc_name}</td>
												<td>${mlist.sc_local}</td>
											</tr>
										</c:forEach>
									</table>
								</c:when>

								<c:when test="${m_num == 2}">
									<table>
										<tr>
											<th class="no"></th>
											<th class="no">NO</th>
											<th>회원 코드</th>
											<th>학교 코드</th>
											<th>아이디</th>
											<th>비밀번호</th>
											<th>이름</th>
											<th>이메일</th>
											<th>전화번호</th>
											<th>가입날짜</th>
											<th>등급</th>
										</tr>
										<c:forEach var="mlist" items="${mlist}" varStatus="status">
											<tr>
												<td class="no"><input type="checkbox" name="mm_code"
													value="${mlist.mm_code}" /></td>
												<td class="no">${status.count}</td>
												<td>${mlist.mm_code}</td>
												<td>${mlist.mm_sccode}</td>
												<td>${mlist.mm_id}</td>
												<td>${mlist.mm_pw}</td>
												<td>${mlist.mm_name}</td>
												<td>${mlist.mm_email}</td>
												<td>${mlist.mm_pnum}</td>
												<td><fmt:formatDate value="${mlist.mm_date}"
														pattern="yyyy.MM.dd-hh:mm:ss" /></td>
												<td>${mlist.mm_lev}</td>
											</tr>
										</c:forEach>
									</table>
								</c:when>

								<c:when test="${m_num == 3}">
									<table>
										<tr>
											<th class="no"></th>
											<th class="no">NO.</th>
											<th>게시판코드</th>
											<th>게시글번호</th>
											<th>글제목</th>
											<th>내용</th>
											<th>작성자코드</th>
											<th>작성자</th>
											<th>날짜</th>
											<th class="no">좋아요</th>
											<th class="no">조회수</th>
										</tr>
										<c:forEach var="mlist" items="${mlist }" varStatus="status">
											<tr>
												<td class="no"><input type="checkbox" name="bp_no"
													value="${mlist.bp_no }" /></td>
												<td class="no">${status.count}</td>
												<td>${mlist.bp_bocode }</td>
												<td>${mlist.bp_no }</td>
												<td>${mlist.bp_name }</td>
												<td>${mlist.bp_content }</td>
												<td>${mlist.bp_mmcode }</td>
												<td>${mlist.bp_writer }</td>
												<td><fmt:formatDate value="${mlist.bp_date}"
														pattern="yyyy.MM.dd-hh:mm:ss" /></td>
												<td class="no">${mlist.bp_like }</td>
												<td class="no">${mlist.bp_count }</td>
											</tr>
										</c:forEach>
									</table>
								</c:when>

								<c:when test="${m_num == 4}">
									<table>
										<tr>
											<th class="no"></th>
											<th class="no">NO.</th>
											<th>게시판코드</th>
											<th>게시판번호</th>
											<th>글번호</th>
											<th>내용</th>
											<th>작성자코드</th>
											<th>작성자</th>
											<th>날짜</th>
										</tr>
										<c:forEach var="mlist" items="${mlist }" varStatus="status">
											<tr>
												<td class="no"><input type="checkbox" name="re_no"
													value="${mlist.re_no }" /></td>
												<td class="no">${status.count}</td>
												<td>${mlist.re_no }</td>
												<td>${mlist.re_bpbocode }</td>
												<td>${mlist.re_bpno }</td>
												<td>${mlist.re_content }</td>
												<td>${mlist.re_mmcode }</td>
												<td>${mlist.re_writer }</td>
												<td><fmt:formatDate value="${mlist.re_date }"
														pattern="yyyy.MM.dd-hh:mm:ss" /></td>
											</tr>
										</c:forEach>
									</table>
								</c:when>
							</c:choose>


						</div>
						<c:if test="${m_num ne null}">
							<button class="btn btn-sm btn-primary">삭제</button>
						</c:if>
					</form>
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
