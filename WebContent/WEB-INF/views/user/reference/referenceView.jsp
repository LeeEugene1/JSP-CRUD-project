<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 정보</title>
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
    $('#re_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
    $('#re_content').summernote('code', '<font color ="black" >${referenceInfo.re_content}</font> ');
	$('input[name=re_mail]').val('${LOGIN_MEMBERINFO.mem_mail}');
	$('input[name=re_writer]').val('${referenceInfo.re_writer}');
	$('input[name=re_content]').val('${referenceInfo.re_content}');
    $('#re_content').summernote('disable');
    
    $('#revise').click(function(){
    	alert('hi1');
		if('${LOGIN_MEMBERINFO.mem_id}' == '${referenceInfo.re_writer}') {
			alert('hi2');
			var re_no = "${referenceInfo.re_no}";
			location.href = '${pageContext.request.contextPath}/user/reference/referenceViewUpdate.do?re_no='+re_no;
		} else {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '자신이 작성한 글만 수정이 가능합니다.'
		 	});
		}
    });
    
    $("#update1").click(function(){
    	if('${LOGIN_MEMBERINFO.mem_id}' == '${referenceInfo.re_writer}') {
	    	var re_no =  "${referenceInfo.re_no } ";
	    	location.href = '${pageContext.request.contextPath }/user/reference/referenceForm.do&re_no='+ re_no;
    	} else {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '자기가 쓴 글만 수정이 가능합니다.'
		 	});
			return;
		}
    });
    
	$('#reply').click(function() {
		if(eval('${!empty LOGIN_MEMBERINFO}')) {
			var title = encodeURIComponent('${referenceInfo.re_title}');
			var params = 'rnum=${param.rnum}&re_group=${referenceInfo.re_group}&re_seq=${referenceInfo.re_seq}&re_depth=${referenceInfo.re_depth}&title=' + title;
			location.href = '${pageContext.request.contextPath }/user/reference/referenceReplyForm.do?' + params;
		} else {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '로그인 후 글을 작성해주세요.'
		 	});
			return;
		}
	});
	
	$('#delete').click(function(){
		if('${LOGIN_MEMBERINFO.mem_id}' == '${referenceInfo.re_writer}'){
		var re_no = "${referenceInfo.re_no}";
		location.href ='${pageContext.request.contextPath}/user/reference/deleteReference.do?re_no=' + re_no;			
		}else{
			BootstrapDialog.show({
				title:'alert',
				message:'자신이 작성한 글만 삭제가 가능합니다.'
			});
		}
	});
});
</script>
</head>
<body>
<form name="updateForm" class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="re_title" name="re_title"  value="${referenceInfo.re_title } " disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="re_writer" name="re_writer" value="${referenceInfo.re_writer }" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="re_mail" name="re_mail" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="re_content" ><p></p></div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_content">첨부파일:</label>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
	
			<div class="carousel-inner" role="listbox" style="height: 200px;">
			<c:forEach items="${referenceInfo.items }" var="fileitem" varStatus="stat">
				<c:if test="${stat.first }">
					<div class="item active">
				</c:if>
				<c:if test="${stat.last }">
					<div class="item">
				</c:if>
					<img src="/files/${fileitem.file_save_name }" alt="pic1"
						onclick="javascript:location.href='${pageContext.request.contextPath }/file/fileDownload.do?fileName=${fileitem.file_name}';">		
					</div>
				</c:forEach>
			</div>

			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-success">
				<a href="${pageContext.request.contextPath }/user/freeboard/referenceForm.do">글쓰기</a></button>
			<button type="button" id="delete" class="btn btn-danger">삭제</button>
			<button type="button" class="btn btn-primary" id="reply">댓글</button>
			<button type="button" class="btn btn-info"><a href="${pageContext.request.contextPath }/user/reference/referenceList.do">목록</a></button>
			<button type="button" class="btn btn-default" id="revise" style="float: right">수정</button>
		</div>
	</div>
</form>
</body>
</html>