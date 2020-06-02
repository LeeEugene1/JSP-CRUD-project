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
		$('input[name=re_title]').val('${referenceInfo.re_title }');
		$('input[name=re_writer]').val('${referenceInfo.re_writer }');
		$('textarea[name=re_content]').val('${referenceInfo.re_content }');
		$('input[name=bo_ip]').val('${referenceInfo.bo_ip }');
		
		$('form[name=referenceView]').attr("action", "${pageContext.request.contextPath }/admin/reference/updateReference.do?re_no=${referenceInfo.re_no }");
		
	});
</script>
</head>
<body>
<form name="referenceView" method="post">
<%-- <jsp:include page="../inc/header.jsp"></jsp:include> --%>
<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="referenceMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">공지사항</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<tr>
						  <th>제목</th>
						  <td><input type="text" class="re_title" name="re_title"></td>
						</tr>
						<tr>
						  <th>작성자</th>
						  <td><input type="text" class="re_writer" name="re_writer"></td>
						</tr>
						<tr>
						  <th>내용</th>
						  <td><textarea rows="10" cols="110" class="re_content" name="re_content" style="overflow: auto;"> </textarea> </td>
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