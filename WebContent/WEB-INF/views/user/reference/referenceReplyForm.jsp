<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 댓글등록</title>
<script>
$(function(){
    $('#re_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
	$('#re_writer').val("${LOGIN_MEMBERINFO.mem_id}");
	$('#re_mail').val("${LOGIN_MEMBERINFO.mem_mail}");
	
	$('form[name=replyform]').submit(function(){
		$(this).attr("action", "${pageContext.request.contextPath }/user/reference/insertReferenceReply.do");
		$(this).append('<input type="hidden" name="re_no" value="${referenceInfo.re_no}"/>');
      	$(this).append('<input type="hidden" name="re_group" value="${param.re_group}"/>');
      	$(this).append('<input type="hidden" name="re_seq" value="${param.re_seq}"/>');
      	$(this).append('<input type="hidden" name="re_depth" value="${param.re_depth}"/>');
      	$(this).append('<input type="hidden" name="re_writer" value="${LOGIN_MEMBERINFO.mem_id}"/>');
      	$(this).append('<input type="hidden" name="re_content" value=""/>');
      	$('input[name=re_content]').val($('.panel-body').html());
      	
      	if(!$('input[name=re_title]').val().validationBOARD()) {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '제목을 입력하세요.'
		 	});
			return false;
		}
		
		if(!$('input[name=re_writer]').val().validationBOARD()) {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '대화명을 입력하세요.'
		 	});
			return false;
		}
		
		if(!$('input[name=re_mail]').val().validationBUYMail()) {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '올바르지 않은 메일 형식입니다.'
		 	});
			return false;
		}
      	return true;
	});
    
    $('#listButton').click(function() {
    	location.href = '${pageContext.request.contextPath }/user/reference/referenceList.do';
    });
});
</script>
</head>
<body>
<div class="row">
	 <div class="col-sm-3">
		 <label class="col-sm-2 control-label">No :</label>
  		 <p class="form-control-static">${param.rnum }</p>
	 </div>
	 <div class="col-sm-8">
	 	<label class="col-sm-2 control-label">제목 :</label>
    	<p class="form-control-static">${param.title}</p>
	 </div>
	 <div class="col-sm-1">
	 	<p class="text-right text-danger bg-danger">${LOGIN_MEMBERINFO.mem_name} (${LOGIN_MEMBERINFO.mem_id})의 댓글</p>
	 </div>
</div>
<hr />
<form class="form-horizontal" name="replyform" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="re_title" name="re_title" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_writer">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="re_writer" name="re_writer" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="re_mail" name="re_mail" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="re_content"><p></p></div>
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-success" style="float: right;">댓글등록</button>
			<button type="button" class="btn btn-danger">취소</button>
			<button type="button" class="btn btn-info" id="listButton">목록</button>
		</div>
	</div>
</form>
</body>
</html>