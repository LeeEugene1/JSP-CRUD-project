package kr.or.ddit.user.freeboard.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.IBoardServiceImpl;

public class BoardDeleteAction {
	
	private String bo_no;
	private String message;
	
	public String boardDeleteInfo() throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", bo_no);
		
		IBoardService service = IBoardServiceImpl.getInstance();
		service.deleteBoardInfo(params);
		
		this.message = URLEncoder.encode("게시물을 삭제하였습니다", "UTF-8");
		
		return "success";
		
	}

	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
