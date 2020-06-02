<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/validation.js"></script>
<script type="text/javascript">
	$(function(){
		$('input[name=mem_name]').val('${memberInfo.mem_name}');
		$("input[name=mem_regno1]").val('${memberInfo.mem_regno1}')+"-"+$("input[name=mem_regno2]").val('${memberInfo.mem_regno2}');
		
		var bir = '${memberInfo.mem_bir}'.split(" ")[0].split("-");
		$('input[name=mem_bir1]').val(bir[0]);
		$('input[name=mem_bir2]').val(bir[1]);
		$('input[name=mem_bir3]').val(bir[2]);

		$('input[name=mem_id]').val('${memberInfo.mem_id}');
		$('input[name=mem_pass]').val('${memberInfo.mem_pass}');
		$('input[name=mem_pass_confirm]').val('${memberInfo.mem_pass}');
		
		var ph = '${memberInfo.mem_hp}'.split("-");
		$('select[name=mem_hp1] option').each(function() {
			if($(this).val() == ph[0]) {
				$(this).attr("selected", "selected");
			}
		});
		$('input[name=mem_hp2]').val(ph[1]);
		$('input[name=mem_hp3]').val(ph[2]);
		
		var mail = '${memberInfo.mem_mail}';
		var mailArr = mail.split("@");
		$('input[name=mem_mail1]').val(mailArr[0]); 
		
		$('select[name=mem_mail2] option').each(function() {
			if($(this).val() == mailArr[1]) {
				$(this).attr("selected", "selected");
			}
		});
		
		var zip = '${memberInfo.mem_zip}';
		var zipArr = zip.split("-");
		$('input[name=mem_zip1]').val(zipArr[0]); 
		$('input[name=mem_zip2]').val(zipArr[1]); 

		$('form[name=memberForm]').submit(function(){
			$(this).attr("action", "${pageContext.request.contextPath}/user/member/updateMember.do");
			$(this).append('<input type="hidden" name="mem_id" value="${memberInfo.mem_id}"/>');
			
			$("input[name=mem_name]").val();

			$("input[name=mem_mail]").val($('input[name=mem_mail1]').val()
				     +"@"+$('select[name=mem_mail2]').val());
			
			$("input[name=mem_hp]").val($('select[name=mem_hp1]').val()+"-"+$('input[name=mem_hp2]').val()+"-"+$('input[name=mem_hp3]').val());

			$("input[name=mem_bir]").val($('input[name=mem_bir1]').val()
	        +"-"+$('input[name=mem_bir2]').val()+"-"+$('input[name=mem_bir3]').val());
			
			$("input[name=mem_zip]").val($('input[name=mem_zip1]').val()+"-"+$('input[name=mem_zip2]').val());
			return true;
		});
		
		$('#btn3').click(function(){
	         location.href = '${pageContext.request.contextPath }/user/member/memberDropout.do?mem_id=${memberInfo.mem_id}';
		});
		
	});
	
</script>

</head>
<style>
.fieldName {text-align: center; background-color: #f4f4f4;}
.tLine {background-color: #d2d2d2; height: 1px;}
.btnGroup { text-align: right; }
td {text-align: left; }
</style>
<body>
<form name="memberForm" action="" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
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
				<input type="text" name="mem_bir1" size="4" value="" disabled="disabled"/>년
				<input type="text" name="mem_bir2" size="2" value="" disabled="disabled"/>월
				<input type="text" name="mem_bir3" size="2" value="" disabled="disabled"/>일
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">아이디</td>
		<td>
			<input type="text" name="mem_id" value="${memberInfo.mem_id }" disabled="disabled">
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">비밀번호</td>
		<td>
			<input type="text" name="mem_pass" value="${memberInfo.mem_pass }" /> 8 ~ 20 자리 영문자 및 숫자 사용
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">비밀번호확인</td>
		<td>
			<input type="text" name="mem_pass_confirm" value="${memberInfo.mem_pass }" /> 8 ~ 20 자리 영문자 및 숫자 사용
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
			<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent">우편번호검색</button><br>
			
			<input type="text" name="mem_add1" id="mem_add1" value="${memberInfo.mem_add1 }" />
			<input type="text" name="mem_add2" id="mem_add2" value="${memberInfo.mem_add2 }" />
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr><td colspan="2" height="20"></td></tr>
	
	<tr>
		<td class="btnGroup" colspan="2" >
			<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn1" type="submit">수정하기</button>
			<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn2" type="reset">취소</button>
			<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn3" type="button">탈퇴신청</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>








