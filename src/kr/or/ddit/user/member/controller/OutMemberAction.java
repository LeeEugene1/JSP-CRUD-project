package kr.or.ddit.user.member.controller;

import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class OutMemberAction implements ModelDriven<MemberVO> {
	MemberVO memberInfo;
	String message;
	
	public String outMemberInfo() throws Exception{
		IMemberService service = IMemberServiceImpl.getInstance();
		service.deleteMember(this.memberInfo);
		
		
		this.message = URLEncoder.encode("회원탈퇴신청완료", "UTF-8");

		ServletActionContext.getRequest().getSession().invalidate();

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
