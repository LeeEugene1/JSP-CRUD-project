<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 목록</title>
<script type="text/javascript">
	$(function() {
		$(function() {
			if(eval('${!empty param.message}')){
				BootstrapDialog.show({
			 	    title: 'alert',
			 	    message: '${param.message}'
			 	});
		    }
		});
		
		$('#freeboardTable tr').click(function() {
			var bo_no = $(this).find('td:eq(0) input').val();
			var rnum = $(this).find('td:eq(0)').text();
			location.href = '${pageContext.request.contextPath}/user/freeboard/freeboardView.do?bo_no=' + bo_no + '&rnum=' + rnum; 
		});
		
		$('#btn2').click(function(){
			if(eval('${!empty LOGIN_MEMBERINFO}')){
				location.href='${pageContext.request.contextPath}/user/freeboard/freeboardForm.do';
			}else{
				BootstrapDialog.show({
					title: 'alert',
					message: '로그인후 이용해주세요'
				});
				false;
			}
		});
	});
</script>
</head>
<body>
<div id="freeboardList_content">
	<div class="panel panel-blue">
    	<div class="panel-heading">자유게시판</div>
		<table class="table table-bordered table-hover">
			<thead>
			</thead>
						<tbody id="freeboardTable">
			<c:forEach items="${boardList }" var="boardInfo">
				<tr>
					<td><input type="hidden" value="${boardInfo.bo_no }" />${boardInfo.rnum }</td>
					<td align="left">
					<c:forEach begin="1" end="${boardInfo.bo_depth }" varStatus="stat">
						&nbsp;&nbsp;&nbsp;
						<c:if test="${stat.last }">
							<i class="fa fa-angle-right"></i>
						</c:if>
					</c:forEach>
						${boardInfo.bo_title }
					</td>
					<td>${boardInfo.bo_writer }</td>
					<td>${boardInfo.bo_reg_date.split(" ")[0] }</td>
					<td>${boardInfo.bo_seq }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
	${pagingUtil }
<div>
<form action="${pageContext.request.contextPath }/user/freeboard/freeboardList.do" method="post" class="form-inline pull-right">
		<select class="form-control" name="search_keycode" >
			<option value="TOTAL" selected="selected">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="WRITER">작성자</option>
		</select>
		<input name="search_keyword" id="search_keyword" type="text" placeholder="검색어 입력..."  />
	    <button type="submit" class="btn btn-primary form-control">검색</button>
	    <button type="button" id="btn2" class="btn btn-info form-control">게시글등록</button>
</form>
</div>	
</body>
</html>