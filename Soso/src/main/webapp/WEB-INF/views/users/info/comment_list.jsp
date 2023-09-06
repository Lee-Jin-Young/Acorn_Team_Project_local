<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="altertable">
		<table class="table table-striped">
			<thead class="table-dark">
				<tr>
				<th>소모임 명</th>
				<th>원글 제목</th>
				<th>댓글 내용</th>
				<th>댓글 작성일</th>
			</tr>
			</thead>
			<tbody>
				
				<c:forEach var="tmp" items="${list }">
					<tr>
						<td>${tmp.group_num }</td>
						<td>
							<a href="${pageContext.request.contextPath}/cafe/detail?comu_num=${tmp.comu_num}&group_num=${tmp.group_num}">${tmp.title }</a>
						</td>
						<td>${tmp.content }</td>
						<td>${tmp.regdate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<nav class="d-flex justify-content-center">
			<ul class="pagination">
				<c:if test="${startPageNum ne 1 }">
					<li class="page-item">
						<a class="page-link comment-link" href="${pageContext.request.contextPath}/users/info/comment_list?pageNum=${startPageNum-1 }">Prev</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
					<li class="page-item ${pageNum eq i ? 'active' : '' }">
						<a class="page-link comment-link" href="${pageContext.request.contextPath}/users/info/comment_list?pageNum=${i }" data-page-num=${i}>${i }</a>
					</li>
				</c:forEach>
				<c:if test="${endPageNum lt totalPageCount }">
					<li class="page-item">
						<a class="page-link comment-link" href="${pageContext.request.contextPath}/users/info/comment_list?pageNum=${endPageNum+1 }">Next</a>
					</li>
				</c:if>				
			</ul>
		</nav>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function() {
			$(document).on("click", ".comment-link", function(e) {
				e.preventDefault(); 
	
				// 클릭한 페이지의 번호를 가져옵니다.
				var pageNum = $(this).data("page-num");
	
				// AJAX 처리를 통해 페이지 내용을 갱신하는 코드를 추가합니다.
				$.ajax({
					type: "GET",
					url: "${pageContext.request.contextPath}/users/info/comment_list?&pageNum=" + pageNum,
					dataType: "text",
					error: function() {
						console.log("통신실패");
					},
					success: function(data) {
						// 받아온 데이터를 사용하여 페이지 내용을 갱신하는 코드를 작성합니다.
						$(".altertable").html(data);
					}
				});
			});
		});
		
	</script>
</body>
</html>