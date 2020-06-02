package kr.or.ddit.qnada.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.QandaVO;

public interface IQnadaDao {
	public QandaVO qandaInfo(Map<String, String> params) throws SQLException;
	public List<QandaVO> qnadaList(Map<String, String> params) throws SQLException;
	public List<QandaVO> qnadaList() throws SQLException;
	public String insertQnadaInfo(QandaVO qnadaInfo) throws SQLException;
	public void updateQnadaInfo(QandaVO qnadaInfo) throws SQLException;
	public void deleteQnadaInfo(Map<String, String> params) throws SQLException;
	public String totalCount(Map<String, String> params) throws SQLException;
	public void insertQandaReply(QandaVO qandaInfo) throws SQLException;
}