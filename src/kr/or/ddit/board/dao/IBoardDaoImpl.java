package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.BoardVO;

public class IBoardDaoImpl implements IBoardDao {
	private static IBoardDao dao = new IBoardDaoImpl();
	private SqlMapClient client; 
	
	private IBoardDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IBoardDao getInstance(){
		return (dao == null) ? dao = new IBoardDaoImpl() : dao;
	}
	
	@Override
    public BoardVO boardInfo(Map<String, String> params) throws SQLException {
       return (BoardVO) client.queryForObject("board.boardInfo", params);
    }

	@Override
	public List<BoardVO> boardList(Map<String, String> params) throws SQLException {
		return client.queryForList("board.boardList", params);
	}

	@Override
	public List<BoardVO> boardList() throws SQLException {
		return client.queryForList("board.boardList");
	}
	
	@Override
	public String insertBoardInfo(BoardVO boardInfo)
			throws SQLException {
		return (String) client.insert("board.insertBoard", boardInfo);
	}

	@Override
	public void updateBoardInfo(BoardVO boardInfo)
			throws SQLException {
		client.update("board.updateBoard", boardInfo);
	}

	@Override
	public void deleteBoardInfo(Map<String, String> params)
			throws SQLException {
		client.update("board.deleteBoard", params);
	}

	@Override
	public void insertBoardReply(BoardVO boardInfo)
			throws SQLException {
		try{
			client.startTransaction();
			
			String bo_seq;
			if("0".intern() == boardInfo.getBo_seq().intern()){
				bo_seq = (String) client.queryForObject("board.incrementSEQ", boardInfo);
			}else{
				client.update("board.updateSEQ", boardInfo);
				bo_seq = String.valueOf(Integer.parseInt(boardInfo.getBo_seq())+1);
			}
			boardInfo.setBo_seq(bo_seq);
			
			String bo_depth = String.valueOf(Integer.parseInt(boardInfo.getBo_depth())+1);
			boardInfo.setBo_depth(bo_depth);
			client.insert("board.insertBoardReply",boardInfo);
			
			client.commitTransaction();
			
		}finally{
			client.endTransaction();
		}
	}
	
	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("board.totalCount",params);
	}

}
