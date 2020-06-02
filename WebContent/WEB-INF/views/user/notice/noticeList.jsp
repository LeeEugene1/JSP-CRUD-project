<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function(){
		$('#noticeTable tr').click(function(){
			var no_no = $(this).find('td:eq(0) input').val();
			var rnum = $(this).find('td:eq(0)').text();
			location.href = '${pageContext.request.contextPath}/user/notice/noticeView.do?no_no=' + no_no + '&rnum=' + rnum;
			
			return;
		});
	});
</script>
</head>
<body>
<div id="freeboardList_content">
	<div class="panel panel-blue">
    	<div class="panel-heading">공지사항</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col" width="5%">No</th>
					<th scope="col" width="65%">제목</th>
					<th scope="col" width="10%">작성자</th>
					<th scope="col" width="10%">작성일</th>
				</tr>
			</thead>
						<tbody id="noticeTable">
			<c:forEach items="${noticeList }" var="noticeInfo">
				<tr>
					<td><input type="hidden" value="${noticeInfo.no_no }" />${noticeInfo.rnum }</td>
					<td align="left">
					<c:forEach begin="1" end="${noticeInfo.no_depth }" varStatus="stat">
						&nbsp;&nbsp;&nbsp;
						<c:if test="${stat.last }">
							<i class="fa fa-angle-right"></i>
						</c:if>
					</c:forEach>
						${noticeInfo.no_title }
					</td>
					<td>${noticeInfo.no_writer }</td>
					<td>${noticeInfo.no_reg_date.split(" ")[0] }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
	${pagingUtil }
<div >
<form action="${pageContext.request.contextPath }/user/notice/noticeList.do" method="post" class="form-inline pull-right">
		<select class="form-control" name="search_keycode" >
			<option value="TOTAL" selected="selected">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="WRITER">작성자</option>
		</select>
		<input name="search_keyword" id="search_keyword" type="text" placeholder="검색어 입력..."  />
	    <button type="submit" class="btn btn-primary form-control">검색</button>
</form>
</div>	
</body>
</html>