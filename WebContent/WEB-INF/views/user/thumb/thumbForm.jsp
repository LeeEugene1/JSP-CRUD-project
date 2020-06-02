<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>썸네일 등록</title>

<script type="text/javascript">
$(function(){
    $('#im_content').summernote({
    		lang: 'ko-KR',
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
    $('#im_writer').val("${LOGIN_MEMBERINFO.mem_id}");
    $('#im_mail').val("${LOGIN_MEMBERINFO.mem_mail}");

	$('form[name=im_form]').submit(function(){
		$(this).attr("action", "${pageContext.request.contextPath }/user/thumb/thumbInsert.do");
		$(this).append('<input type="hidden" name="im_no" value="${boardInfo.im_no}" />');
		$(this).append('<input type="hidden" name="im_content" value=""/>');
      	$('input[name=im_content]').val($('.panel-body').html());
      	
      	if(!$('input[name=im_title]').val().validationBOARD()) {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '제목을 입력하세요.'
		 	});
			return false;
		}
		
		if(!$('input[name=im_writer]').val().validationBOARD()) {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '대화명을 입력하세요.'
		 	});
			return false;
		}
		
		if(!$('input[name=im_mail]').val().validationBUYMail()) {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '올바르지 않은 메일 형식입니다.'
		 	});
			return false;
		}
      	
      	$('input[type=file]').each(function(idx, targetTag){
			if(!/\.(jpg|jpeg|gif|png)/.test($(targetTag).val().toLowerCase())) {
				BootstrapDialog.show({
			 	    title: 'alert',
			 	    message: '이미지 파일만 업로드할 수 있습니다.'
			 	});
				return false;
			}
		});
      	return true;
	});
	
	$('#list').click(function(){
		location.href = "${pageContext.request.contextPath }/user/thumb/thumbList.do";
	});

});
</script>
</head>
<body>
<form class="form-horizontal" role="form" action="" method="post" enctype="multipart/form-data" name="im_form">
	<div class="form-group">
		<label class="control-label col-sm-2" for="im_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="im_title" name="im_title" placeholder="제목 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="im_writer">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="im_writer" name="im_writer" placeholder="대화명 입력..." disabled="disabled">
		</div>
	</div>
		<div class="form-group">
		<label class="control-label col-sm-2" for="im_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="im_mail" name="im_mail" placeholder="메일주소 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="im_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="im_content"></div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="file01">첨부파일1:</label>
		<div class="col-sm-10">
			 <input type="file" class="filestyle" id="file01" name="files" data-buttonName="btn-primary">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="file02">첨부파일2:</label>
		<div class="col-sm-10">
			 <input type="file" class="filestyle" id="file02" name="files" data-buttonName="btn-primary">
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-info" style="float: right">등록</button>
			<button type="reset" class="btn btn-danger" style="float: right">취소</button>
			<button type="button" class="btn btn-primary" style="float: right" id="list">목록</button>
		</div>
	</div>
</form>
</body>
</html>