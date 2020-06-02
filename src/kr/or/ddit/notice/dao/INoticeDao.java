package kr.or.ddit.notice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.NoticeVO;

public interface INoticeDao {
	public NoticeVO noticeInfo(Map<String, String> params) throws SQLException;
	public List<NoticeVO> noticeList(Map<String, String> params) throws SQLException;
	public List<NoticeVO> noticeList() throws SQLException;
	public String insertNoticeInfo(NoticeVO freeboardInfo) throws SQLException;
	public void insertNoticeReply(NoticeVO noticeInfo) throws SQLException;
	public void updateNoticeInfo(NoticeVO freeboardInfo) throws SQLException;
	public void deleteNoticeInfo(Map<String, String> params) throws SQLException;
	public String totalCount(Map<String, String> params) throws SQLException;

}
