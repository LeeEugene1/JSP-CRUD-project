<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A 목록</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function(){
		$('#qandaTable tr').click(function(){
			var qa_no = $(this).find('td:eq(0) input').val();
			var rnum = $(this).find('td:eq(0)').text();
			location.href='${pageContext.request.contextPath}/user/qanda/qandaView.do?qa_no=' + qa_no + '&rnum=' + rnum;
		});
		
		$('#btn2').click(function(){
			if(eval(('${!empty LOGIN_MEMBERINFO}'))){
				location.href='${pageContext.request.contextPath}/user/qanda/qandaForm.do';
			}else{
			 	BootstrapDialog.show({
		 	    	title: '알럿창',
		 	    	message: '로그인후 이용가능합니다!'
		 		});
				false;
			}
		});
	});
</script>
</head>
<body>

	<div id="qandaList_content">
		<div class="panel panel-blue">
			<div class="panel-heading">QnA</div>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col" width="5%">No</th>
						<th scope="col" width="65%">제목</th>
						<th scope="col" width="10%">작성자</th>
						<th scope="col" width="10%">작성일</th>
					</tr>
				</thead>
				<tbody id="qandaTable">
					<c:forEach items="${qandaList }" var="qandaInfo">
						<tr>
							<td><input type="hidden" value="${qandaInfo.qa_no }" />${qandaInfo.rnum }</td>
							<td align="left"><c:forEach begin="1"
									end="${qandaInfo.qa_depth }" varStatus="stat">
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
		</div>
	</div>
	${pagingUtil }
	<div>
<form action="${pageContext.request.contextPath }/user/qanda/qandaList.do" method="post" class="form-inline pull-right">
		<select class="form-control" name="search_keycode" >
			<option value="TOTAL" selected="selected">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="WRITER">작성자</option>
		</select>
		<input name="search_keyword" id="search_keyword" type="text" placeholder="검색어 입력..."  />
	    <button type="submit" class="btn btn-primary form-control">검색</button>
		<button type="button" id="btn2" class="btn btn-info form-control">게시글 등록</button>
		
</form>
	</div>
</body>
</html>