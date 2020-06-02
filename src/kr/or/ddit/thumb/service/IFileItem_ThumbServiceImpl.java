package kr.or.ddit.thumb.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.thumb.dao.IFileItem_ThumbDAO;
import kr.or.ddit.thumb.dao.IFileItem_ThumbDAOImp;
import kr.or.ddit.vo.Fileitem_imageboardVO;

public class IFileItem_ThumbServiceImpl implements IFileItem_ThumbService {
	private static IFileItem_ThumbService service = new IFileItem_ThumbServiceImpl();
	private IFileItem_ThumbDAO dao;
	
	
	private IFileItem_ThumbServiceImpl(){
		dao = IFileItem_ThumbDAOImp.getInstance();
	}
	
	public static IFileItem_ThumbService getInstance(){
		return (service == null) ? service = new IFileItem_ThumbServiceImpl() : service;
	}
	
	@Override
	public Fileitem_imageboardVO fileitemInfo(Map<String, String> params) {
		Fileitem_imageboardVO fileitemInfo = null;
		try {
			fileitemInfo = dao.fileitemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fileitemInfo;
	}

}
