<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 목록</title>
<script type="text/javascript">
	$(function() {
		$('#referenceTable tr').click(function() {
			var re_no = $(this).find('td:eq(0) input').val();
			var rnum = $(this).find('td:eq(0)').text();
			location.href = '${pageContext.request.contextPath}/user/reference/referenceView.do?re_no=' + re_no + '&rnum=' + rnum; 
		});
		$('#btn2').click(function() {
			if(eval('${!empty LOGIN_MEMBERINFO}')){
				location.href = '${pageContext.request.contextPath}/user/reference/referenceForm.do';			
			}else{
				BootstrapDialog.show({
					alert:'alert',
					message:'로그인후 이용가능합니다'
				});
				false;
			}
		});
	});
</script>
</head>
<body>
<div id="referenceList_content">
	<div class="panel panel-blue">
    	<div class="panel-heading">자료실</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col" width="5%">No</th>
					<th scope="col" width="65%">제목</th>
					<th scope="col" width="10%">작성자</th>
					<th scope="col" width="10%">작성일</th>
				</tr>
			</thead>
						<tbody id="referenceTable">
			<c:forEach items="${referenceList }" var="referenceInfo">
				<tr>
					<td><input type="hidden" value="${referenceInfo.re_no }" />${referenceInfo.rnum }</td>
					<td align="left">
					<c:forEach begin="1" end="${referenceInfo.re_depth }" varStatus="stat">
						&nbsp;&nbsp;&nbsp;
						<c:if test="${stat.last }">
							<i class="fa fa-angle-right"></i>
						</c:if>
					</c:forEach>
						${referenceInfo.re_title }
					</td>
					<td>${referenceInfo.re_writer }</td>
					<td>${referenceInfo.re_reg_date.split(" ")[0] }</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
${pagingUtil }
<div >
<form action="${pageContext.request.contextPath }/user/reference/referenceList.do" method="post" class="form-inline pull-right">
		<select class="form-control" name="search_keycode" >
			<option value="TOTAL" selected="selected">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="WRITER">작성자</option>
		</select>
		<input name="search_keyword" id="search_keyword" type="text" placeholder="검색어 입력..."  />
	    <button type="submit" class="btn btn-primary form-control">검색</button>
	    <button type="button" id="btn2" class="btn btn-info form-control">자료실등록</button>
</form>
</div>	
</body>
</html>