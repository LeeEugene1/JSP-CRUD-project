<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 정보</title>
<style type="text/css">
.carousel{
	width:200px;
    height:150px;
    margin-left: 200px;
}
.carousel-inner > .item > img{
    width:200px;
    height:150px;
}       
</style>
<script>
$(function(){
	$('#qa_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
	$('#qa_content').summernote('code', '<font color ="black">${qandaInfo.qa_content}</font>');
 		$('input[name=qa_mail]').val('${LOGIN_MEMBERINFO.mem_mail}');
 		$('input[name=qa_content]').val('${qandaInfo.qa_content}');
		$('#qa_content').summernote('disable');
	
	$('#result1').click(function(){
		if('${LOGIN_MEMBERINFO.mem_id}' == '${qandaInfo.qa_writer}') {
			var qa_no = "${qandaInfo.qa_no}";
			location.href = '${pageContext.request.contextPath}/user/qanda/qandaViewUpdate.do?qa_no='+qa_no;
		} else {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '자신이 작성한 글만 수정이 가능합니다.'
		 	});
		}
	});
	
	$('#delete').click(function(){
		if('${LOGIN_MEMBERINFO.mem_id}' == '${qandaInfo.qa_writer}') {
			var qa_no = "${qandaInfo.qa_no}";
			location.href ='${pageContext.request.contextPath}/user/qanda/deleteQanda.do?qa_no=' + qa_no;
		} else {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '자신이 작성한 글만 삭제가 가능합니다.'
		 	});
		}
	});
	
	$('#list').click(function(){
		location.href ="${pageContext.request.contextPath }/user/qanda/qandaList.do";
	});
});
</script>
</head>
<body>
<form name="freeboardForm" class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="qa_title" name="qa_title"  value="${qandaInfo.qa_title }" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_writer">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="qa_writer" name="qa_writer" value="${qandaInfo.qa_writer }" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
			<label class="control-label col-sm-2" for="qa_mail">메일:</label>
			<div class="col-sm-10"> 
			<input type="text" class="form-control" id="qa_mail" name="qa_mail" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="qa_content"><p></p></div>
		</div>
	</div>

	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" id="delete" class="btn btn-danger">삭제</button>
			<button type="button" id="list" class="btn btn-info"><a href="${pageContext.request.contextPath }/user/qanda/qandaList.do">목록</a></button>
			<button type="button" id="result1" class="btn btn-default" style="float: right">수정</button>
		</div>
	</div>
</form>
</body>
</html>