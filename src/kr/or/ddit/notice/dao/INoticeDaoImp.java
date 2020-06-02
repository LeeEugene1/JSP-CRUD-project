package kr.or.ddit.notice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.NoticeVO;

public class INoticeDaoImp implements INoticeDao {
	private static INoticeDao dao = new INoticeDaoImp();
	private SqlMapClient client; 
	
	private INoticeDaoImp() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static INoticeDao getInstance(){
		return (dao == null) ? dao = new INoticeDaoImp() : dao;
	}
		
	@Override
    public NoticeVO noticeInfo(Map<String, String> params) throws SQLException {
       return (NoticeVO) client.queryForObject("notice.noticeInfo", params);
    }

	@Override
	public List<NoticeVO> noticeList(Map<String, String> params) throws SQLException {
		return client.queryForList("notice.noticeList", params);
	}

	@Override
	public List<NoticeVO> noticeList() throws SQLException {
		return client.queryForList("notice.noticeList");
	}
	
	@Override
	public String insertNoticeInfo(NoticeVO noticeInfo)
			throws SQLException {
		return (String) client.insert("notice.insertNotice", noticeInfo);
	}

	@Override
	public void updateNoticeInfo(NoticeVO noticeInfo)
			throws SQLException {
		client.update("notice.updateNotice", noticeInfo);
	}

	@Override
	public void deleteNoticeInfo(Map<String, String> params)
			throws SQLException {
		client.update("notice.deleteNotice", params);
	}

	@Override
	public void insertNoticeReply(NoticeVO noticeInfo)
			throws SQLException {
		try{
			client.startTransaction();
			
			String no_seq;
			if("0".intern() == noticeInfo.getNo_seq().intern()){
				no_seq = (String) client.queryForObject("Notice.incrementSEQ", noticeInfo);
			}else{
				client.update("Notice.updateSEQ", noticeInfo);
				no_seq = String.valueOf(Integer.parseInt(noticeInfo.getNo_seq())+1);
			}
			noticeInfo.setNo_seq(no_seq);
			
			String no_depth = String.valueOf(Integer.parseInt(noticeInfo.getNo_depth())+1);
			noticeInfo.setNo_depth(no_depth);
			client.insert("Notice.insertNoticeVOReply", noticeInfo);
			
			client.commitTransaction();
			
		}finally{
			client.endTransaction();
		}
	}
	
	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("notice.totalCount",params);
	}

}
