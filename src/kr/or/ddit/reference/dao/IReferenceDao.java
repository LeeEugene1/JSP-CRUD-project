package kr.or.ddit.reference.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ReferenceVO;

public interface IReferenceDao {
	public ReferenceVO referenceInfo(Map<String, String> params) throws SQLException;
	public List<ReferenceVO> referenceList(Map<String, String> params) throws SQLException;
	public List<ReferenceVO> referenceList() throws SQLException;
	public String insertReferenceInfo(ReferenceVO referenceInfo) throws SQLException;
	public void updateReferenceInfo(ReferenceVO referenceInfo) throws SQLException;
	public void deleteReferenceInfo(Map<String, String> params) throws SQLException;
	public void insertReferenceReply(ReferenceVO referenceInfo) throws SQLException;
	public String totalCount(Map<String, String> params) throws SQLException;

}
