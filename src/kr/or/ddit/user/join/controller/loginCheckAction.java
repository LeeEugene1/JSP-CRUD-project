package kr.or.ddit.user.join.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class loginCheckAction {
		
		private String mem_id;
		private String mem_pass;
		private String message;
		
		public String getMessage() {
			return message;
		}

		public String getMem_id() {
			return mem_id;
		}
		public void setMem_id(String mem_id) {
			this.mem_id = mem_id;
		}
		public String getMem_pass() {
			return mem_pass;
		}
		public void setMem_pass(String mem_pass) {
			this.mem_pass = mem_pass;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String execute(){

			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();

			this.mem_id = request.getParameter("mem_id");		
			this.mem_pass = request.getParameter("mem_pass"); 
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("mem_id", this.mem_id);
			params.put("mem_pass", this.mem_pass);
			
			IMemberService service = IMemberServiceImpl.getInstance();
			MemberVO memberInfo = service.memberInfo(params);
			
			if(memberInfo == null){
				try {
					this.message = URLEncoder.encode("회원이아닙니다.","UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				return "main";
			}else if(memberInfo.getMem_dropout() != null){
				try {
					this.message = URLEncoder.encode("회원탈퇴 신청중입니다.","UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return "main";
			}else{
				session.setAttribute("LOGIN_MEMBERINFO", memberInfo);
				return "success";
			}
		}

}
