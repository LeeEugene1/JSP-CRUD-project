package kr.or.ddit.member.dao;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.StatisticsVO;

public interface IMemberDAO {
	public List<MemberVO> memberList() throws SQLException;
	public List<MemberVO> memberList(Map<String, String> params) throws SQLException;
	public MemberVO memberInfo(Map<String, String> params) throws SQLException;
	public void insertMember(MemberVO memberInfo) throws SQLException;
	public void updateMember(MemberVO memberInfo) throws SQLException;
	public void deleteMember(MemberVO memberInfo) throws SQLException;
	public String totalCount(Map<String, String> params) throws SQLException;
	public void OutMember(Map<String, String> params) throws SQLException;
	public List<StatisticsVO> genderChart() throws SQLException;
	public List<StatisticsVO> ageChart() throws SQLException;
	public List<StatisticsVO> boardChart() throws SQLException;
	public List<StatisticsVO> imageBoardChart() throws SQLException;
	public List<StatisticsVO> qandaChart() throws SQLException;
	public List<StatisticsVO> referenceChart() throws SQLException;
	public List<StatisticsVO> noticeChart() throws SQLException;
	public List<StatisticsVO> dropoutChart() throws SQLException;
	public List<StatisticsVO> joinChart() throws SQLException;
	
}
