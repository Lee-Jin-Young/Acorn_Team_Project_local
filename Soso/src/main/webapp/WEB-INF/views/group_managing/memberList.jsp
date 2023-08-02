<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소모임 가입자 관리 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
<style>
	.container{
		width: 992px;
	}
	.card-image{
		width: 100px;
		height: 100px;
		border-radius: 50%;
	}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/navbar.jsp">
		<jsp:param value="home" name="current"/>
	</jsp:include>
	<div class="container">
		<div class="m-2 mt-4 mb-3 border-bottom border-dark">
			<div class="ms-3 fw-bold fs-2 mb-4">Member</div>
		</div>
		<div class="d-flex ms-4 mb-5">
			<div class="col-2 me-2"><a style="text-decoration: none; color:rgb(65, 75, 178)" class="fw-bolder fs-5" href="#">참여 중</a></div>
			<div><a style="text-decoration: none;" class="link-dark fw-bold fs-5" href="#">강퇴</a></div>
		</div>
		<div class="ms-2 me-2">
			<div class="border border-dark-subtle col-6 rounded-4 m-2">
				<div class="d-flex pt-3 ps-5 pe-5 pb-5">
					<div class="col-3 me-5 d-flex align-items-center">
						<div><img class="card-image" src="https://plus.unsplash.com/premium_photo-1667251758255-514ef43844fb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Ym9va3xlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=400&q=60"/></div>
					</div>
					<div class="col pt-4">
						<h4 style="font-weight:600">NAME</h4>
						<div class="mt-3">DATE: 2023-07-28</div>
						<div class="mb-3"><a class="link" href="${pageContext.request.contextPath}/cafe/list">활동 내역 보기</a></div>
						<div class="d-flex mt-1 justify-content-end">
							<div><a style="background-color:rgb(248, 163, 146); width:100px" class="btn" href="${pageContext.request.contextPath}/group_managing/group_updateForm">강퇴</a></div>
						</div>
					</div>
				</div>
			</div>
			<div class="border border-dark-subtle col-6 rounded-4 m-2">
				<div class="d-flex pt-3 ps-5 pe-5 pb-5">
					<div class="col-3 me-5 d-flex align-items-center">
						<div><img class="card-image" src="https://plus.unsplash.com/premium_photo-1667251758255-514ef43844fb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Ym9va3xlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=400&q=60"/></div>
					</div>
					<div class="col pt-4">
						<h4 style="font-weight:600">NAME</h4>
						<div class="mt-3">DATE: 2023-07-28</div>
						<div class="mb-3"><a class="link" href="${pageContext.request.contextPath}/cafe/list">활동 내역 보기</a></div>
						<div class="d-flex mt-1 justify-content-end">
							<div><a style="background-color:rgb(248, 163, 146); width:100px" class="btn" href="${pageContext.request.contextPath}/group_managing/group_updateForm">강퇴</a></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>