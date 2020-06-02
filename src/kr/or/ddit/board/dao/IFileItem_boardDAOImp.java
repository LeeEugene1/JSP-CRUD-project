package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.Fileitem_boardVO;

public class IFileItem_boardDAOImp implements IFileItem_boardDAO {
	private static IFileItem_boardDAO dao = new IFileItem_boardDAOImp();
	private SqlMapClient client; 
	
	private IFileItem_boardDAOImp(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IFileItem_boardDAO getInstance(){
		return (dao == null) ? dao = new IFileItem_boardDAOImp() : dao;
	}
	
	@Override
	public void insertFileItem(List<Fileitem_boardVO> fileItemList)
	         throws SQLException {
	      try {
	         client.startTransaction();
	         
	         for (Fileitem_boardVO fileItemInfo : fileItemList) {   
	            client.insert("fileitemBoard.insertFileItemBoard", fileItemInfo);
	         }
	         client.commitTransaction();
	      } finally {
	         client.endTransaction();
	      }

	   }

	@Override
	public Fileitem_boardVO fileitemInfo(Map<String, String> params)
			throws SQLException {
		
		return (Fileitem_boardVO) client.queryForObject("fileitemBoard.fileitemBoardInfo", params);
	}


	
}
