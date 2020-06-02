package kr.or.ddit.reference.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.reference.dao.IFileItem_referenceDAO;
import kr.or.ddit.reference.dao.IFileItem_referenceDAOImp;
import kr.or.ddit.vo.Fileitem_referenceVO;

public class IFileItem_referenceServiceImpl implements IFileItem_referenceService {
	private static IFileItem_referenceService service = new IFileItem_referenceServiceImpl();
	private IFileItem_referenceDAO dao;
	
	private IFileItem_referenceServiceImpl(){
		dao = IFileItem_referenceDAOImp.getInstance();
	}
	
	public static IFileItem_referenceService getInstance(){
		return (service == null) ? service = new IFileItem_referenceServiceImpl() : service;
	}
	
	@Override
	public Fileitem_referenceVO fileitemInfo(Map<String, String> params) {
		Fileitem_referenceVO fileitemInfo = null;
		try {
			fileitemInfo = dao.fileitemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fileitemInfo;
	}

}
