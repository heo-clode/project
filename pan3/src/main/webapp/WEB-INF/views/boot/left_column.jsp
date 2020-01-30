<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<!-- Sidebar -->
<ul class="navbar-nav sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
		<div class="sidebar-brand-icon rotate-n-15"></div>
		<div class="sidebar-brand-text mx-3">
			<img alt="급식판" width="220" height="125" src="resources/img/pan.png">
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0" />

	<div class="category">

		<!-- 로그인x -> 학교검색 -->
		<c:if test="${mm_name eq null}">
			<form action="/schoolSearch" method="post"
				class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
				<div class="input-group">
					<input type="text" class="form-control bg-light border-0 small"
						placeholder="학교 검색" name="sc_name" id="sc_name"
						aria-label="Search" aria-describedby="basic-addon2">
					<div class="input-group-append">
						<button class="btn btn-primary" type="button">
							<i class="fas fa-search fa-sm"></i>
						</button>
					</div>
				</div>
			</form>
		</c:if>

		<c:if test="${sc_name ne null}">
			<br>
			<br>
			<table>
				<c:forEach var="sc_name" items="${sc_name}">
					<tr>
						<c:out value="${sc_name}" />
					</tr>
					<br>
					<br>
				</c:forEach>
			</table>

		</c:if>

		<!-- 로그인o -> 게시판 목록 -->
		<c:if test="${mm_name ne null}">
			<c:if test="${mm_lev eq 'E '}">
				<a class="bo" href="/list?bo_num=0">공지사항</a>
				<br>
				<br>
				<a class="bo" href="/list?bo_num=7">자유게시판</a>
				<br>
				<br>
				<a class="bo" href="/list?bo_num=1">신입생게시판</a>
				<br>
				<br>
				<a class="bo" href="/list?bo_num=2">외부인게시판</a>
				<br>
				<br>
				<a class="bo" href="/list?bo_num=3">동아리게시판</a>
				<br>
				<br>
				<a class="bo" href="/list?bo_num=4">진학게시판</a>
				<br>
				<br>
				<a class="bo" href="/list?bo_num=5">동창회게시판</a>
				<br>
				<br>
				<a class="bo" href="/list?bo_num=6">신고게시판</a>
				<br>
				<br>
				<a class="bo" href="/list?bo_num=8">중고나라</a>
				<br>
				<br>
			</c:if>
			<c:if test="${mm_lev eq 'M '}">
				<a class="btn btn-sm btn-primary" href="/mlist?m_num=1">학교 관리</a>
				<br>
				<br>
				<a class="btn btn-sm btn-primary" href="/mlist?m_num=2">회원 관리</a>
				<br>
				<br>
				<a class="btn btn-sm btn-primary" href="/mlist?m_num=3">게시글 관리</a>
				<br>
				<br>
				<a class="btn btn-sm btn-primary" href="/mlist?m_num=4">댓글 관리</a>
				<br>
				<br>
			</c:if>
		</c:if>
	</div>

</ul>
<!-- End of Sidebar -->