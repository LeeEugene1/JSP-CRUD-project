<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 리스트</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$('#qandaTable tr').click(function() {
			var qa_no = $(this).find('td:eq(0) input').val();
			var rnum = $(this).find('td:eq(0)').text();	
			location.href = '${pageContext.request.contextPath }/admin/qanda/qandaView.do?qa_no=' + qa_no + '&rnum=' + rnum;
		});
	});
</script>
</head>
<body>
<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="qandaMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">QnA</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<thead>
							<tr>							
							  <th width="5%">번호</th>
							  <th width="60%">제목</th>
							  <th>작성자</th>
							  <th>작성일</th>
							</tr>
						</thead>
						<tbody id="qandaTable">
						<c:forEach items="${qandaList }" var="qandaInfo">
							<tr>
								<td><input type="hidden" value="${qandaInfo.qa_no }"/>${qandaInfo.rnum }</td>
								<td align="left">
								<c:forEach begin="1" end="${qandaInfo.qa_depth }" varStatus="stat">
									&nbsp;&nbsp;&nbsp;
									<c:if test="${stat.last }">
										<i class="fa fa-angle-right"></i>
									</c:if>
								</c:forEach>
									${qandaInfo.qa_title }</td>
								<td>${qandaInfo.qa_writer }</td>
								<td>${qandaInfo.qa_reg_date.split(" ")[0] }</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<div style="text-align:center;">${pagingUtil }</div>
					<div style="text-align:right;">
					<form action="${pageContext.request.contextPath }/admin/qanda/qandaList.do" method="post">
						<select style="width:100px;" name="search_keycode">
							<option value="TOTAL" selected="selected">전체</option>
							<option value="TITLE">제목</option>
							<option value="CONTENT">내용</option>
							<option value="WRITER">작성자</option>
						</select> 
						<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." size="20" /> 
						<input class="btn1" type="submit" value="검색"/>
					</form>
					</div>
				</div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>