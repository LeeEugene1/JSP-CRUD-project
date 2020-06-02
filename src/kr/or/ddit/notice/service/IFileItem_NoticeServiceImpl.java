package kr.or.ddit.notice.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.notice.dao.IFileItem_NoticeDAO;
import kr.or.ddit.notice.dao.IFileItem_NoticeDAOImp;
import kr.or.ddit.vo.Fileitem_noticeVO;

public class IFileItem_NoticeServiceImpl implements IFileItem_NoticeService {
	private static IFileItem_NoticeService service = new IFileItem_NoticeServiceImpl();
	private IFileItem_NoticeDAO dao;
	
	private IFileItem_NoticeServiceImpl(){
		dao = IFileItem_NoticeDAOImp.getInstance();
	}
	
	public static IFileItem_NoticeService getInstance(){
		return (service == null) ? service = new IFileItem_NoticeServiceImpl() : service;
	}
	
	@Override
	public Fileitem_noticeVO fileitemInfo(Map<String, String> params) {
		Fileitem_noticeVO fileitemInfo = null;
		try {
			fileitemInfo = dao.fileitemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fileitemInfo;
	}

}
