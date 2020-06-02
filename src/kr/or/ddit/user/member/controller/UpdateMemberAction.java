package kr.or.ddit.user.member.controller;

import java.net.URLEncoder;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class UpdateMemberAction implements ModelDriven<MemberVO> {
	private MemberVO memberInfo;
	private String message;
	
	public String execute() throws Exception{
	
	IMemberService service = IMemberServiceImpl.getInstance();
	service.updateMember(memberInfo);
	
	this.message = URLEncoder.encode("회원수정완료", "UTF-8");
			
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
