<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원리스트</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$('.memberList tr').click(function() {
			var mem_id = $(this).find('td:eq(1)').text();
			
			location.href = '${pageContext.request.contextPath }/admin/member/memberDetail.do?mem_id=' + mem_id;
		});
	});
</script>
</head>
<body>
<div class="wrap">	
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="memberMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790">
				<div id="container">
					<div class="title">회원관리</div>
					<form name="search_form" action="${pageContext.request.contextPath }/admin/member/memberMgr.do" method="post">
						<table border="0" cellspacing="1" cellpadding="1">
							<tr>
								<th width="120">기본검색</th>
								<td>
									<select style="width: 130px;" name="search_keycode">
											<option selected="selected">선택하세요</option>
											<option value="search_name">이름</option>
											<option value="search_id">아이디</option>
									</select>
								<input name="search_keyword" type="text" size="20" /></td>
							</tr>
							<tr>
								<th>거주지</th>
								<td>
									<select onchange="getGugun(this)" style="width: 130px;" name="search_add1">
											<option selected="selected">선택하세요</option>
											<option value="서울" >서울특별시</option>
											<option value="부산">부산광역시</option>
											<option value="대구">대구광역시</option>
											<option value="인천">인천광역시</option>
											<option value="광주">광주광역시</option>
											<option value="대전">대전광역시</option>
											<option value="울산">울산광역시</option>
											<option value="세종">세종특별자치시</option>
											<option value="경기도">경기도</option>
											<option value="강원도">강원도</option>
											<option value="충북">충청북도</option>
											<option value="충남">충청남도</option>
											<option value="전북">전라북도</option>
											<option value="전남">전라남도</option>
											<option value="경북">경상북도</option>
											<option value="경남">경상남도</option>
											<option value="제주">제주특별자치도</option>
									</select> 
									<input name="search_add2" type="text" id="mem_add2" size="30" />
								</td>
							</tr>
							<tr>
								<th>연락처</th>
								<td>
									<select style="width: 100px;" name="search_hp1">
										<option selected="selected">선택하세요</option>
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="018">019</option>
									</select> - 
									<input name="search_hp2" type="text" id="search_hp2" size="20" /> - 
									<input name="search_hp3" type="text" id="search_hp3" size="20" />
								</td>
							</tr>
							<tr>
								<th>생년월일</th>
									<td>
									<select style="width: 130px;" name="search_year">
										<option selected="selected">선택하세요</option>
										<c:forEach begin="1900" end="2020" var="i" step="1" varStatus="stat">
										<c:if test="${stat.first }">
										</c:if>
										<option value="${i }">${i }</option>
										<c:if test="${stat.last }">
										</c:if>
										</c:forEach>
									</select> 
									<select style="width: 130px;" name="search_month">
										<option selected="selected">선택하세요</option>
										<c:forEach begin="1" end="12" var="i" step="1" varStatus="stat">
										<c:if test="${stat.first }">
										</c:if>
										<option value="${i }">${i }</option>
										<c:if test="${stat.last }">
										</c:if>
										</c:forEach>
									</select> 
									<select style="width: 130px;" name="search_day">
										<option selected="selected">선택하세요</option>
										<c:forEach begin="1" end="31" var="i" step="1" varStatus="stat">
										<c:if test="${stat.first }">
										</c:if>
										<option value="${i }">${i }</option>
										<c:if test="${stat.last }">
										</c:if>
										</c:forEach>
									</select>
								</td>
							</tr>
						</table>
						<div style="padding-top: 5px; text-align: right;">
							<input class="btn1" type="reset" value="초기화"/>
							<input class="btn1" type="submit" value="검색하기" />
						</form>
						</div>
					</form>
					<div style="padding-top: 5px;" id="search_totalMembers">
					<div style="height: 15px;"></div>
					<table border="0" cellspacing="1" cellpadding="1">
						<thead>
							<tr>
								<th width="10%">
								    <input type="checkbox" name="selectTotal" class="checkbox_align"/>&nbsp;선택
								</th>
								<th width="20%">아이디</th>
								<th>이름</th>
								<th>생일</th>
								<th>메일</th>
								<th>삭제요청여부</th>
							</tr>
						</thead>
						<tbody class="memberList">
						<c:forEach items="${memberList }" var="memberInfo">
							<tr>
								<td><input type="checkbox" name="selectTotal" class="checkbox_align"/></td>
								<td width="20%">${memberInfo.mem_id }</td>
								<td>${memberInfo.mem_name }</td>
								<td>${memberInfo.mem_bir.split(" ")[0] }</td>
								<td>${memberInfo.mem_mail }</td>
								<td>${memberInfo.mem_delete_check }</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					${pagingUtil }
				</div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>