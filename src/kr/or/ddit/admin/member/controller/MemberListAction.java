package kr.or.ddit.admin.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.utiles.RolePagingUtileMember;
import kr.or.ddit.vo.MemberVO;

public class MemberListAction {
private List<MemberVO> memberList;
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String currentPage = request.getParameter("currentPage");
		if (currentPage == null) {
			currentPage = "1";
		}
		
		String blockCount = request.getParameter("blockCount");
		if (blockCount == null ) {
			blockCount = "10";
		}
		
		IMemberService service = IMemberServiceImpl.getInstance();
		Map<String, String> params = new HashMap<String, String>();
		String totalCount = service.totalCount(params);
		
		RolePagingUtileMember paginUtil = new RolePagingUtileMember(request, 
											Integer.parseInt(totalCount), Integer.parseInt(currentPage), Integer.parseInt(blockCount));
		
		
		String startCount = String.valueOf(paginUtil.getStartCount());
		String endCount = String.valueOf(paginUtil.getEndCount());
		
		params.put("startCount", startCount);
		params.put("endCount", endCount);

		this.memberList = service.memberList(new HashMap<String, String>());
		
		request.setAttribute("pagingUtil", paginUtil.getPagingHtmls());

		
		return "success";
	}
	
	public List<MemberVO> getMemberList(){
		return memberList;
	}
}
