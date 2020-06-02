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
		$('form[name=memberForm]').submit(function(){
			$(this).attr("action", "${pageContext.request.contextPath}/user/member/outMember.do");
			$(this).append('<input type="hidden" name="mem_id" value="${memberInfo.mem_id}"/>');
			$("input[name=mem_dropout]").val($('select[name=mem_dropout]').val());
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
                    <div class="col-lg-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">탈퇴안내</div>
                            <div class="panel-body">
	                            <p>회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.</p>
	                            <p>사용하고 계신 아이디 <b>${memberInfo.mem_id }</b>는 탈퇴할 경우 재사용 및 복구가 불가능합니다.</p>
								탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가하오니 신중하게 선택하시기 바랍니다.<h3>탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</h3>
								회원정보 및, 주소록 등 개인형 서비스 이용기록은 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.
								삭제되는 내용을 확인하시고 필요한 데이터는 미리 백업을 해주세요.<p>
								
								<h3>탈퇴 후에도 게시판형 서비스에 등록한 게시물은 그대로 남아 있습니다.</h3>
								<p>각 게시판들의 게시글 및 댓글은 탈퇴 시 자동 삭제되지 않고 그대로 남아 있습니다.
								삭제를 원하는 게시글이 있다면 반드시 탈퇴 전 비공개 처리하거나 삭제하시기 바랍니다.
								탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어, 게시글을 임의로 삭제해드릴 수 없습니다.
								</p>
                                <input type="checkbox" id="dropoutAgree" name="dropoutAgree" onclick="clickcr(this,'otn.guideagree','','',event);" >
                                <label for="dropoutAgree"><strong>안내 사항을 모두 확인하였으며, 이에 동의합니다.</strong></label>
                                
                                <form name="memberForm" action="" method="post">
								<input type="hidden" name="mem_dropout"/>
									<select name="mem_dropout">
										<option value="탈퇴사유">탈퇴사유를 선택해주세요</option>
										<option value="회원간의트러블">회원간의 트러블</option>				        	
										<option value="변화가없는사이트">변화가 없는 사이트</option>				        	
										<option value="이용빈도낮음">이용빈도 낮음</option>				        	
										<option value="혜택부족">혜택 부족</option>				        	
										<option value="기타">기타</option>				        	
									</select>
								<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn3" type="submit">확인</button>
								</form>
								
                            </div>
                        </div>
		</div>
		</body>
	<hr />
</html>








