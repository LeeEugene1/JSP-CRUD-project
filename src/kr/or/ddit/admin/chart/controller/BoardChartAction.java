package kr.or.ddit.admin.chart.controller;

import java.util.List;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.StatisticsVO;

public class BoardChartAction {
	
	private List<StatisticsVO> boardInfo;
	private List<StatisticsVO> imageboardInfo;
	private List<StatisticsVO> qandaInfo;
	private List<StatisticsVO> referenceInfo;
	private List<StatisticsVO> noticeInfo;
	private String board;
	
	public String execute() {
		IMemberService service = IMemberServiceImpl.getInstance();
		this.boardInfo = service.boardChart();
		this.imageboardInfo = service.imageBoardChart();
		this.qandaInfo = service.qandaChart();
		this.referenceInfo = service.referenceChart();
		this.noticeInfo = service.noticeChart();
		
		return "success";
	}

	public List<StatisticsVO> getBoardInfo() {
		return boardInfo;
	}

	public List<StatisticsVO> getImageboardInfo() {
		return imageboardInfo;
	}

	public List<StatisticsVO> getQandaInfo() {
		return qandaInfo;
	}

	public List<StatisticsVO> getReferenceInfo() {
		return referenceInfo;
	}

	public List<StatisticsVO> getNoticeInfo() {
		return noticeInfo;
	}

	public String getBoard() {
		return board;
	}

}
