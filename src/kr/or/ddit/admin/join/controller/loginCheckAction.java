package kr.or.ddit.admin.join.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.admin.service.IAdminService;
import kr.or.ddit.admin.service.IAdminServiceImpl;
import kr.or.ddit.utiles.CryptoGenerator;
import kr.or.ddit.vo.AdminVO;

public class loginCheckAction {
		
		private String admin_id;
		private String admin_pass;
		private String message;
		
		public String getMessage() {
			return message;
		}

		public String getAdmin_id() {
			return admin_id;
		}

		public void setAdmin_id(String admin_id) {
			this.admin_id = admin_id;
		}

		public String getAdmin_pass() {
			return admin_pass;
		}

		public void setAdmin_pass(String admin_pass) {
			this.admin_pass = admin_pass;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
		public String execute(){
			
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			
			this.admin_id = request.getParameter("admin_id");
			this.admin_pass = request.getParameter("admin_pass");
			
			PrivateKey privateKey = (PrivateKey) session.getAttribute("privateKey");
			
			this.admin_id = CryptoGenerator.decryptRSA(privateKey, this.admin_id);
			this.admin_pass = CryptoGenerator.decryptRSA(privateKey, this.admin_pass);
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("admin_id", this.admin_id);
			params.put("admin_pass", this.admin_pass);
			
			IAdminService service = IAdminServiceImpl.getInstance();
			AdminVO adminInfo = service.adminInfo(params);
			
			if(adminInfo == null){
				try {
					this.message = URLEncoder.encode("회원이아닙니다.","UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return "loginForm";
			}else{
				session.setAttribute("LOGIN_ADMININFO", adminInfo);
				return "success";
			}
		}

}
