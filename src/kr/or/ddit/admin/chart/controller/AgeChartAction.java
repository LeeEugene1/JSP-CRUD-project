package kr.or.ddit.admin.chart.controller;

import java.util.List;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.StatisticsVO;

public class AgeChartAction {
	
	private List<StatisticsVO> ageInfo;
	private String age;
	
	public String execute() {
		IMemberService service = IMemberServiceImpl.getInstance();
		this.ageInfo = service.ageChart();
		
		return "success";
	}


	public List<StatisticsVO> getAgeInfo() {
		return ageInfo;
	}

	public String getAge() {
		return age;
	}

}
