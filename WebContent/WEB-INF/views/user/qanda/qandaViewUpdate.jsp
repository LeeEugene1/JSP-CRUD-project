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
 		$('input[name=qa_writer]').val('${qandaInfo.qa_writer}');
 		$('input[name=qa_mail]').val('${LOGIN_MEMBERINFO.mem_mail}');
 		$('input[name=qa_content]').val('${qandaInfo.qa_content}');
	
 	$('form').submit(function(){
		$(this).attr("action", "${pageContext.request.contextPath}/user/qanda/qandaUpdate.do?qa_no=${qandaInfo.qa_no}");
        $(this).append('<input type="hidden" name="qa_content" value=""/>');
		$('input[name=qa_content]').val($('.panel-body').html());
 	});
 	
	$('#list').click(function(){
		location.href ="${pageContext.request.contextPath }/user/qanda/qandaList.do";
	});
});
</script>
</head>
<body>
<form name="Form" class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="qa_title" name="qa_title"  value="${qandaInfo.qa_title }">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_writer">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="qa_writer" name="qa_writer" disabled="disabled" value="${qandaInfo.qa_writer }">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="qa_mail" name="qa_mail">
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
			<button type="submit" class="btn btn-default" style="float: right">수정</button>
			<button type="button" id="list" class="btn btn-default" style="float: right">목록</button>
		</div>
	</div>
</form>
</body>
</html>