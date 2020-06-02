package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.Fileitem_boardVO;

public interface IFileItem_boardDAO {
   public void insertFileItem(List<Fileitem_boardVO> fileItemList) throws SQLException;
   public Fileitem_boardVO fileitemInfo(Map<String, String> params) throws SQLException;
}