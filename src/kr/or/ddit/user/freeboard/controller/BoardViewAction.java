package kr.or.ddit.user.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.IBoardServiceImpl;
import kr.or.ddit.vo.BoardVO;

public class BoardViewAction implements Action{
	
	private String bo_no;
	private BoardVO boardInfo;
	private String search_keycode;
	private String search_keyword;
	
	public String getSearch_keycode() {
		return search_keycode;
	}

	public void setSearch_keycode(String search_keycode) {
		this.search_keycode = search_keycode;
	}

	public String getSearch_keyword() {
		return search_keyword;
	}

	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}

	@Override
	public String execute() throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", this.bo_no);
		
		IBoardService service = IBoardServiceImpl.getInstance();
		this.boardInfo = service.boardInfo(params);
		
		return "success";
	}

	public String getBo_no() {
		return bo_no;
	}

	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}

	public void setBoardInfo(BoardVO boardInfo) {
		this.boardInfo = boardInfo;
	}

	public BoardVO getBoardInfo() {
		return boardInfo;
	}
	
}
