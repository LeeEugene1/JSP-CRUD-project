package kr.or.ddit.qnada.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.QandaVO;

public class IQnadaDaoImpl implements IQnadaDao {
	
	private static IQnadaDao dao = new IQnadaDaoImpl();
	private SqlMapClient client;
	
	private IQnadaDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}

	public static IQnadaDao getInstance() {
		return (dao == null) ? dao = new IQnadaDaoImpl() : dao;
	}

	@Override
	public QandaVO qandaInfo(Map<String, String> params) throws SQLException {
		QandaVO qandaInfo = null;
		try {
			client.startTransaction();
			qandaInfo = (QandaVO) client.queryForObject("qanda.qandaInfo", params);
			client.update("qanda.updateHIT", params);
			client.commitTransaction();
		} finally{
			client.endTransaction();
		}
		return qandaInfo;
	}

	@Override
	public List<QandaVO> qnadaList(Map<String, String> params)
			throws SQLException {
		return client.queryForList("qanda.qandaList", params);
	}

	@Override
	public List<QandaVO> qnadaList() throws SQLException {
		return client.queryForList("qanda.qandaList");
	}

	@Override
	public String insertQnadaInfo(QandaVO qnadaInfo) throws SQLException {
		return (String) client.insert("qanda.insertQanda", qnadaInfo);
	}

	@Override
	public void updateQnadaInfo(QandaVO qnadaInfo) throws SQLException {
		client.update("qanda.updateQanda", qnadaInfo);
	}

	@Override
	public void deleteQnadaInfo(Map<String, String> params) throws SQLException {
		client.delete("qanda.deleteQanda", params);
	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("qanda.totalCount", params);
	}

	@Override
	public void insertQandaReply(QandaVO qandaInfo) throws SQLException {
		try {
			
			client.startTransaction();
			String qa_seq;
			if ("0".intern() == qandaInfo.getQa_seq().intern()){
				qa_seq = (String) client.queryForObject("qanda.incrementSEQ", qandaInfo);
			}else{
				client.update("qanda.updateSEQ", qandaInfo);
				qa_seq = String.valueOf(Integer.parseInt(qandaInfo.getQa_seq())+1);
			}
			qandaInfo.setQa_seq(qa_seq);
			
			String qa_depth = String.valueOf(Integer.parseInt(qandaInfo.getQa_depth())+1);
			qandaInfo.setQa_depth(qa_depth);
			client.insert("qanda.insertQandaReply",qandaInfo);
			
			client.commitTransaction();
			
		} finally {
			client.endTransaction();
		}
	}

}
