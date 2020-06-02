<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록</title>
<script type='text/javascript'>
$(function(){
    $('#no_content').summernote({
    		lang: 'ko-KR',
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
    $('form').submit(function(){
        $(this).attr("action", "${pageContext.request.contextPath }/admin/notice/insertNotice.do");
        $(this).append('<input type="hidden" name="no_writer" value="${LOGIN_ADMININFO.admin_id}"/>');
        $(this).append('<input type="hidden" name="no_no" value="${noticeInfo.no_no}"/>');
        $(this).append('<input type="hidden" name="no_content" value=""/>');
        $('input[name=no_content]').val($('.panel-body').html());
        
      	if(!$('input[name=no_title]').val().validationBOARD()) {
      		BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '제목을 입력해주세요.'
		 	});
			return false;
		}
        
      	if(!$('input[name=no_content]').val().validationBOARD()) {
      		BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '내용을 입력해주세요.'
		 	});
			return false;
		}
      	
      	return true;
        
    });
});
</script>
</head>
<body>

<form class="form-horizontal" role="form" action="" method="post" enctype="multipart/form-data">
	<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="noticeMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<form class="form-horizontal" role="form" action="" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label class="control-label col-sm-2" for="no_title">제목:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="no_title" name="no_title" placeholder="제목 입력...">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="no_writer">작성자:</label>
						<div class="col-sm-10"> 
							<input type="text" class="form-control" id="no_writer" name="no_writer" placeholder="관리자" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="no_content">내용:</label>
						<div class="col-sm-10"> 
							<div id="no_content"></div>
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
							<button type="button" class="btn btn-primary" style="float: right"><a href="${pageContext.request.contextPath }/admin/notice/noticeList.do">목록</a></button>
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