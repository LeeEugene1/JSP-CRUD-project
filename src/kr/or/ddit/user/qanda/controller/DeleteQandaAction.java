package kr.or.ddit.user.qanda.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.qnada.service.IQnadaService;
import kr.or.ddit.qnada.service.IQnadaServiceImpl;

public class DeleteQandaAction {
	
	private String qa_no;
	private String message;
	
	public String deleteQandaInfo() throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("qa_no", qa_no);
		
		IQnadaService service = IQnadaServiceImpl.getInstance();
		service.deleteQnadaInfo(params);
		
		this.message = URLEncoder.encode("게시물을 삭제하였습니다", "UTF-8");
		
		return "success";
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setQa_no(String qa_no) {
		this.qa_no = qa_no;
	}

	
}
