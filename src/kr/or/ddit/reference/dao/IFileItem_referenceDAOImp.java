package kr.or.ddit.reference.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.Fileitem_referenceVO;

public class IFileItem_referenceDAOImp implements IFileItem_referenceDAO {
	private static IFileItem_referenceDAO dao = new IFileItem_referenceDAOImp();
	private SqlMapClient client; 
	
	private IFileItem_referenceDAOImp(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IFileItem_referenceDAO getInstance(){
		return (dao == null) ? dao = new IFileItem_referenceDAOImp() : dao;
	}
	
	@Override
	public void insertFileItem(List<Fileitem_referenceVO> fileItemList)
	         throws SQLException {
	      try {
	         client.startTransaction();
	         
	         for (Fileitem_referenceVO fileItemInfo : fileItemList) {  
	            client.insert("fileitemReference.insertFileItemReference", fileItemInfo);
	         }
	         client.commitTransaction();
	      } finally {
	         client.endTransaction();
	      }

	   }

	@Override
	public Fileitem_referenceVO fileitemInfo(Map<String, String> params)
			throws SQLException {
		
		return (Fileitem_referenceVO) client.queryForObject("fileitemReference.fileitemReferenceInfo", params);
	}


	
}
