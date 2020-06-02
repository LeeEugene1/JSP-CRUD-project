package kr.or.ddit.user.reference.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.reference.service.IReferenceService;
import kr.or.ddit.reference.service.IReferenceServiceImp;

public class DeleteReferenceAction {
	private String re_no;
	private String message;
	
	public String deleteReferenceInfo() throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("re_no", re_no);
		
		IReferenceService service = IReferenceServiceImp.getInstance();
		service.deleteReferenceInfo(params);
		
		this.message = URLEncoder.encode("게시물을 삭제하였습니다.", "UTF-8");
		
		return "success";
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setRe_no(String re_no) {
		this.re_no = re_no;
	}
}
