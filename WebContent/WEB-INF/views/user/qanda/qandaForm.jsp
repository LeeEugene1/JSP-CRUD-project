<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 등록</title>

<script type='text/javascript'>
$(function(){
    $('#qa_content').summernote({
    		lang: 'ko-KR',
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
    $('#qa_writer').val("${LOGIN_MEMBERINFO.mem_id}");
    $('#qa_mail').val("${LOGIN_MEMBERINFO.mem_mail}");

    $('form').submit(function(){
        $(this).attr("action", "${pageContext.request.contextPath }/user/qanda/qandaInsert.do");
        $(this).append('<input type="hidden" name="qa_writer" value="${LOGIN_ADMININFO.mem_id}"/>');
        $(this).append('<input type="hidden" name="qa_mail" value="${LOGIN_ADMININFO.mem_mail}"/>');
        $(this).append('<input type="hidden" name="qa_no" value="${qandaInfo.qa_no}"/>');
        $(this).append('<input type="hidden" name="qa_content" value=""/>');
        $('input[name=qa_content]').val($('.panel-body').html());
        
        if(!$('input[name=qa_title]').val().validationBOARD()) {
			alert('제목을 입력하세요');
			return false;
		}
        return true;
    });
});
</script>
</head>
<body>
<form class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="qa_title" name="qa_title" placeholder="제목 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_writer">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="qa_writer" name="qa_writer" placeholder="대화명 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="qa_mail" name="qa_mail" placeholder="메일주소 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="qa_content"></div>
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-info" style="float: right">등록</button>
			<button type="reset" class="btn btn-danger" style="float: right">취소</button>
			<button type="button" class="btn btn-primary" style="float: right;"><a href="${ pageContext.request.contextPath}/user/qanda/qandaList.do" style="color:white">목록</a></button>
		</div>
	</div>
</form>
</body>
</html>