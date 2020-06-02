package kr.or.ddit.notice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.Fileitem_noticeVO;

public interface IFileItem_NoticeDAO {
   public void insertFileItem(List<Fileitem_noticeVO> fileItemList) throws SQLException;
   public Fileitem_noticeVO fileitemInfo(Map<String, String> params) throws SQLException;
}