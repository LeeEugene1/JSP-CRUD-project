<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    width:300px;
    height:150px;
}       
</style>
<script>
$(function(){
	$('#bo_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
	$('#bo_content').summernote('code', '<font color ="black">${boardInfo.bo_content}</font>');
	$('input[name=bo_writer]').val('${boardInfo.bo_writer}');
	$('input[name=bo_mail]').val('${LOGIN_MEMBERINFO.mem_mail}');
	$('#bo_content').summernote('disable');
	
	$('#revise').click(function(){
		if('${LOGIN_MEMBERINFO.mem_id}' == '${boardInfo.bo_writer}') {
			var bo_no = "${boardInfo.bo_no}";
			location.href = '${pageContext.request.contextPath}/user/freeboard/freeboardViewUpdate.do?bo_no='+bo_no;
		} else {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '자신이 작성한 글만 수정이 가능합니다.'
		 	});
		}
	});
	
	$('#delete').click(function(){
		if('${LOGIN_MEMBERINFO.mem_id}' == '${boardInfo.bo_writer}'){
			var bo_no = "${boardInfo.bo_no}";
			location.href='${pageContext.request.contextPath}/user/freeboard/deleteBoard.do?bo_no='+ bo_no;
		}else{
			BootstrapDialog.show({
				title:'alert',
				message:'자신이 작성한 글만 삭제가 가능합니다.'
			});
		}
	});
	
	$('#reply').click(function() {
		if(eval('${!empty LOGIN_MEMBERINFO}')) {
			var title = encodeURIComponent('${boardInfo.bo_title}');
			var params = 'rnum=${param.rnum}&bo_group=${boardInfo.bo_group}&bo_seq=${boardInfo.bo_seq}&bo_depth=${boardInfo.bo_depth}&title=' + title;
			location.href = '${pageContext.request.contextPath }/user/freeboard/freeboardReplyForm.do?' + params;
		}else {
			BootstrapDialog.show({
		 	    title: 'alert',
		 	    message: '로그인 후 글을 작성해주세요.'
		 	});
			return;
		}
	});
	
	$('#list').click(function(){
		var search_keyword = '${search_keyword}';
		var search_keycode = '${search_keycode}';
		location.href='${pageContext.request.contextPath}/user/freeboard/freeboardList.do?search_keyword='+search_keyword+'&search_keycode='+search_keycode;
	});
});
</script>
</head>
<body>
<form name="freeboardForm" class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="bo_title" name="bo_title"  value="${boardInfo.bo_title }" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="bo_nickname" name="bo_writer" value="${boardInfo.bo_writer }" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="bo_mail" name="bo_mail" disabled="disabled">
	</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="bo_content"><p></p></div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_content">첨부파일:</label>
		<div class="col-sm-10">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
			
			<div class="carousel-inner" role="listbox" style=" height: 200px;">
			<c:forEach items="${boardInfo.items }" var="fileitem" varStatus="stat">
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
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10"  style="padding:100px 60px;">
			<button type="button" class="btn btn-success">
				<a href="${pageContext.request.contextPath }/user/freeboard/freeboardForm.do">글쓰기</a></button>
			<button type="button" class="btn btn-danger" id="delete">삭제</button>
			<button type="button" class="btn btn-primary" id="reply">댓글</button>
			<button type="button" id="list" class="btn btn-info">목록</button>
			<button type="button" class="btn btn-default" id="revise" style="float: right">수정</button>
		</div>
	</div>
</form>
</body>
</html>