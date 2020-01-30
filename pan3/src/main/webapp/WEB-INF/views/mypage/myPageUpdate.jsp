<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding = "UTF-8"%>
<c:set var = "contextPath" value = "${pageContext.request.contextPath}" />
<%
   request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="en">

<%@ include file = "../boot/head.jsp" %>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <%@ include file = "../boot/left_column.jsp" %>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <%@ include file = "../boot/topbar.jsp" %>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
		<div class="d-sm-flex align-items-center justify-content-between mb-4">
           <div class = "myPage">
            		<div class = "myPage_header">
            			<a type="submit" class = "myPage" id = "myPage" href = "myPage">회원정보</a>
            			<a type="submit" class ="myPage" id = "myPage" href = "">작성글보기</a>
            			<a type="submit" class ="myPage" id = "myPage" href = "">작성댓글보기</a>
            		</div>
            		
            		<div class = "myPage_body">
            		    <form method="post" action = "/myPageUpdateTRY">
            				
            				<table>
            				<c:forEach var="mm" items="${List }">
            				<tr><td>아이디</td><td>${mm.mm_id }</td></tr>
            				<tr><td>이름</td>
            				<td><input class="mm_name" id="mm_name" name="mm_name" placeholder="${mm.mm_name }" required="required"></td></tr>
            				<tr><td>전화번호</td>
            				<td><input class="mm_pnum" id="mm_pnum" name="mm_pnum" placeholder="${mm.mm_pnum }" required="required"></td></tr>
            				<tr><td>이메일</td>
            				<td><input class="mm_email" id="mm_email" name="mm_email" placeholder="${mm.mm_email }" required="required"></td></tr>
            				<tr><td>가입일</td><td>${mm.mm_date } </td></tr>
            				</c:forEach>
            				
            				</table>
            				
            				<button type="submit" class = "myPageBtn" id = "myPageBtn">정보수정</button>
            			</form>
            		
            		</div>
            </div>
          </div>
        </div>
        
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <%@ include file = "../boot/main_footer.jsp" %>

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <%@ include file = "../boot/plugin_js.jsp" %>

</body>

</html>
