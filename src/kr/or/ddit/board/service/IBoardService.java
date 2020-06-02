package kr.or.ddit.board.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BoardVO;

public interface IBoardService {
	public BoardVO boardInfo(Map<String, String> params);
	public List<BoardVO> boardList(Map<String, String> params);
	public List<BoardVO> boardList();
	public void insertBoardInfo(BoardVO boardInfo, File[] items, List<String> contentTypes);
	public void insertBoardReply(BoardVO boardInfo);
	public void updateBoardInfo(BoardVO boardInfo);
	public void deleteBoardInfo(Map<String, String> params);
	public String totalCount(Map<String, String> params);
}
