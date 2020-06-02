package kr.or.ddit.board.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.dao.IBoardDaoImpl;
import kr.or.ddit.board.dao.IFileItem_boardDAO;
import kr.or.ddit.board.dao.IFileItem_boardDAOImp;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.Fileitem_boardVO;

public class IBoardServiceImpl implements IBoardService {

	private static IBoardService service = new IBoardServiceImpl();
	private IBoardDao boardDAO;
	private IFileItem_boardDAO fileitemDAO;
	
	private IBoardServiceImpl(){
		boardDAO = IBoardDaoImpl.getInstance();
		fileitemDAO = IFileItem_boardDAOImp.getInstance();
	}
	
	public static IBoardService getInstance(){
		return(service == null) ? service = new IBoardServiceImpl() : service;
	}

	@Override
	public BoardVO boardInfo(Map<String, String> params) {
		BoardVO boardInfo = null;
		try {
			boardInfo = boardDAO.boardInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardInfo;
	}

	@Override
	public List<BoardVO> boardList(Map<String, String> params) {
		List<BoardVO> boardList = null;
		try {
			boardList = boardDAO.boardList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public List<BoardVO> boardList() {
		List<BoardVO> boardList = null;
		try {
			boardList = boardDAO.boardList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public void insertBoardInfo(BoardVO boardInfo, File[] items, List<String> contentTypes) {
		try {
			String bo_no = boardDAO.insertBoardInfo(boardInfo);
			if(items != null){
				List<Fileitem_boardVO> fileItemList = AttachFileMapper.mapper_board(items, bo_no, contentTypes);
				fileitemDAO.insertFileItem(fileItemList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertBoardReply(BoardVO boardInfo) {
		try {
			boardDAO.insertBoardReply(boardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBoardInfo(BoardVO boardInfo) {
		try {
			boardDAO.updateBoardInfo(boardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBoardInfo(Map<String, String> params) {
		try {
			boardDAO.deleteBoardInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount="0";
		try {
			totalCount = boardDAO.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}
	
}
