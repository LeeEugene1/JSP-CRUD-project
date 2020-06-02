package kr.or.ddit.admin.chart.controller;

import java.util.List;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.StatisticsVO;

public class DropoutChartAction {
	
	private List<StatisticsVO> dropoutInfo;
	private String dropout;
	
	public String execute() {
		IMemberService service = IMemberServiceImpl.getInstance();
		this.dropoutInfo = service.dropoutChart();
		
		return "success";
	}

	public List<StatisticsVO> getDropoutInfo() {
		return dropoutInfo;
	}

	public String getDropout() {
		return dropout;
	}

}
