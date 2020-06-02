package kr.or.ddit.reference.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.Fileitem_referenceVO;

public interface IFileItem_referenceDAO {
   public void insertFileItem(List<Fileitem_referenceVO> fileItemList) throws SQLException;
   public Fileitem_referenceVO fileitemInfo(Map<String, String> params) throws SQLException;
}