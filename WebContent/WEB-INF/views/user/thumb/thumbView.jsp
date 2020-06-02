<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>썸네일 정보</title>
<style type="text/css">
.carousel{
	width:200px;
    height:150px;
    margin-left: 200px;
}
.carousel-inner > .item > img{
    width:300px;
    height:150px;
}       
</style>
<script>
$(function(){
	$('#im_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
	$('#im_content').summernote('code', '<font color ="black">${thumbInfo.im_content}</font>');
 		$('input[name=im_writer]').val('${thumbInfo.im_writer}');
 		$('input[name=im_mail]').val('${LOGIN_MEMBERINFO.mem_mail}');
		$('#im_content').summernote('disable');
	
	$('#revise').click(function(){
		if('${LOGIN_MEMBERINFO.mem_id}' == '${thumbInfo.im_writer}') {
			var im_no = "${thumbInfo.im_no}";
			location.href = '${pageContext.request.contextPath}/user/thumb/thumbViewUpdate.do?im_no='+im_no;
		} else {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '자신이 작성한 글만 수정이 가능합니다.'
		 	});
		}
	});
	
	$('#delete').click(function(){
		if('${LOGIN_MEMBERINFO.mem_id}' == '${thumbInfo.im_writer}'){
			var im_no = "${thumbInfo.im_no}";
			location.href='${pageContext.request.contextPath}/user/thumb/deleteThumb.do?im_no='+ im_no;
		}else{
			BootstrapDialog.show({
				title:'alert',
				message:'자신이 작성한 글만 삭제가 가능합니다.'
			});
		}
	});
	
	$('#reply').click(function() {
		if(eval('${!empty LOGIN_MEMBERINFO}')) {
			var title = encodeURIComponent('${thumbInfo.im_title}');
			var params = 'rnum=${param.rnum}&im_group=${thumbInfo.im_group}&im_seq=${thumbInfo.im_seq}&im_depth=${thumbInfo.im_depth}&title=' + title;
			location.href = '${pageContext.request.contextPath }/user/thumb/thumbReplyForm.do?' + params;
		}else {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '로그인 후 글을 작성해주세요.'
		 	});
			return;
		}
	});
	
});
</script>
</head>
<body>
<form name="thumbForm" class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="im_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="im_title" name="im_title"  value="${thumbInfo.im_title }" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="im_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="im_nickname" name="im_writer" value="${thumbInfo.im_writer }" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="im_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="im_mail" name="im_mail" disabled="disabled">
	</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="im_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="im_content"><p></p></div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="im_content">첨부파일:</label>
		<div class="col-sm-10">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
			
			<div class="carousel-inner" role="listbox" style=" height: 200px;">
			<c:forEach items="${thumbInfo.items }" var="fileitem" varStatus="stat">
				<c:if test="${stat.first }">
					<div class="item active">
				</c:if>
				<c:if test="${stat.last }">
					<div class="item">
				</c:if>
					<img src="/files/${fileitem.file_save_name }" alt="pic1"
						onclick="javascript:location.href='${pageContext.request.contextPath }/user/freeboard/fileDownload.do?fileSEQ=${fileitem.file_seq}';">
				</div>
				</c:forEach>
			</div>
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
		</div>
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10"  style="padding:100px 60px;">
			<button type="button" class="btn btn-danger" id="delete">삭제</button>
			<button type="button" class="btn btn-info">
				<a href="${pageContext.request.contextPath }/user/thumb/thumbList.do">목록</a></button>
			<button type="button" class="btn btn-default" id="revise" style="float: right">수정</button>
		</div>
	</div>
</form>
</body>
</html>