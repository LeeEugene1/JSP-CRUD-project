<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원상세정보</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$('input[name=mem_pass]').val('${memberInfo.mem_pass }');
		$('input[name=mem_pass_confirm]').val('${memberInfo.mem_pass }');
		$('input[name=mem_mail1]').val('${memberInfo.mem_mail.split("@")[0] }');
		$('input[name=mem_mail2]').val('${memberInfo.mem_mail.split("@")[1] }');
		
		// 연락처
		var ph = '${memberInfo.mem_hp}'.split("-");
		$('select[name=mem_hp1] option').each(function() {
			if($(this).val() == ph[0]) {
				$(this).attr("selected", "selected");
			}
		});
		$('input[name=mem_hp2]').val(ph[1]);
		$('input[name=mem_hp3]').val(ph[2]);
		
		// 생년월일
		var bir = '${memberInfo.mem_bir}'.split(" ")[0].split("-");
		$('input[name=mem_bir1]').val(bir[0]);
		$('input[name=mem_bir2]').val(bir[1]);
		$('input[name=mem_bir3]').val(bir[2]);
		
		// 주소
		$('input[name=mem_add1]').val('${memberInfo.mem_add1 }');
		$('input[name=mem_add2]').val('${memberInfo.mem_add2 }');
		
		$('form').submit(function(){
			$(this).attr("action", "${pageContext.request.contextPath}/admin/member/updateMember.do?mem_id=${memberInfo.mem_id}");
			$("input[name=mem_name]").val($('input[name=mem_name]').val());
			$("input[name=mem_mail]").val($('input[name=mem_mail1]').val()
				     +"@"+$('input[name=mem_mail2]').val());
			$("input[name=mem_hp]").val($('select[name=mem_hp1]').val()+"-"+$('input[name=mem_hp2]').val()+"-"+$('input[name=mem_hp3]').val());
			$("input[name=mem_bir]").val($('input[name=mem_bir1]').val()
			        +$('input[name=mem_bir2]').val()+$('input[name=mem_bir3]').val());

		});
		
		$('#check_delete').click(function(){
			location.href = "${pageContext.request.contextPath }/admin/member/deleteMember.do?mem_id=${memberInfo.mem_id }";
		});
	});
</script>
</head>
<body>
<div class="wrap">	
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="memberMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790">
				<div id="container">
					<div class="title">회원정보</div>
					<form method="post" name="updateMemberForm">
						<table border="0" cellspacing="1" cellpadding="1">
							<tr>
								<th><span class="r">*</span>이름</th>
									<td><input name="mem_name" type="text" id="mem_name" size="20" value="${memberInfo.mem_name }"/></td>
							</tr>
							<tr>
								<th><span class="r">*</span>아이디</th>
								<td><label class="mem_id"></label>${memberInfo.mem_id }</td>
							</tr>
							<tr>
								<th><span class="r">*</span>비밀번호</th>
								<td><input name="mem_pass" type="text" id="mem_pass" size="20" value="${memberInfo.mem_pass }"/></td>
							</tr>
							<tr>
								<th><span class="r">*</span>비밀번호 확인</th>
								<td><input name="mem_pass_confirm" type="text" id="mem_pass_confirm" size="20" value="${memberInfo.mem_pass }"/></td>
							</tr>
							<tr>
								<th>이메일 주소</th>
								<td>
									<input type="hidden" name="mem_mail"/>
									<input name="mem_mail1" type="text" id="mem_mail1" size="20"/> @
									<input name="mem_mail2" type="text" id="mem_mail2" size="20" /> 
								</td>
							</tr>
							<tr>
								<th>거주지</th>
								<td>
									<input type="hidden" name="mem_add"/>
									<input name="mem_add1" type="text" id="mem_add2" size="30" value="${memberInfo.mem_add1 }"/>
									<input name="mem_add2" type="text" id="mem_add2" size="30" value="${memberInfo.mem_add2 }" />
								</td>
							</tr>
							<tr>
								<th>연락처</th>
								<input type="hidden" name="mem_hp"/>
								<td><select style="width: 100px;" name="mem_hp1">
										<option selected="selected">선택하세요</option>
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="018">019</option>
									</select> - 
									<input name="mem_hp2" type="text" id="mem_hp2" size="20" /> - 
									<input name="mem_hp3" type="text" id="mem_hp3" size="20" />
								</td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td>
									<input type="hidden" name="mem_bir"/>
									<input name="mem_bir1" type="text" id="mem_bir1" size="10" /> 년
									<input name="mem_bir2" type="text" id="mem_bir2" size="10" /> 월
									<input name="mem_bir3" type="text" id="mem_bir3" size="10" /> 일
								</td>
							</tr>
							<tr>
								<th>삭제요청여부</th>
								<td><label class="mem_delete_check">${memberInfo.mem_delete_check }</label></td>
							</tr>
						</table>
						<div style="float: right;">
							<input class="btn1" type="submit" value="변경내용 저장" id="updateMember"/>
							<input class="btn2" type="button" value="삭제처리" id="check_delete"/>
							<input class="btn3" type="reset" value="취소" />
						</div>
					</form>
				</div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>