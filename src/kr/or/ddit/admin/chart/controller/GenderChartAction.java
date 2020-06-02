package kr.or.ddit.admin.chart.controller;

import java.util.List;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.StatisticsVO;

public class GenderChartAction {

	private List<StatisticsVO> genderInfo;
	private String gender;
	
	public String execute() {
		IMemberService service = IMemberServiceImpl.getInstance();
		this.genderInfo = service.genderChart();
		
		return "success";
	}

	public List<StatisticsVO> getGenderInfo() {
		return genderInfo;
	}

	public String getGender() {
		return gender;
	}
	
}
