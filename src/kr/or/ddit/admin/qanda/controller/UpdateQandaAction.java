package kr.or.ddit.admin.qanda.controller;

import kr.or.ddit.qnada.service.IQnadaService;
import kr.or.ddit.qnada.service.IQnadaServiceImpl;
import kr.or.ddit.vo.QandaVO;

import com.opensymphony.xwork2.ModelDriven;

public class UpdateQandaAction implements ModelDriven<QandaVO> {
	
	private QandaVO qandaInfo;
	
	public String execute() {
		IQnadaService service = IQnadaServiceImpl.getInstance();
		service.updateQnadaInfo(qandaInfo);
		
		return "success";
	}

	@Override
	public QandaVO getModel() {
		
		this.qandaInfo = new QandaVO();
		return qandaInfo;
	}
}
