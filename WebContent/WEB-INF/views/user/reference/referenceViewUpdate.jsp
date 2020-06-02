<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript">
$(function(){
    $('#re_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
    $('#re_content').summernote('code', '<font color ="black">${referenceInfo.re_content}</font>');
	$('input[name=re_writer]').val('${referenceInfo.re_writer}');
	$('input[name=re_mail]').val('${LOGIN_MEMBERINFO.mem_mail}');
	$('input[name=re_content]').val('${referenceInfo.re_content}');
	
 	$('form').submit(function(){
		$(this).attr("action", "${pageContext.request.contextPath}/user/reference/updateReference.do?re_no=${referenceInfo.re_no}");
        $(this).append('<input type="hidden" name="re_content" value=""/>');
		$('input[name=re_content]').val($('.panel-body').html());
 	});
 	
	$('#delete').click(function(){
		var re_no = "${referenceInfo.re_no}";
		location.href ='${pageContext.request.contextPath}/user/reference/referenceDelete.do?re_no=' + re_no;
	});
});
</script>
</head>
<body>
<form class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="re_title" name="re_title"  value="${referenceInfo.re_title }">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="re_writer" name="re_writer" value="${referenceInfo.re_writer }" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="re_mail" name="re_mail" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="re_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="re_content"><p></p></div>
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
			<button type="button" id="delete"  class="btn btn-danger">삭제</button>
			<button type="button" class="btn btn-primary">답글</button>
			<button type="button" class="btn btn-info"><a href="${pageContext.request.contextPath }/user/reference/referenceList.do">목록</a></button>
			<button type="submit" class="btn btn-default" style="float: right">수정</button>
		</div>
	</div>
</form>
</body>
</html>