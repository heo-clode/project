<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="en">

<%@ include file="boot/head.jsp"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript"></script>


<script>
$(function(){
	$("#pwSearchBtn").click(function(){
	var form = $(".login_body form");
	var postData = new Object();
	postData.mm_id = form.children("#mm_id").val();
	postData.mm_name = form.children("#mm_name").val();
	postData.mm_pnum = form.children("#mm_pnum").val();
	postData = JSON.stringify(postData);
	console.log(postData);
	$.ajax({
        url:'/pwdSearch',
        type:'POST',
        data: {"postData":postData},
        success:function(data){
           	alert("비밀번호 : "+ data);
           	}
        ,  
        error:function(e){
        	alert('정보를 다시 입력해주시길 바랍니다.' );
        }
        
        });
    });
})

</script>



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
						<div class="login">
							<div class="login_header">
								<a type="submit" class="idPwSearch" id="idPwSearch"
									href="/idPwSearch">아이디 찾기</a> <a type="submit" class="pwSearch"
									id="pwSearch" href="/pwSearch">비밀번호 찾기</a>
							</div>

							<div class="login_body">
								<form method="post" action="/pwdSearch">
									<input id="mm_id" type="text" name="mm_id" required placeholder="아이디"> <br>
									<input id="mm_name" type="text" name="mm_name" required placeholder="이름"> <br>
									<input id="mm_pnum"	type="text" name="mm_pnum" required placeholder="전화번호" title="전화번호"> <br>
									
									<button type="button" class="loginBtn" id="pwSearchBtn">비밀번호찾기</button>
								</form>

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
