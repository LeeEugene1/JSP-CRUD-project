<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css" type="text/css">
<title>회원관리 관리자</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/validation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rsa/jsbn.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rsa/rsa.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rsa/prng4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rsa/rng.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9/core.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9/sha256.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<script type="text/javascript">
	$(function() {
		if(eval('${!empty param.message}')) {
			alert('${param.message}');
		}
	});
</script>

</head>
<body>
	<div class="wrap">
		<div id="header">
			<div class="top_bn">
				<ul>
					<c:if test="${empty LOGIN_ADMININFO }">
					<li><a href="#"><img src="${pageContext.request.contextPath }/image/admin_t.jpg" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath }/image/admin_f.jpg" /></a></li>
					<li><a href="${pageContext.request.contextPath }/user/main.do">
						<img src="${pageContext.request.contextPath }/image/admin_homelink.jpg" /></a></li>
					</c:if>
					<c:if test="${!empty LOGIN_ADMININFO }">
					<li><a href="#"><img src="${pageContext.request.contextPath }/image/admin_t.jpg" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath }/image/admin_f.jpg" /></a></li>
					<li><a href="${pageContext.request.contextPath }/user/main.do">
						<img src="${pageContext.request.contextPath }/image/admin_homelink.jpg" /></a></li>
					<li><a href="${pageContext.request.contextPath }/admin/Logout.do">
						<img src="${pageContext.request.contextPath }/image/admin_logout.jpg" /></a></li>
					</c:if>
				</ul>
			</div>
			<div class="logo">
				<a href="${pageContext.request.contextPath }/admin/loginForm.do">
				<img src="${pageContext.request.contextPath }/image/logo.jpg" /></a>
			</div>
			<div class="gnb">
				<ul>
					<li><a href="${pageContext.request.contextPath }/admin/member/memberList.do">회원관리</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/notice/noticeList.do">공지사항</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/freeboard/freeBoardList.do">게시판</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/reference/referenceList.do">자료실</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/qanda/qandaList.do">Q&A</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/thumb/thumbList.do">이미지 게시판</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/chart/genderChart.do">통계 분석</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>

</html>