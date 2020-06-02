<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QnA 보기</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$('input[value=목록]').click(function() {
			location.href = '${pageContext.request.contextPath }/admin/qanda/qandaList.do';			
		});
		$('input[value=답글]').click(function() {
			if('${qandaInfo.qa_depth}' == 0) {
				if(eval('${!empty LOGIN_ADMININFO}')) {
					var title = encodeURIComponent('${qandaInfo.qa_title}');
					var params = 'rnum=${param.rnum}&qa_group=${qandaInfo.qa_group}&qa_seq=${qandaInfo.qa_seq}&qa_depth=${qandaInfo.qa_depth}&title=' + title;
					location.href = '${pageContext.request.contextPath }/admin/qanda/qandaForm.do?' + params;
				}else {
					alert('로그인 후 작성이 가능합니다.');
					return;
				}
			} else {
				alert('관리자 글에 답글을 달 수 없습니다.');
			}
			
		});
		
		$('input[value=삭제]').click(function(){
			var con = confirm("정말로 삭제하시겠습니까?");
			if(con == true){
				alert("삭제되었습니다.");
				location.href= '${pageContext.request.contextPath}/admin/qanda/deleteQanda.do?qa_no=${qandaInfo.qa_no}';
			}else{
				alert("취소되었습니다.");
			}
		});
		
		$('input[value=수정]').click(function() {
			if('${qandaInfo.qa_writer}' == 'admin') {
				location.href = '${pageContext.request.contextPath }/admin/qanda/qandaUpdateView.do?qa_no=${qandaInfo.qa_no }';
			}else{
				alert("관리자 글만 수정할 수 있습니다.");
			};
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
						<tr>
						  <th>제목</th>
						  <td><label class="qa_title"></label>${qandaInfo.qa_title }</td>
						</tr>
						<tr>
						  <th>작성자</th>
						  <td><label class="qa_writer"></label>${qandaInfo.qa_writer }</td>
						</tr>
						<tr>
						  <th>내용</th>
						  <td><textarea rows="10" cols="110" class="qa_content" disabled="disabled" style="overflow: auto;">${qandaInfo.qa_content }
						  	</textarea></td>
						</tr>
						<tr>
						  <th>IP Addr.</th>
						  <td><label class="bo_ip"></label>${qandaInfo.bo_ip }</td>
						</tr>
					</table>
					<div style="text-align:right">
						<input class="btn1" type="button" value="답글"/> 
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