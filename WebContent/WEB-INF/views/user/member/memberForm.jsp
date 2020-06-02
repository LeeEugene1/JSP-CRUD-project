<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$('form[name=memberForm]').submit(function(){
			if(!$('input[name=mem_name]').val().validationNM()) {
				BootstrapDialog.show({
			 	    title: 'alert',
			 	    message: '이름을 바르게 입력해주세요.'
			 	});
				return false;
			}
	      	if(!$('.mem_id').val().validationID()) {
	      		BootstrapDialog.show({
			 	    title: 'alert',
			 	    message: '아이디를 바르게 입력해주세요.'
			 	});
				return false;
			}
	      	if(!$('input[name=mem_regno1]').val().validationRegno1()) {
	      		BootstrapDialog.show({
			 	    title: 'alert',
			 	    message: '주민번호를 바르게 입력해주세요.'
			 	});
				return false;
			}
	      	if(!$('input[name=mem_regno2]').val().validationRegno2()) {
	      		BootstrapDialog.show({
			 	    title: 'alert',
			 	    message: '주민번호를 바르게 입력해주세요.'
			 	});
				return false;
			}
	      	if(!$('input[class=mem_pass]').val().validationPWD()) {
	      		BootstrapDialog.show({
			 	    title: 'alert',
			 	    message: '비밀번호를 바르게 입력해주세요.'
			 	});
				return false;
			}
	      	if($('input[class=mem_pass]').val() != $('input[name=mem_pass_confirm]').val()){
	      		BootstrapDialog.show({
			 	    title: 'alert',
			 	    message: '비밀번호들을 동일하게 입력해주세요.'
			 	});
				return false;
			}
	      	if(!$('input[name=mem_mail1]').val().validationID()) {
	      		BootstrapDialog.show({
			 	    title: 'alert',
			 	    message: '이메일을 바르게 입력해주세요.'
			 	});
				return false;
			}
	      	
			$(this).attr("action", "${pageContext.request.contextPath}/user/member/insertMember.do");
			$(this).append('<input type="hidden" class="mem_id" value=""/>');
			
			var mem_bir = $('input[name=mem_bir1]').val() + '-' + $('input[name=mem_bir2]').val() + '-' + $('input[name=mem_bir3]').val();
			$('input[name=mem_bir]').val(mem_bir);
			
			var mem_hp = $('select[name=mem_hp1]').val() + '-' + $('input[name=mem_hp2]').val() + '-' + $('input[name=mem_hp3]').val();
			$('input[name=mem_hp]').val(mem_hp);
			
			var mem_mail = $('input[name=mem_mail1]').val() + '@' + $('select[name=mem_mail2]').val();
			$('input[name=mem_mail]').val(mem_mail);
			
			var mem_zip = $('input[name=mem_zip1]').val() + '-' + $('input[name=mem_zip2]').val();
			$('input[name=mem_zip]').val(mem_zip);
			
			var mem_joinChart = $('select[name=mem_joinChart]').val();
			
	      	return true;
		});
 	});
	
	function idCheck() {
		$.ajax({
			    url : "${pageContext.request.contextPath }/user/member/idCheck.do" 
			    , dataType : "json"
			    , data : { join_mem_id : $('#join_mem_id').val() } 
			    
			    , error : function(result) {
				              alert("code : " + result.status + "\r\nmessage : " + result.responseText);
			              }
			    , success : function(result) {
		                        if(eval(result.flag)) {
		                        	alert('사용 가능한 아이디입니다.');
		                        } else {
		                        	alert('사용 불가능한 아이디입니다.');
		                        }
			   				 }
			    , beforeSend: function() { }
			    , complete: function() {
				                $.ajax({});
			    			}
		    });
	}
	
</script>

</head>
<style>
.fieldName {text-align: center; background-color: #f4f4f4;}
.tLine {background-color: #d2d2d2; height: 1px;}
.btnGroup { text-align: right; }
td {text-align: left; }
</style>
<body>
<form name="memberForm" method="post" enctype="multipart/form-data">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">성 명</td>
		<td>
			<input type="text" name="mem_name" value=""/>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">주민등록번호</td>
		<td>
			<input type="text" name="mem_regno1" size="6" value=""/>
  			<input type="text" name="mem_regno2" size="7" value=""/>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">생년월일</td>
		<td>
				<input type="hidden" name="mem_bir" />
				<input type="text" name="mem_bir1" size="4" value="" />년
				<input type="text" name="mem_bir2" size="2" value="" />월
				<input type="text" name="mem_bir3" size="2" value="" />일
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">아이디</td>
		<td>
			<input type="text" name="mem_id" class="mem_id" id="join_mem_id" /><b><a href="javascript:idCheck();">[ID 중복검사]</a></b>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">비밀번호</td>
		<td>
			<input type="text" name="mem_pass" class="mem_pass" value="" /> 8 ~ 20 자리 영문자 및 숫자 사용
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">비밀번호확인</td>
		<td>
			<input type="text" name="mem_pass_confirm" value="" /> 8 ~ 20 자리 영문자 및 숫자 사용
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="margin-top: 10px;">
	<tr>
		<td class="fieldName" width="100px" height="25">핸드폰</td>
		<td>
			<input type="hidden" name="mem_hp"/>
			<select name="mem_hp1">
				<option value="010">010</option>
				<option value="016">016</option>				        	
				<option value="017">017</option>				        	
				<option value="019">019</option>				        	
			</select>	-
			<input type="text" name="mem_hp2" size="4" value="" /> - 
			<input type="text" name="mem_hp3" size="4" value="" />
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">이메일</td>
		<td>
			<input type="hidden" name="mem_mail" />
			<input type="text" name="mem_mail1" value="" /> @
			<select name="mem_mail2">
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
				<option value="hanmail.net">hanmail.net</option>
				<option value="nate.com">nate.com</option>
				<option value="gmail.com">gmail.com</option>				
			</select>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
		
	<tr>
		<td class="fieldName" width="100px" height="25">주소</td>
		<td>
			<input type="hidden" name="mem_zip" />
			<input type="text" name="mem_zip1" id="mem_zip1" size="3" value="" /> - 
			<input type="text" name="mem_zip2" id="mem_zip2" size="3" value="" />
			<br>
			<input type="text" name="mem_add1" id="mem_add1" value="" />
			<input type="text" name="mem_add2" id="mem_add2" value="" />
		</td>
	</tr>
		<tr><td class="tLine" colspan="2"></td></tr>
		<tr>
		<td class="fieldName" width="100px" height="25">회원가입경로</td>
		<td>
			<input type="hidden" name="mem_joinChart" />
			<select name="mem_joinChart">
				<option value="인터넷검색" selected="selected">인터넷검색</option>
				<option value="SNS">SNS</option>
				<option value="카페/블로그">카페/블로그</option>
				<option value="인터넷뉴스/기사">인터넷뉴스/기사</option>
				<option value="지인소개">지인소개</option>				
				<option value="기타">기타</option>				
			</select>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr><td colspan="2" height="20"></td></tr>
	
	<tr>
		<td class="btnGroup" colspan="2" >
			<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn1" type="submit">가입하기</button>
			<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn2" type="reset"><a href="${pageContext.request.contextPath}/user/main.do">취소</a></button>
		</td>
	</tr>
</table>
</form>
</body>
</html>








