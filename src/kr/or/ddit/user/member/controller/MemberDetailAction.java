package kr.or.ddit.user.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberDetailAction{
	private List<MemberVO> memberList;
	
	public String execute(){
		
		Map<String, String> params = new HashMap<String, String>();

		IMemberService service = IMemberServiceImpl.getInstance();
		MemberVO info = service.memberInfo(params);
		
		String mem_id = info.getMem_id();
		params.put("mem_id", mem_id);
		
		this.memberList = service.memberList(new HashMap<String, String>());
		
		return "success";
	}
	
}
