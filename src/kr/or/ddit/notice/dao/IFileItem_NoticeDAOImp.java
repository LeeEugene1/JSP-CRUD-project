package kr.or.ddit.notice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.Fileitem_noticeVO;

public class IFileItem_NoticeDAOImp implements IFileItem_NoticeDAO {
	private static IFileItem_NoticeDAO dao = new IFileItem_NoticeDAOImp();
	private SqlMapClient client; 
	
	private IFileItem_NoticeDAOImp(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IFileItem_NoticeDAO getInstance(){
		return (dao == null) ? dao = new IFileItem_NoticeDAOImp() : dao;
	}
	
	@Override
	public void insertFileItem(List<Fileitem_noticeVO> fileItemList)
	         throws SQLException {
	      try {
	         client.startTransaction();
	         
	         for (Fileitem_noticeVO fileItemInfo : fileItemList) {   
	            client.insert("fileitemNotice.insertFileItemNotice", fileItemInfo);
	         }
	         client.commitTransaction();
	      } finally {
	         client.endTransaction();
	      }

	   }

	@Override
	public Fileitem_noticeVO fileitemInfo(Map<String, String> params)
			throws SQLException {
		
		return (Fileitem_noticeVO) client.queryForObject("fileitemNotice.fileitemNoticeInfo", params);
	}
	
}
