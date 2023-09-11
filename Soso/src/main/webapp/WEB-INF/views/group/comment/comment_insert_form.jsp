<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/review.css" />
<style>
	#submitBtn {
    border: 1.5px solid #d4cab5;
    border-radius: 10px;
    padding: 9px 20px;
    float: right;
    background-color: #d4cab5;
    color: #fff;
}
	
	#contents{
		resize : none;
		background-color: #0000000b;
		margin : 2% 0;
		border-radius : 10px;
	    padding: 50px 30px; /* 원하는 패딩 값 설정 */
	}
	
</style>
<div class="container"> 
   <div>
      <form action="${pageContext.request.contextPath}/group/comment/review_insert" method="post" id="myform">
         <!-- 소모임의 num을 같이 넣어준다. -->
         <input type="hidden" name="group_num" value=${num } />
         <fieldset>
         	<input type="radio" name="rate" value="5" id="rate1"><label for="rate1">⭐</label>
        	<input type="radio" name="rate" value="4" id="rate2"><label for="rate2">⭐</label>
        	<input type="radio" name="rate" value="3" id="rate3"><label for="rate3">⭐</label>
        	<input type="radio" name="rate" value="2" id="rate4"><label for="rate4">⭐</label>
        	<input type="radio" name="rate" value="1" id="rate5"><label for="rate5">⭐</label>
         </fieldset>
         <textarea name="content" id="contents">${empty id ? '리뷰 작성을 위해 로그인이 필요 합니다.' : '' }</textarea>    
        <button type="submit" id="submitBtn">등록</button>
      </form>
   </div>
</div>