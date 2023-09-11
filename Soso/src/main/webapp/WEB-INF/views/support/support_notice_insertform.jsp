<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록</title>
<link rel="shortcut icon" type="image/x-icon" href="${path }/resources/images/main/favicon.jpg">
<style>
	.notice_btn{
		width: 130px;
	    height: 48px;
	    border-radius: 0;
	    border: 1px solid #d8d8d8;
	    background-color: #f7f7f7;
	    text-align: center;
	    line-height: 48px;
	    font-size: 14px;
	    color: #333;
	}
	.notice_btn:hover{
		color: rgb(157 128 63);
		font-weight: 600;
	}
	.admin_menu{
		width: 100%;
		display: flex;
		justify-content: center;
	}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/support/support_inquire.css" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/navbar.jsp">
		<jsp:param value="home" name="current"/>
	</jsp:include>
    <main id="main-banner" class="main-banner-06">
        <div class="inner-wrap">
            <div class="title">
                <h2>고객센터</h2>
                <p>
			                    서비스 이용 중 불편 했던 점이나 궁금한 점을 <br />
			                    빠르고 친절하게 안내해 드리겠습니다.
                </p>
            </div>
            <div class="indicator">
                <div class="home circle">
                    <a href="#" title="메인페이지가기"><img src="${path }/resources/images/sub/icon_home.svg" alt="홈버튼이미지"></a>
                </div>
                <div class="main-menu circle">BOOKMATE</div>

            </div>
        </div>
    </main>
	<!-- 메인 메뉴바 시작 -->
	<div class="main_area">
	<ul class="menu_bar">
		<li class="menu_home">
			<a class="nav-link" href="${pageContext.request.contextPath }/support/support_main">고객센터</a>
		</li>
		<li class="menu_faq">
			<a class="nav-link" href="${pageContext.request.contextPath }/support/support_faq">자주하는 질문</a>
		</li>
		<li class="menu_notice">
			<a class="nav-link active" href="${pageContext.request.contextPath }/support/support_notice">공지사항</a>
		</li>
		<li class="menu_inquire">
			<a class="nav-link" href="${pageContext.request.contextPath }/support/support_inquire">문의하기</a>
		</li>
	</ul>
		<div class="body_area">
			<div class="main_content">
				<h3>공지사항 등록</h3>
				<form action="${pageContext.request.contextPath }/support/support_notice_insert" class="area_form" method="post" enctype="multipart/form-data">
					<div class="row-wrap">
						<div class="input_title">
							<h4 class="label">공지</h4>
							<select name="category" id="category" class="title_select">
								<option selected="selected" class="inquire_select">분류</option>
								<option value="1">공지</option>
								<option value="2">업데이트</option>
								<option value="3">휴무</option>
								<option value="0">기타</option>
							</select>
							<input type="text" class="inquire_title" name="title" id="title" placeholder="제목을 입력해주세요" />
						</div>
					</div>
					<div class="row-wrap">
						<div class="input_text">
							<h4 class="label">내용 *</h4>
							<textarea name="content" id="content" cols="30" rows="20" placeholder="내용을 입력 해 주세요."></textarea>
						</div>
					</div>
					
					<p class="info_message">
						이 사이트는 reCAPTCHA에 의해 보호되며 Google 개인 정보 취급 방침 및 서비스 약관이 적용됩니다.
					</p>
					<div class="admin_menu">
						<button type="submit" class="notice_btn">공지사항 등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
</main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
</body>
</html>





