package kr.or.ddit.user.member.controller;

import java.net.URLEncoder;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import com.opensymphony.xwork2.ModelDriven;

public class InsertMemberAction implements ModelDriven<MemberVO> {
	private MemberVO memberInfo;
	private String message;
	
	public String insertMemberInfo() throws Exception{
		IMemberService service = IMemberServiceImpl.getInstance();
		service.insertMember(this.memberInfo);
		
		this.message = URLEncoder.encode("회원가입완료","UTF-8");
		
		return "success";
	}
	
	@Override
	public MemberVO getModel() {
		this.memberInfo = new MemberVO();
		return this.memberInfo;
	}
	public String getMessage() {
		return message;
	}
	
}
