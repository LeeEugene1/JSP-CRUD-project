<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>썸네일수정</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$('input[name=im_title]').val('${thumbInfo.im_title }');
		$('input[name=im_writer]').val('${thumbInfo.im_writer }');
		$('textarea[name=im_content]').val('${thumbInfo.im_content }');
		
		$('form[name=thumbView]').attr("action", "${pageContext.request.contextPath }/admin/thumb/thumbUpdate.do?im_no=${thumbInfo.im_no }");
		
		$('input[value=목록]').click(function() {
			location.href = '${pageContext.request.contextPath }/admin/thumb/thumbList.do';			
		});
		
	});
</script>
</head>
<body>
<form name="thumbView" method="post">
<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="thumbMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">썸네일</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<tr>
						  <th>제목</th>
						  <td><input type="text" class="im_title" name="im_title"></td>
						</tr>
						<tr>
						  <th>작성자</th>
						  <td><input type="text" class="im_writer" name="im_writer" disabled="disabled"></td>
						</tr>
						<tr>
						  <th>내용</th>
						  <td><textarea rows="10" cols="110" class="im_content" name="im_content" style="overflow: auto;"> </textarea> </td>
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