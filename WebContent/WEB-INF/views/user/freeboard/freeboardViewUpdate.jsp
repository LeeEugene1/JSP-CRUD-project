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
    $('#bo_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
	$('#bo_content').summernote('code', '<font color ="black">${boardInfo.bo_content}</font>');
 		$('input[name=bo_writer]').val('${boardInfo.bo_writer}');
 		$('input[name=bo_mail]').val('${LOGIN_MEMBERINFO.mem_mail}');

	$('input[name=bo_title]').val('${boardInfo.bo_title}');
	$('input[name=bo_content]').val('${boardInfo.bo_content}');
	
	$('form').submit(function(){
		$(this).attr("action", "${pageContext.request.contextPath}/user/freeboard/freeboardUpdate.do?bo_no=${boardInfo.bo_no}");
        $(this).append('<input type="hidden" name="bo_content" value=""/>');
		$('input[name=bo_content]').val($('.panel-body').html());
	});
	$('#delete').click(function(){
		var bo_no = "${boardInfo.bo_no}";
		location.href='${pageContext.request.contextPath}/user/freeboard/deleteBoard.do?bo_no='+ bo_no;
	});
});
</script>
</head>
<body>
<form name = "update" class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="bo_title" name="bo_title"  value="${boardInfo.bo_title }">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="bo_nickname" name="bo_writer" value="${boardInfo.bo_writer }">
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
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
	
			<div class="carousel-inner" role="listbox" style="height: 200px;">
				<div class="item active">
					<img src="./images/thumbs/arch-1.jpg" alt="pic1">
				</div>
		
				<div class="item">
					<img src="./images/thumbs/arch-2.jpg" alt="pic2">
				</div>
		
				<div class="item">
					<img src="./images/thumbs/autumn-1.jpg" alt="pic3">
				</div>
		
				<div class="item">
					<img src="./images/thumbs/boats-1.jpg" alt="pic4">
				</div>
			</div>
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-success">글쓰기</button>
			<button type="button" class="btn btn-danger" id="delete">삭제</button>
			<button type="button" class="btn btn-primary">답글</button>
			<button type="button" class="btn btn-info"><a href="${pageContext.request.contextPath }/user/freeboard/freeboardList.do">목록</a></button>
			<button type="submit" class="btn btn-default" style="float: right">수정</button>
		</div>
	</div>
</form>
</body>
</html>