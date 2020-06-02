package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.dao.IMemberDaoImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.StatisticsVO;

public class IMemberServiceImpl implements IMemberService {

	private static IMemberService service = new IMemberServiceImpl();
	private IMemberDAO dao;
	
	private IMemberServiceImpl() {
		dao = IMemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		return (service == null) ? service = new IMemberServiceImpl() : service;
	}

	@Override
	public List<MemberVO> memberList() {
		List<MemberVO> memberList = null;
		try {
			memberList = dao.memberList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}

	@Override
	public List<MemberVO> memberList(Map<String, String> params) {
		List<MemberVO> list = null;
		
		try {
			list = dao.memberList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public MemberVO memberInfo(Map<String, String> params) {
		MemberVO info = null;
		
		try {
			info = dao.memberInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return info;
	}

	@Override
	public void insertMember(MemberVO memberInfo) {
		try {
			dao.insertMember(memberInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateMember(MemberVO memberInfo) {
		try {
			dao.updateMember(memberInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMember(MemberVO memberInfo) {
		try {
			dao.deleteMember(memberInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String count = "0";
		try {
			count = dao.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public void OutMember(Map<String, String> params){
		try {
			dao.OutMember(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<StatisticsVO> genderChart() {
		List<StatisticsVO> gender = null;
		try {
			gender = dao.genderChart();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gender;
	}
	
	@Override
	public List<StatisticsVO> ageChart() {
		List<StatisticsVO> age = null;
		try {
			age = dao.ageChart();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return age;
	}
	@Override
	public List<StatisticsVO> boardChart() {
		List<StatisticsVO> board = null;
		try {
			board = dao.boardChart();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	@Override
	public List<StatisticsVO> dropoutChart() {
		List<StatisticsVO> dropout = null;
		try {
			dropout = dao.dropoutChart();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dropout;
	}
	@Override
	public List<StatisticsVO> joinChart() {
		List<StatisticsVO> join = null;
		try {
			join = dao.joinChart();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return join;
	}

	@Override
	public List<StatisticsVO> imageBoardChart() {
		List<StatisticsVO> board = null;
		try {
			board = dao.imageBoardChart();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public List<StatisticsVO> qandaChart() {
		List<StatisticsVO> board = null;
		try {
			board = dao.qandaChart();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public List<StatisticsVO> referenceChart() {
		List<StatisticsVO> board = null;
		try {
			board = dao.referenceChart();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public List<StatisticsVO> noticeChart() {
		List<StatisticsVO> board = null;
		try {
			board = dao.noticeChart();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	
}
