package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.board.dao.IFileItem_boardDAO;
import kr.or.ddit.board.dao.IFileItem_boardDAOImp;
import kr.or.ddit.vo.Fileitem_boardVO;

public class IFileItem_boardServiceImpl implements IFileItem_boardService {
	private static IFileItem_boardService service = new IFileItem_boardServiceImpl();
	private IFileItem_boardDAO dao;
	
	private IFileItem_boardServiceImpl(){
		dao = IFileItem_boardDAOImp.getInstance();
	}
	
	public static IFileItem_boardService getInstance(){
		return (service == null) ? service = new IFileItem_boardServiceImpl() : service;
	}
	
	@Override
	public Fileitem_boardVO fileitemInfo(Map<String, String> params) {
		Fileitem_boardVO fileitemInfo = null;
		try {
			fileitemInfo = dao.fileitemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fileitemInfo;
	}

}
