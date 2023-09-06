<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="inner-wrap">
	<div class="faq_form">
		<form action="${pageContext.request.contextPath}/group/faq/insert" method="post">
		<c:if test="${empty sessionScope.id }">
			<div class="col-12">
				  <input type="text" id="group_num" name="group_num" value="${num }" hidden />
			      <input type="text" class="form-control" id="q_title" name="q_title" placeholder="로그인한 상태에서만 문의작성하기가 가능합니다." readonly>
			<div>
				<label for="q_content"></label>
				<textarea name="q_content" id="q_content" rows="10" readonly>로그인한 상태에서만 문의작성하기가 가능합니다.</textarea>
			</div>	
			<button type="submit" onclick="submitContents(this)" id="submitBtn">등록</button>
		</c:if>
		<c:if test="${not empty sessionScope.id }">
			<div class="col-12">
				  <input type="text" id="group_num" name="group_num" value="${num }" hidden />
			      <input type="text" class="form-control" id="q_title" name="q_title" placeholder="문의글 제목을 입력해주세요" >
			<div>
				<label for="q_content"></label>
				<textarea name="q_content" id="q_content" rows="10"></textarea>
			</div>	
			<button type="submit" onclick="submitContents(this)" id="submitBtn">등록</button>
		</c:if>
			<button type="reset" id="resetBtn">리셋</button>
		</form>
	</div>
</div>

	<script>
	
	//여기서부터 ajax faq
	//취소버튼 누르면 돌아가기
	$("#resetBtn").click(function() {
		$.ajax({
			type : "GET", //전송방식을 지정한다 (POST,GET)
	        url : "${pageContext.request.contextPath}/group/faq/list?num=${num }",//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
	        dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
	        error : function(){
	        	console.log("통신실패");
	        },
	        success : function(Parse_data){
	            $("#Parse_Area").html(Parse_data); //div에 받아온 값을 넣는다.
	            console.log("통신 데이터 값 : " + Parse_data);
	    });
	});
	</script>