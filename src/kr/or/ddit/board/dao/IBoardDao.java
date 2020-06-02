package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BoardVO;

public interface IBoardDao {
	public BoardVO boardInfo(Map<String, String> params) throws SQLException;
	public List<BoardVO> boardList(Map<String, String> params) throws SQLException;
	public List<BoardVO> boardList() throws SQLException;
	public String insertBoardInfo(BoardVO boardInfo) throws SQLException;
	public void insertBoardReply(BoardVO boardInfo) throws SQLException;
	public void updateBoardInfo(BoardVO boardInfo) throws SQLException;
	public void deleteBoardInfo(Map<String, String> params) throws SQLException;
	public String totalCount(Map<String, String> params) throws SQLException;
}
