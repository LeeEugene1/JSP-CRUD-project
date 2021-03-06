<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 보기</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$('input[value=수정]').click(function() {
			location.href = '${pageContext.request.contextPath }/admin/freeboard/freeBoardUpdate.do?bo_no=${boardInfo.bo_no }';			
		});
		$('input[value=삭제]').click(function() {
			location.href = '${pageContext.request.contextPath }/admin/freeboard/deleteBoard.do?bo_no=${boardInfo.bo_no }';			
		});
		$('input[value=목록]').click(function() {
			location.href = '${pageContext.request.contextPath }/admin/freeboard/freeBoardList.do';			
		});
	});
</script>
</head>
<body>
<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="freeBoardMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">자유게시판</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<tr>
						  <th>제목</th>
						  <td><label class="bo_title">${boardInfo.bo_title }</label></td>
						</tr>
						<tr>
						  <th>작성자</th>
						  <td><label class="bo_writer">${boardInfo.bo_writer }</label></td>
						</tr>
						<tr>
						  <th>내용</th>
						  <td><textarea rows="10" cols="110" class="bo_content" disabled="disabled" style="overflow: auto;">${boardInfo.bo_content }
						  	</textarea></td>
						</tr>
						<tr>
						  <th>IP Addr.</th>
						  <td><label class="bo_ip">${boardInfo.bo_ip }</label></td>
						</tr>
						<tr>
						  <th>첨부파일</th>
						  
						  <c:forEach items="${referenceInfo.items }" var="fileitem" varStatus="stat">
						  	<c:if test="${stat.first }">
						  		<div class="item active">
						  	</c:if>
						  	<c:if test="${stat.last }">
						  		<div class="item">
						  	</c:if>
							  	<td>
							  		<img src="${pageContext.request.contextPath }/image/save.png" alt="pic1"
							  			 onclick="javascript:location.href='${pageContext.request.contextPath}/file/fileDownload.do?fileName=${fileitem.file_name }';" >
							  		<a href="/files/${fileitem.file_save_name }">${fileitem.file_name }</a>
							  	</td>
						  </c:forEach>
						</tr>
					</table>
					<div style="text-align:right">
						<input class="btn2" type="submit" value="수정"/> 
						<input class="btn2" type="submit" value="삭제"/> 
						<input class="btn2" type="submit" value="목록"/>
					</div>
				</div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>