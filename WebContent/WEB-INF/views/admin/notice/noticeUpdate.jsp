<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 수정</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$('input[name=no_title]').val('${noticeInfo.no_title }');
		$('input[name=no_writer]').val('${noticeInfo.no_writer }');
		$('textarea[name=no_content]').val('${noticeInfo.no_content }');
		$('input[name=bo_ip]').val('${noticeInfo.bo_ip }');
		
		$('form[name=noticeView]').attr("action", "${pageContext.request.contextPath }/admin/notice/updateNotice.do?no_no=${noticeInfo.no_no }");
		
	});
</script>
</head>
<body>
<form name="noticeView" method="post">
<%-- <jsp:include page="../inc/header.jsp"></jsp:include> --%>
<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="noticeMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">공지사항</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<tr>
						  <th>제목</th>
						  <td><input type="text" class="no_title" name="no_title"></td>
						</tr>
						<tr>
						  <th>작성자</th>
						  <td><input type="text" class="no_writer" name="no_writer"></td>
						</tr>
						<tr>
						  <th>내용</th>
						  <td><textarea rows="10" cols="110" class="no_content" name="no_content" style="overflow: auto;"> </textarea> </td>
						</tr>
						<tr>
						  <th>IP Addr.</th>
						  <td><input type="text" class="bo_ip" name="bo_ip"></td>
						</tr>
					</table>
					<table border="0" cellspacing="0" cellpadding="0">
					  <tr></tr>
					</table>
					<div style="text-align:right">
						<input class="btn1" type="submit" value="등록"/> 
						<input class="btn2" type="button" value="취소"/> 
						<input class="btn3" type="button" value="목록"/>
					</div>
				</div>
			</td>
		</tr>
	</table>
</div>	
</form>
</body>
</html>