package kr.or.ddit.admin.qanda.controller;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;

import kr.or.ddit.qnada.service.IQnadaService;
import kr.or.ddit.qnada.service.IQnadaServiceImpl;
import kr.or.ddit.vo.QandaVO;

public class QandaViewAction implements Action{
	
	private String qa_no;
	private QandaVO qandaInfo;
	
	@Override
	public String execute() throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("qa_no", this.qa_no);
		
		IQnadaService service = IQnadaServiceImpl.getInstance();
		this.qandaInfo = service.qandaInfo(params);
		
		return "success";
	}

	public String getQa_no() {
		return qa_no;
	}

	public void setQa_no(String qa_no) {
		this.qa_no = qa_no;
	}

	public QandaVO getQandaInfo() {
		return qandaInfo;
	}

}
