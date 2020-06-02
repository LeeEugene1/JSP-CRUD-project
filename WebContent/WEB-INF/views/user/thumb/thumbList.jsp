<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="thumbURL" value="/admin/thumbnailboard"></c:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thumb 리스트</title>
<script type="text/javascript">
   $(function(){
	   $('.thumbTable tr').click(function(){
	         if(eval('${empty LOGIN_MEMBERINFO.mem_id}')){
	            alert("로그인 후 게시글 확인이 가능합니다.");
	         }else{
	            var im_no = $(this).find('input[name=th_bo_no]').val();         
	            location.href = "${pageContext.request.contextPath }/user/thumb/thumbView.do?im_no="+im_no;
	         }
	      });
      
      $('.btn2').click(function(){
			location.href = '${pageContext.request.contextPath }/user/thumb/thumbForm.do';
      });
      
   });
</script>
</head>
<body>
<div class="wrap">
   <table width="1000" border="0" cellpadding="0" cellspacing="0">
      <tr valign="top">
         <td width="30">&nbsp;</td>
         <td width="790"> 
            <div id="container">
            <div class="title">썸네일</div>
	            	<table width="700" height="500" border="1" cellspacing="1" cellpadding="1" class="thumbTable">
		                  <c:forEach items="${thumbList }" var="thumbInfo">
                 			 <tr class="tbl-item" >
	                           <td class="img" width="100px" height="50px">
	                              <c:forEach items="${thumbInfo.items}" var="item">
	                              <img src="/files/${item.file_save_name }"  width="300px" height="200px"/>
	                              </c:forEach>
	                           </td>
	                           <td class="td-block"><p class="title">${thumbInfo.im_title}</p>
	                               <p class="date">날짜 : ${thumbInfo.im_reg_date}</p>
	                               <p class="desc">내용 : ${thumbInfo.im_content}</p>
	                               <p class="like">작성자 : ${thumbInfo.im_writer}</p>
	                               <input type="hidden" name="th_bo_no" value="${thumbInfo.im_no}"/>
	                            </td>
                       </tr>
                    </c:forEach>
	               </table>
	               
					<div style="text-align:center;">${pagingUtil }</div>
					<div style="text-align:right;">
					<form action="${pageContext.request.contextPath }/user/thumb/thumbList.do" method="post">
						<select style="width:100px;" name="search_keycode">
							<option value="TOTAL" selected="selected">전체</option>
							<option value="TITLE">제목</option>
							<option value="CONTENT">내용</option>
							<option value="WRITER">작성자</option>
						</select> 
						<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." size="20" /> 
						<input class="btn1" type="submit" value="검색"/>
						<input class="btn2" type="button" value="등록"/>
					</form>
					</div>
				</div>
            </div>
         </td>
      </tr>
   </table>
</div>
</body>
</html>