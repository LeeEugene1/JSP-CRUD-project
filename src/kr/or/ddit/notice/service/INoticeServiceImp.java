package kr.or.ddit.notice.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.notice.dao.IFileItem_NoticeDAO;
import kr.or.ddit.notice.dao.IFileItem_NoticeDAOImp;
import kr.or.ddit.notice.dao.INoticeDao;
import kr.or.ddit.notice.dao.INoticeDaoImp;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.vo.Fileitem_noticeVO;
import kr.or.ddit.vo.NoticeVO;

public class INoticeServiceImp implements INoticeService {
	private static INoticeService service = new INoticeServiceImp();
	private INoticeDao noticeDAO;
	private IFileItem_NoticeDAO fileitemDAO;
	
	private INoticeServiceImp() {
		noticeDAO = INoticeDaoImp.getInstance();
		fileitemDAO = IFileItem_NoticeDAOImp.getInstance();
	}
	
	public static INoticeService getInstance(){
		return(service == null) ? service = new INoticeServiceImp() : service;
	}
	
	@Override
	public NoticeVO noticeInfo(Map<String, String> params) {
		NoticeVO noticeInfo = null;
		try {
			noticeInfo = noticeDAO.noticeInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noticeInfo;
	}
	
	@Override
	public List<NoticeVO> noticeList(Map<String, String> params) {
		List<NoticeVO> noticeList = null;
		try {
			noticeList = noticeDAO.noticeList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public List<NoticeVO> noticeList() {
		List<NoticeVO> noticeList = null;
		try {
			noticeList = noticeDAO.noticeList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public void insertNoticeInfo(NoticeVO noticeInfo, File[] items, List<String> contextType) {
		try {
			String no_no = noticeDAO.insertNoticeInfo(noticeInfo);
			if (items != null) {
				List<Fileitem_noticeVO> fileItemList = AttachFileMapper.mapper_notice(items, no_no, contextType);
				fileitemDAO.insertFileItem(fileItemList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertNoticeReply(NoticeVO noticeInfo) {
		try {
			noticeDAO.insertNoticeReply(noticeInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateNoticeInfo(NoticeVO noticeInfo) {
		try {
			noticeDAO.updateNoticeInfo(noticeInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteNoticeInfo(Map<String, String> params) {
		try {
			noticeDAO.deleteNoticeInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount="0";
		try {
			totalCount = noticeDAO.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

}
