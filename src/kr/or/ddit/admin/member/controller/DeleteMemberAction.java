package kr.or.ddit.admin.member.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;

public class DeleteMemberAction {
	
	private String mem_id;
	private String message;
	
	public String deleteMemberInfo() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", mem_id);
		
		IMemberService service = IMemberServiceImpl.getInstance();
		service.OutMember(params);
		
		this.message = URLEncoder.encode(mem_id+"님의 탈퇴 처리가 완료되었습니다.", "UTF-8");
		
		return "success";
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_id() {
		return mem_id;
	}

}
