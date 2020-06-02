package kr.or.ddit.admin.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberMgrAction {

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String search_keycode = request.getParameter("search_keycode");
		String search_keyword = request.getParameter("search_keyword");
		String search_add1 = request.getParameter("search_add1");
		String search_add2 = request.getParameter("search_add2");
		String search_hp1 = request.getParameter("search_hp1");
		String search_hp2 = request.getParameter("search_hp2");
		String search_hp3 = request.getParameter("search_hp3");
		String search_year = request.getParameter("search_year");
		String search_month = request.getParameter("search_month");
		String search_day = request.getParameter("search_day");
		String search_count = request.getParameter("search_count");

		String test = "선택하세요";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		if(!test.equals(search_add1)){
			params.put("search_add1", search_add1);
		}
		if(!test.equals(search_hp1)){
			params.put("search_hp1", search_hp1);
		}
		
		params.put("search_add2", search_add2);
		params.put("search_hp2", search_hp2);
		params.put("search_hp3", search_hp3);
		
		if(!test.equals(search_year)){
			params.put("search_year", search_year);
		}
		if(!test.equals(search_month)){
			params.put("search_month", search_month);
		}
		if(!test.equals(search_day)){
			params.put("search_day", search_day);
		}
		
		IMemberService service = IMemberServiceImpl.getInstance();
		List<MemberVO> list = service.memberList(params);
		
		request.setAttribute("memberList", list);
		
		return "success";
	}

}
