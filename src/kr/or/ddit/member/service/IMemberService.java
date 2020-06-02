package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.StatisticsVO;

public interface IMemberService {
	public List<MemberVO> memberList();
	public List<MemberVO> memberList(Map<String, String> params);
	public MemberVO memberInfo(Map<String, String> params);
	public void insertMember(MemberVO memberInfo);
	public void updateMember(MemberVO memberInfo);
	public void deleteMember(MemberVO memberInfo);
	public String totalCount(Map<String, String> params);
	public void OutMember(Map<String, String> params);
	public List<StatisticsVO> genderChart();
	public List<StatisticsVO> ageChart();
	public List<StatisticsVO> boardChart();
	public List<StatisticsVO> imageBoardChart();
	public List<StatisticsVO> qandaChart();
	public List<StatisticsVO> referenceChart();
	public List<StatisticsVO> noticeChart();
	public List<StatisticsVO> dropoutChart();
	public List<StatisticsVO> joinChart();
}
