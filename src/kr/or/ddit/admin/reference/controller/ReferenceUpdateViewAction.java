package kr.or.ddit.admin.reference.controller;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;

import kr.or.ddit.reference.service.IReferenceService;
import kr.or.ddit.reference.service.IReferenceServiceImp;
import kr.or.ddit.vo.ReferenceVO;

public class ReferenceUpdateViewAction implements Action{

	private String re_no;
	private ReferenceVO referenceInfo;
	
	@Override
	public String execute() throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("re_no", this.re_no);
		
		IReferenceService service = IReferenceServiceImp.getInstance();
		this.referenceInfo = service.referenceInfo(params);
		
		return "success";
	}

	public String getRe_no() {
		return re_no;
	}

	public void setRe_no(String re_no) {
		this.re_no = re_no;
	}

	public ReferenceVO getReferenceInfo() {
		return referenceInfo;
	}
	
}
