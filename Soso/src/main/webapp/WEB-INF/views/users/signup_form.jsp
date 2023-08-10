<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup_form.jsp</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css" type="text/css">
</head>
<body>
   <jsp:include page="/WEB-INF/views/include/navbar_c.jsp">
      <jsp:param value="signup" name="current"/>
   </jsp:include>
   <div class="container">
      <p class="title">회원 가입</p>
      <form action="${pageContext.request.contextPath}/users/signup" method="post" id="myForm">
         <div>
            <label class="control-label" for="userName">이름(닉네임)</label>
            <input class="form-control" type="text" name="userName" id="userName"/>  
            <div class="invalid-feedback">2~16자의 영어(소문자) 또는 숫자 또는 한글만 사용가능합니다.</div>
         </div>
         <div>
            <label class="control-label" for="birth">생년월일</label>
            <input class="form-control" type="date" name="birth" id="birth"/>      
         </div>
         <fieldset>
               <legend>성별 체크</legend>
               <div class="form-check">
                   <input class="form-check-input" type="radio" id="one" name="gender" value="남" checked>
                   <label class="form-check-label" for="one">남</label>
               </div>
               <div class="form-check">
                   <input class="form-check-input" type="radio" id="two" name="gender" value="여">
                   <label class="form-check-label" for="two">여</label>
               </div>
               <div class="form-check">
                   <input class="form-check-input" type="radio" id="three" name="gender" value="비공개">
                   <label class="form-check-label" for="three">비공개</label>
               </div>
         </fieldset>
         <div>
            <label class="control-label" for="id">아이디</label>
            <input class="form-control" type="text" name="id" id="id"/> 
            <div><span id="result_checkId" style="font-size: 12px;"></span></div>
          	<div class="invalid-feedback">아이디를 확인하세요.</div>     
         </div>
         <div>
            <label class="control-label" for="pwd">비밀번호</label>
            <input class="form-control" type="password" name="pwd" id="pwd"/> 
            <div class="invalid-feedback">최소 8자 이상으로 문자와 숫자, 특수 문자를 각각 하나 이상 조합하세요.</div> 
         </div>
         <div>
            <label class="control-label" for="pwd2">비밀번호 확인</label>
            <input class="form-control" type="password" name="pwd2" id="pwd2"/>
            <div class="invalid-feedback">비밀번호가 일치하지 않습니다.</div> 
         </div>
         <div>
            <label class="control-label" for="email">이메일</label>
            <input class="form-control" type="text" name="email" id="email"/>
            <div class="invalid-feedback">이메일 형식에 맞게 입력하세요.</div>
         </div>
         <input id="allAgreements" type="checkbox" v-model="allAgreed" />
         <div>
		    <fieldset class="fieldarea f2">
		        <h1 class="h3 mb-3 font-weight-normal" style="width: 30rem">이용약관(필수)</h1>
		        <p class="agreeText">
		            <label for="agreement1">아래 사항에 동의 합니다.</label>
		            <input id="agreement1" type="checkbox" name="agreement1" />
		            <textarea id="text1" readonly>이용약관</textarea>
		        </p>
		    </fieldset>
		    <fieldset class="fieldarea f3">
		        <h1 class="h3 mb-3 font-weight-normal" style="width: 30rem">개인정보취급방침(필수)</h1>
		        <p class="agreeText">
		            <label for="agreement2">아래 사항에 동의 합니다.</label>
		            <input id="agreement2" type="checkbox" name="agreement2" />
		            <textarea id="text2" readonly>개인정보 방침 및 안내</textarea>
		        </p>
		    </fieldset>
		    <fieldset class="fieldarea f3">
		        <h1 class="h3 mb-3 font-weight-normal" style="width: 30rem">마케팅 이용약관(선택)</h1>
		        <p class="agreeText">
		            <label for="agreement3">아래 사항에 동의 합니다.</label>
		            <input id="agreement3" type="checkbox" name="agreement3" />
		            <textarea id="text3" readonly>이용약관</textarea>
		        </p>
		    </fieldset>
		 </div>
         <button class="btn btn-primary mt-3" type="submit" disabled>가입</button>
      </form>
   </div>   
   
    <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
   <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
   <script>
   		let isuserNameValid=false;
   		$("#userName").on("input", () => {
   		  const userName = $("#userName").val();
   		  const reg= /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$/;
   		  isuserNameValid = reg.test(userName);
   		  
	   	if (userName !== '') {
	      if (isuserNameValid) {
	  		 $("#userName").removeClass("is-invalid").addClass("is-valid");
	  		 $(".invalid-feedback.user-name-feedback").hide();
	  	  } else {
	  		 $("#userName").removeClass("is-valid").addClass("is-invalid");
	  		 $(".invalid-feedback.user-name-feedback").show();
	  	  }
	    }
   		  
   		  checkFormState();
   		});
   		
   		let isIdValid=false;
   		// 아이디 입력란을 수정할 때마다 유효성 검사와 중복 검사 수행
   	    $("#id").on("input", function() {
   	        let member_id = $(this).val();
   	        const reg = /^[a-z][a-z0-9]{1,14}$/;
   	        if (member_id === '') {
   	            $("#result_checkId").html("아이디를 입력하세요.").css("color", "red");
   	            $("#id").removeClass("is-valid").addClass("is-invalid");
   	            isIdValid = false; // 아이디 입력 안 함 처리
   	            checkFormState(); // 폼 상태 재검사
   	            return;
   	        }
   	        if (!reg.test(member_id)) {
   	            $("#result_checkId").html("2~15자의 영어 소문자와 숫자 조합으로 입력하세요.").css("color", "red");
   	            $("#id").removeClass("is-valid").addClass("is-invalid");
   	            isIdValid = false; // 정규표현식 검사 실패
   	            checkFormState(); // 폼 상태 재검사
   	            return;
   	        }
   	        $.ajax({
   	            method: "post",
   	            url: "${pageContext.request.contextPath}/users/idCheck",
   	            data: {"id": member_id},
   	            success: function(data) {
   	                console.log(data);
   	                if (data) {
   	                    $("#result_checkId").html("이미 사용중인 아이디입니다.").css("color", "red");
   	                    $("#id").removeClass("is-valid").addClass("is-invalid");
   	                    isIdValid = false; // 중복 아이디 검사 실패
   	                } else {
   	                    $("#result_checkId").html("사용 가능한 아이디입니다.").css("color", "green");
   	                    $("#id").removeClass("is-invalid").addClass("is-valid");
   	                    isIdValid = true; // 중복 아이디 검사 통과
   	                }
   	                checkFormState(); // 폼 상태 재검사
   	            },
   	            error: function(error) {
   	                alert(error);
   	            }
   	        });
   	    });
   
   		let isPwdValid=false;
	   	//비밀번호 입력란과 비밀번호 확인란에 입력했을때 실행할 함수 등록(다중선택)
	   	$("#pwd").on("input", () => {
		  const pwd = $("#pwd").val();
		  const reg = /^(?=.*[a-z])(?=.*\d)(?=.*[\W_]).{8,}$/;
		  isPwdValid = reg.test(pwd);
		  
		  if (pwd !== '') {
		    if (isPwdValid) {
		      $("#pwd").removeClass("is-invalid").addClass("is-valid");
		      $(".invalid-feedback.pwd-feedback").hide();
		    } else {
		      $("#pwd").removeClass("is-valid").addClass("is-invalid");
		      $(".invalid-feedback.pwd-feedback").show();
		    }
		  }
		  
		  checkFormState();
		});
	   	
	   	$("#pwd2").on("input", () => {
	   	  const pwd = $("#pwd").val();
	   	  const pwd2 = $("#pwd2").val();
	   	  
	   	  if (pwd2 !== '') {
	   	    if (pwd === pwd2) {
	   	      $("#pwd2").removeClass("is-invalid").addClass("is-valid");
	   	    } else {
	   	      $("#pwd2").removeClass("is-valid").addClass("is-invalid");
	   	    }
	   	  }
	   	  
	   	  checkFormState();
	   	});
	   	
	   	
	   	let isEmailValid=false;
	   	$("#email").on("input", (e) => {
	   	  const inputEmail = $(e.target).val();
	   	  const reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
	   	  isEmailValid = reg.test(inputEmail);
	   	  
	   	  if (inputEmail !== '') {
	   	    if (isEmailValid) {
	   	      $(e.target).removeClass("is-invalid").addClass("is-valid");
	   	      $(".invalid-feedback.email-feedback").hide();
	   	    } else {
	   	      $(e.target).removeClass("is-valid").addClass("is-invalid");
	   	      $(".invalid-feedback.email-feedback").show();
	   	    }
	   	  }
	   	  
	   	  checkFormState();
	   	});
   		
	 	// 체크박스 체크여부
	   	$("input:checkbox").click(checkedChange);

	   	function checkedChange() {
	   	    if ($(this).prop("checked")) {
	   	        $("label[for=" + this.id + "]").text("동의되었습니다.");
	   	        $("label[for=" + this.id + "]").css("color", "blue");
	   	    } else {
	   	        $("label[for=" + this.id + "]").text("동의 해주시기 바랍니다.");
	   	        $("label[for=" + this.id + "]").css("color", "red");
	   	    }

	   	    // 체크 상태에 따라 버튼 활성화 여부 관리
	   	    checkFormState();
	   	}
	   	
	 	// 마케팅 이용약관(선택) 체크박스 체크여부
	   	$("#agreement3").click(marketingAgreementChange);

	   	function marketingAgreementChange() {
	   	    if ($(this).prop("checked")) {
	   	        $("label[for=agreement3]").text("동의되었습니다.");
	   	        $("label[for=agreement3]").css("color", "blue");
	   	    } else {
	   	        $("label[for=agreement3]").text("아래 사항에 동의 합니다.");
	   	        $("label[for=agreement3]").css("color", ""); // 원래 색상으로 되돌림
	   	    }

	   	    // 체크 상태에 따라 버튼 활성화 여부 관리
	   	    checkFormState();
	   	}

	   	// 폼 전체의 유효성 여부를 판단해서 제출버튼의 disabled 속성을 관리하는 함수 
	   	function checkFormState() {
	   	    var isAgreement1Checked = $("#agreement1").prop("checked");
	   	    var isAgreement2Checked = $("#agreement2").prop("checked");

	   	    if (isuserNameValid && isIdValid && isEmailValid && isPwdValid && isAgreement1Checked && isAgreement2Checked) {
	   	        $("button[type=submit]").removeAttr("disabled");
	   	    } else {
	   	        // 속성명만 추가할 때는 value 에 빈 문자열을 작성하면 된다.
	   	        $("button[type=submit]").attr("disabled", "");
	   	    }
	   	}
	   	
	   	document.addEventListener("DOMContentLoaded", function() {
	         const allAgreements = document.getElementById("allAgreements");
	         const agreementCheckboxes = document.querySelectorAll('input[name^="agreement"]');

	         allAgreements.addEventListener("change", function() {
	            for (const checkbox of agreementCheckboxes) {
	               checkbox.checked = this.checked;
	            }
	            checkFormState();
	         });

	         for (const checkbox of agreementCheckboxes) {
	            checkbox.addEventListener("change", function() {
	               checkFormState();
	               if (!this.checked) {
	                  allAgreements.checked = false;
	               }
	            });
	         }

	         function checkFormState() {
	            const isAllChecked = Array.from(agreementCheckboxes).every(checkbox => checkbox.checked);
	            allAgreements.checked = isAllChecked;
	            document.querySelector('button[type="submit"]').disabled = !isAllChecked;
	         }
	      });

   </script>
   
</body>
</html>



















