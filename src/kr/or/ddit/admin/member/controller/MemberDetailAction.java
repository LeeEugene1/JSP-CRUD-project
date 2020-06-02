package kr.or.ddit.admin.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberDetailAction{
	
	private List<MemberVO> memberList;
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String mem_id = request.getParameter("mem_id");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", mem_id);
		
		IMemberService service = IMemberServiceImpl.getInstance();
		MemberVO info = service.memberInfo(params);
		
		request.setAttribute("memberInfo", info);
	
		return "success";
	}
	
}
