package kr.or.ddit.thumb.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.Fileitem_imageboardVO;

public class IFileItem_ThumbDAOImp implements IFileItem_ThumbDAO {
	private static IFileItem_ThumbDAO dao = new IFileItem_ThumbDAOImp();
	private SqlMapClient client; 
	
	private IFileItem_ThumbDAOImp(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IFileItem_ThumbDAO getInstance(){
		return (dao == null) ? dao = new IFileItem_ThumbDAOImp() : dao;
	}
	
	@Override
	public void insertFileItem(List<Fileitem_imageboardVO> fileItemList)
	         throws SQLException {
	      try {
	         client.startTransaction();
	         
	         for (Fileitem_imageboardVO fileItemInfo : fileItemList) {   // 2번 진행
	            client.insert("fileitemThumb.insertFileItemThumb", fileItemInfo);
	         }
	         client.commitTransaction();
	      } finally {
	         client.endTransaction();
	      }

	   }

	@Override
	public Fileitem_imageboardVO fileitemInfo(Map<String, String> params)
			throws SQLException {
		
		return (Fileitem_imageboardVO) client.queryForObject("fileitemThumb.fileitemThumbInfo", params);
	}


	
}
