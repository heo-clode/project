<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" pageEncoding = "UTF-8"%>
<c:set var = "contextPath" value = "${pageContext.request.contextPath}" />
<%
   request.setCharacterEncoding("UTF-8");
%>
<!-- Page Heading -->
		<div class="d-sm-flex align-items-center justify-content-between mb-4">
           <div>
            <h3>공지사항</h3>
            	<table>
            		<thead>
            		<tr>
            			<td class = "no">번호</td>
            			<td>제목</td>
            			<td>작성자</td>
            			<td>작성날짜</td>
            		</tr>
            		</thead>
            		<tbody>
            			<c:forEach items = "${list}" var = "list">
            			<tr>
            				<td class = "no" >${list.bp_no}</td>
            				<td><a href = "/">${list.bp_name}</a></td>
            				<td>${list.bp_writer}</td>
            				<td><fmt:formatDate value="${list.bp_date}" pattern="yyyy.MM.dd-hh:mm:ss" /></td>
            			</tr>
            			</c:forEach>
            		</tbody>
            	</table>
            </div>
          </div>