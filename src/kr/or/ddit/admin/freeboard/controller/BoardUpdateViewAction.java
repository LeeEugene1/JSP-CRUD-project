package kr.or.ddit.admin.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.IBoardServiceImpl;
import kr.or.ddit.vo.BoardVO;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class BoardUpdateViewAction implements Action {

	private String bo_no;
	private BoardVO boardInfo;

	@Override
	public String execute() throws Exception {

		ServletActionContext.getRequest().getSession().invalidate();

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

	public BoardVO getBoardInfo() {
		return boardInfo;
	}
	
}
