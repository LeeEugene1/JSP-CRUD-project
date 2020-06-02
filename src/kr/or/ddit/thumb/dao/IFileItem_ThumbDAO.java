package kr.or.ddit.thumb.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.Fileitem_imageboardVO;

public interface IFileItem_ThumbDAO {
   public void insertFileItem(List<Fileitem_imageboardVO> fileItemList) throws SQLException;
   public Fileitem_imageboardVO fileitemInfo(Map<String, String> params) throws SQLException;
}