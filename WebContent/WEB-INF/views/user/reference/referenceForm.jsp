<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 등록</title>

<script type="text/javascript">

$(function(){
    $('#re_content').summernote({
    		lang: 'ko-KR',
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
    $('#re_writer').val("${LOGIN_MEMBERINFO.mem_id}");
    $('#re_mail').val("${LOGIN_MEMBERINFO.mem_mail}");

	$('form[name=re_form]').submit(function(){
		$(this).attr("action", "${pageContext.request.contextPath }/user/reference/insertReference.do");
		$(this).append('<input type="hidden" name="re_no" value="${referenceInfo.re_no}" />');
		$(this).append('<input type="hidden" name="re_writer" value="${LOGIN_MEMBERINFO.mem_id}"/>');
		$(this).append('<input type="hidden" name="re_content" value=""/>');
      	$('input[name=re_content]').val($('.panel-body').html());
      	
      	if(!$('input[name=re_title]').val().validationBOARD()) {
      		BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '제목을 입력해주세요.'
		 	});
			return false;
		}
      	
      	if(!$('input[name=re_content]').val().validationBOARD()) {
      		BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '내용을 입력해주세요.'
		 	});
			return false;
		}
      	
      	return true;
      	
	});
	
	$('#list').click(function(){
		location.href = "${pageContext.request.contextPath }/user/reference/referenceList.do";
	});

});
</script>
</head>
<body>
<form class="form-horizontal" role="form" action="" method="post" enctype="multipart/form-data" name="re_form">
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="re_title" name="re_title" placeholder="제목 입력...">
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
			<input type="text" class="form-control" id="re_mail" name="re_mail" placeholder="메일주소 입력..." >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="re_content"></div>
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
			<button type="button" class="btn btn-danger" style="float: right">취소</button>
			<button type="button" class="btn btn-primary" style="float: right" id="list">목록</button>
		</div>
	</div>
</form>
</body>
</html>