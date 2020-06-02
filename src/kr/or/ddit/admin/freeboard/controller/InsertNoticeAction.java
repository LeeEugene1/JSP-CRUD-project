package kr.or.ddit.admin.freeboard.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.IBoardServiceImpl;
import kr.or.ddit.vo.BoardVO;

import com.opensymphony.xwork2.ModelDriven;

public class InsertNoticeAction implements ModelDriven<BoardVO> {
	
	private BoardVO boardInfo;
	private String message;
	
	public String insertNoticeInfo() throws UnsupportedEncodingException {
		
		IBoardService service = IBoardServiceImpl.getInstance();
		service.insertBoardReply(boardInfo);
		
		this.message = URLEncoder.encode("게시물 작성이 완료되었습니다", "UTF-8");
		
		return "success";
	}

	@Override
	public BoardVO getModel() {
		this.boardInfo = new BoardVO();
		return boardInfo;
	}

	public String getMessage() {
		return message;
	}

}
