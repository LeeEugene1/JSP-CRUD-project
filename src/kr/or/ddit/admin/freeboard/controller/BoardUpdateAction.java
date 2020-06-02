package kr.or.ddit.admin.freeboard.controller;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.IBoardServiceImpl;
import kr.or.ddit.vo.BoardVO;

import com.opensymphony.xwork2.ModelDriven;

public class BoardUpdateAction implements ModelDriven<BoardVO> {
	
	private BoardVO boardInfo;
	
	public String execute() {
		IBoardService service = IBoardServiceImpl.getInstance();
		service.updateBoardInfo(boardInfo);
		
		return "success";
	}

	@Override
	public BoardVO getModel() {
		this.boardInfo = new BoardVO();
		return boardInfo;
	}
}