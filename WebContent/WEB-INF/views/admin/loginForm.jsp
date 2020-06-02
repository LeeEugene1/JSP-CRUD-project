<%@page import="kr.or.ddit.utiles.CryptoGenerator"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css" type="text/css">
<title>회원관리 관리자 로그인</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/validation.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath }/js/rsa/jsbn.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rsa/rsa.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rsa/prng4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rsa/rng.js"></script>
<script type="text/javascript">
	$(function () {
		
      if(eval('${!empty param.message}')){
          alert('${param.message}');
       }
      
      $('.loginBtn').click(function(){
    	 var admin_id = $('input[name=admin_id]').val();
    	 var admin_pass = $('input[name=admin_pass]').val();
    	 
    	 var publicExponent = '${publicKeyMap["publicExponent"]}';
         var publicModulus = '${publicKeyMap["publicModulus"]}';	
         
         var rsaOBJ = new RSAKey();
         rsaOBJ.setPublic(publicModulus, publicExponent);
         
         var encryptID = rsaOBJ.encrypt(admin_id);
         var encryptPWD = rsaOBJ.encrypt(admin_pass);
    	 
         var $frm = $('<form action="${pageContext.request.contextPath }/admin/loginCheck.do" method="POST"/></form>');
	     var $inputID = $('<input type="hidden" name="admin_id" value="' + encryptID +'" />');     
	     var $inputPWD = $('<input type="hidden" name="admin_pass" value="' + encryptPWD +'" />'); 
	      
	     $frm.append($inputID);
	     $frm.append($inputPWD);
	      
	     $(document.body).append($frm);

	     $frm.submit();
      });
	});
</script>


</head>
<body>
	<table width="770" border="0" align="center" cellpadding="0"
		cellspacing="0" style="margin: 90px;">
		<tr>
			<td height="150" align="center"><img src="${pageContext.request.contextPath }/image/p_login.gif" /></td>
		</tr>
		<tr>
			<td height="174"
				style="background: url(${pageContext.request.contextPath }/image/login_bg.jpg); border: 1px solid #e3e3e3;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="260" height="110" align="center"
							style="border-right: 1px dotted #736357;">
							<img src="${pageContext.request.contextPath }/image/logo.jpg" />
						</td>
						<td>
							<table border="0" align="center" cellpadding="5"
								cellspacing="0">
								<tr>
									<td><b>아이디</b></td>
									<td><input type="text" name="admin_id" class="box" tabindex="3" height="18" /></td>
									<td rowspan="2">
										<img src="${pageContext.request.contextPath }/image/login.gif" class="loginBtn"/>
									</td>
								</tr>
								<tr>
									<td><b>패스워드</b></td>
									<td><input type="password" name="admin_pass" class="box" tabindex="3" height="18" /></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
