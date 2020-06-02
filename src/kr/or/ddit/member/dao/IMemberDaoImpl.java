package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.StatisticsVO;

public class IMemberDaoImpl implements IMemberDAO {
	
	private static IMemberDAO dao = new IMemberDaoImpl();
	private SqlMapClient client;
	
	private IMemberDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IMemberDAO getInstance() {
		return (dao == null) ? dao = new IMemberDaoImpl() : dao;
	}

	@Override
	public List<MemberVO> memberList() throws SQLException {
		return client.queryForList("member.memberList");
	}

	@Override
	public List<MemberVO> memberList(Map<String, String> params) throws SQLException {
		return client.queryForList("member.memberList", params);
	}

	@Override
	public MemberVO memberInfo(Map<String, String> params) throws SQLException {
		return (MemberVO) client.queryForObject("member.memberInfo", params);
	}

	@Override
	public void insertMember(MemberVO memberInfo) throws SQLException {
		client.insert("member.insertMem", memberInfo);
	}

	@Override
	public void updateMember(MemberVO memberInfo) throws SQLException {
		client.update("member.updateMem", memberInfo);
	}

	@Override
	public void deleteMember(MemberVO memberInfo) throws SQLException {
		client.update("member.deleteMem", memberInfo);
	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("member.totalCount", params);
	}

	@Override
	public void OutMember(Map<String, String> params) throws SQLException {
		client.update("member.OutMem", params);
	}

	@Override
	public List<StatisticsVO> genderChart() throws SQLException {
		return client.queryForList("member.genderRate");
	}
	
	@Override
	public List<StatisticsVO> ageChart() throws SQLException {
		return client.queryForList("member.ageRate");
	}
	@Override
	public List<StatisticsVO> boardChart() throws SQLException {
		return client.queryForList("member.boardRate");
	}
	@Override
	public List<StatisticsVO> dropoutChart() throws SQLException {
		return client.queryForList("member.dropoutRate");
	}
	@Override
	public List<StatisticsVO> joinChart() throws SQLException {
		return client.queryForList("member.joinRate");
	}

	@Override
	public List<StatisticsVO> imageBoardChart() throws SQLException {
		return client.queryForList("member.imageBoardRate");
	}

	@Override
	public List<StatisticsVO> qandaChart() throws SQLException {
		return client.queryForList("member.qandaRate");
	}

	@Override
	public List<StatisticsVO> referenceChart() throws SQLException {
		return client.queryForList("member.referenceRate");
	}

	@Override
	public List<StatisticsVO> noticeChart() throws SQLException {
		return client.queryForList("member.noticeRate");
	}
	
}
