package kr.or.ddit.user.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class IdCheckAction {
	
	public String execute(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String mem_id = request.getParameter("join_mem_id");

		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", mem_id);
		
		IMemberService service = IMemberServiceImpl.getInstance();
		MemberVO memberInfo = service.memberInfo(params);
		
		ObjectMapper mapper = new ObjectMapper();
		String memberInfoJsonData = null;
		try {
			memberInfoJsonData = mapper.writeValueAsString(memberInfo);
			System.out.println(memberInfoJsonData);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String, String> jsonMap = new HashMap<String, String>();
		if(memberInfo == null) {
			jsonMap.put("flag", "true");
		} else {		
			jsonMap.put("flag", "false");
		}
		
		try {
			String jsonData = mapper.writeValueAsString(jsonMap);
			response.getWriter().print(jsonData);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
