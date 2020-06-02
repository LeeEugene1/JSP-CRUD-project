package kr.or.ddit.admin.chart.controller;

import java.util.List;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.StatisticsVO;

public class JoinChartAction {
	
	private List<StatisticsVO> joinInfo;
	private String join;
	
	public String execute() {
		IMemberService service = IMemberServiceImpl.getInstance();
		this.joinInfo = service.joinChart();
		
		return "success";
	}

	public List<StatisticsVO> getJoinInfo() {
		return joinInfo;
	}

	public String getJoin() {
		return join;
	}


}
