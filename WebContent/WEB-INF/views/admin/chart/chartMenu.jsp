<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="left_menu">
		<div class="tt">통계 관리</div>
		<ul>
			<li><a href="${pageContext.request.contextPath }/admin/chart/genderChart.do">회원성별통계</a></li>
			<li><a href="${pageContext.request.contextPath }/admin/chart/ageChart.do">회원나이통계</a></li>
			<li><a href="${pageContext.request.contextPath }/admin/chart/boardChart.do">게시글통계</a></li>
			<li><a href="${pageContext.request.contextPath }/admin/chart/dropoutChart.do">회원탈퇴사유통계</a></li>
			<li><a href="${pageContext.request.contextPath }/admin/chart/joinChart.do">가입경로비율통계</a></li>
		</ul>
	</div>
</body>
</html>