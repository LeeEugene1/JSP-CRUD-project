package kr.or.ddit.user.member.controller;

import java.util.HashMap;
import java.util.List;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberListAction {
private List<MemberVO> memberList;
	
	public String execute(){
		IMemberService service = IMemberServiceImpl.getInstance();
		this.memberList = service.memberList(new HashMap<String, String>());
		
		return "success";
	}
	
	// 기본객체 request 저장영역 : requestScope
	// 스트럿츠 프레임웍 : request 기본객체의 저장영역을 확장한 ValueStack
	//               1. 값 저장시 액션 클래스 내 전역변수의 getter를 통한 반환값 제공.
	//               2. ModelDriven 인터셉터를 활용.
	//               ValueStack : 키 - memberList(전역변수명) value=getter의 반환값
	
	public List<MemberVO> getMemberList(){
		return memberList;
	}
}
