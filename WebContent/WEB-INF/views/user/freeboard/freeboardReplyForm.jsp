<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 댓글등록</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/validation.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.7.1/summernote.js"></script>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.7.1/summernote.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script>
$(function(){
    $('#bo_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
    $('#bo_writer').val("${LOGIN_MEMBERINFO.mem_id}");
    $('#bo_mail').val("${LOGIN_MEMBERINFO.mem_mail}");
	
	$('form[name=replyform]').submit(function(){
		$(this).attr("action", "${pageContext.request.contextPath }/user/freeboard/insertBoardReply.do");
		$(this).append('<input type="hidden" name="bo_no" value="${boardInfo.bo_no}"/>');
      	$(this).append('<input type="hidden" name="bo_group" value="${param.bo_group}"/>');
      	$(this).append('<input type="hidden" name="bo_seq" value="${param.bo_seq}"/>');
      	$(this).append('<input type="hidden" name="bo_depth" value="${param.bo_depth}"/>');
      	$(this).append('<input type="hidden" name="bo_writer" value="${LOGIN_MEMBERINFO.mem_id}"/>');
      	$(this).append('<input type="hidden" name="bo_content" value=""/>');
      	$('input[name=bo_content]').val($('.panel-body').html());
      	
      	if(!$('input[name=bo_title]').val().validationBOARD()) {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '제목을 입력하세요.'
		 	});
			return false;
		}
		
		if(!$('input[name=bo_writer]').val().validationBOARD()) {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '대화명을 입력하세요.'
		 	});
			return false;
		}
		
		if(!$('input[name=bo_mail]').val().validationBUYMail()) {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '올바르지 않은 메일 형식입니다.'
		 	});
			return false;
		}
      	return true;
	});
    
    $('#listButton').click(function() {
    	location.href = '${pageContext.request.contextPath }/user/freeboard/freeboardList.do';
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
    	<p class="form-control-static">${param.title }</p>
	 </div>
	 <div class="col-sm-1">
	 	<p class="text-right text-danger bg-danger">${LOGIN_MEMBERINFO.mem_name} (${LOGIN_MEMBERINFO.mem_id})의 댓글</p>
	 </div>
</div>
<hr />
<form class="form-horizontal" name="replyform" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="bo_title" name="bo_title" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_writer">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="bo_writer" name="bo_writer"  disabled="disabled">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="bo_mail" name="bo_mail" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="bo_content"><p></p></div>
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-success" style="float: right;">답글등록</button>
			<button type="button" class="btn btn-danger">취소</button>
			<button type="button" class="btn btn-info" id="listButton">목록</button>
		</div>
	</div>
</form>
</body>
</html>