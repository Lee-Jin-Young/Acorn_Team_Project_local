<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 게시판</title>
<link rel="shortcut icon" type="image/x-icon" href="${path }/resources/images/main/favicon.jpg">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/review.css" />
<div class="container"> 
   <div>
	  <h4>리뷰를 입력해 주세요</h4>
      <!-- 원글에 댓글을 작성할 폼 -->
      <form class="comment-form insert-form" action="review_insert" method="post" id="myform">
         <!-- 원글의 글번호가 댓글의 ref_group 번호가 된다. -->
         <input type="hidden" name="group_num" value=${num } />
   		 <fieldset>
         	<small>평점</small>
         	<input type="radio" name="rate" value="5" id="rate1"><label for="rate1">⭐</label>
        	<input type="radio" name="rate" value="4" id="rate2"><label for="rate2">⭐</label>
        	<input type="radio" name="rate" value="3" id="rate3"><label for="rate3">⭐</label>
        	<input type="radio" name="rate" value="2" id="rate4"><label for="rate4">⭐</label>
        	<input type="radio" name="rate" value="1" id="rate5"><label for="rate5">⭐</label>
         </fieldset>
         <br />
         <textarea name="review_content" id="review_content">${empty id ? '리뷰 작성을 위해 로그인이 필요 합니다.' : '' }</textarea>
         <button type="submit">등록</button>
      </form>
    </div>
</div>
</body>
</html>