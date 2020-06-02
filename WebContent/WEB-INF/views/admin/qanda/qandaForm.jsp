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
    
    $('form').submit(function(){
        $(this).attr("action", "${pageContext.request.contextPath }/admin/qanda/qandaInsert.do");
		$(this).append('<input type="hidden" name="qa_no" value="${boardInfo.qa_no}"/>');
      	$(this).append('<input type="hidden" name="qa_group" value="${param.qa_group}"/>');
      	$(this).append('<input type="hidden" name="qa_seq" value="${param.qa_seq}"/>');
      	$(this).append('<input type="hidden" name="qa_depth" value="${param.qa_depth}"/>');
      	$(this).append('<input type="hidden" name="qa_writer" value="${LOGIN_ADMININFO.admin_id}"/>');
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
	<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="qandaMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<form class="form-horizontal" role="form" action="" method="post">
					<div class="form-group">
						<label class="control-label col-sm-2" for="qa_title">제목:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="qa_title" name="qa_title" placeholder="제목 입력...">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="qa_writer">작성자:</label>
						<div class="col-sm-10"> 
							<input type="text" class="form-control" id="qa_writer" name="qa_writer" placeholder="작성자" value="admin" disabled="disabled" >
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="qa_content">내용:</label>
						<div class="col-sm-10"> 
							<div id="qa_content">내용을 입력해주세요...</div>
						</div>
					</div>
					<div class="form-group"> 
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-info" style="float: right">등록</button>
							<button type="button" class="btn btn-danger" style="float: right">취소</button>
							<button type="button" class="btn btn-primary" style="float: right">목록</button>
						</div>
					</div>
				</form>
			</td>
		</tr>
	</table>
</div>
</form>
</body>
</html>