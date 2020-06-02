package kr.or.ddit.reference.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.ReferenceVO;

public class IReferenceDaoImp implements IReferenceDao {
	private static IReferenceDao dao = new IReferenceDaoImp();
	private SqlMapClient client; 
	
	private IReferenceDaoImp() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IReferenceDao getInstance(){
		return (dao == null) ? dao = new IReferenceDaoImp() : dao;
	}

	@Override
	public ReferenceVO referenceInfo(Map<String, String> params)
			throws SQLException {
		ReferenceVO referenceInfo = null;
		
		try {
			client.startTransaction();
			
			client.update("reference.updateHIT", params);
			referenceInfo = (ReferenceVO) client.queryForObject("reference.referenceInfo", params);
			
			client.commitTransaction();
		} finally {
			client.endTransaction();
		}
		return referenceInfo;
	}

	@Override
	public List<ReferenceVO> referenceList(Map<String, String> params)
			throws SQLException {
		return client.queryForList("reference.referenceList", params);
	}

	@Override
	public List<ReferenceVO> referenceList() throws SQLException {
		return client.queryForList("reference.referenceList");
	}

	@Override
	public String insertReferenceInfo(ReferenceVO referenceInfo)
			throws SQLException {
		return (String) client.insert("reference.insertReference", referenceInfo);
	}

	@Override
	public void updateReferenceInfo(ReferenceVO referenceInfo)
			throws SQLException {
		client.update("reference.updateReference", referenceInfo);
	}

	@Override
	public void deleteReferenceInfo(Map<String, String> params)
			throws SQLException {
		client.update("reference.deleteReference", params);
	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("reference.totalCount", params);
	}

	@Override
	public void insertReferenceReply(ReferenceVO referenceInfo) throws SQLException {
		
		try {
			client.startTransaction();
			
			String re_seq;
			if("0".intern() == referenceInfo.getRe_seq().intern() ) {
				re_seq = (String) client.queryForObject("reference.incrementSEQ", referenceInfo);
			} else {
				client.update("reference.updateSEQ", referenceInfo);
				re_seq = String.valueOf(Integer.parseInt(referenceInfo.getRe_seq()) + 1);
			}
			referenceInfo.setRe_seq(re_seq);
			
			String re_depth = String.valueOf(Integer.parseInt(referenceInfo.getRe_depth()) + 1);
			referenceInfo.setRe_depth(re_depth);
			client.insert("reference.insertReferenceVOReply", referenceInfo);
			
			client.commitTransaction();
			
		} finally {
			client.endTransaction();
		}
		
	}
}
