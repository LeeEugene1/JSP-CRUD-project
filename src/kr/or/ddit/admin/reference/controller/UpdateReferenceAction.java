package kr.or.ddit.admin.reference.controller;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.ddit.reference.service.IReferenceService;
import kr.or.ddit.reference.service.IReferenceServiceImp;
import kr.or.ddit.vo.ReferenceVO;

public class UpdateReferenceAction implements ModelDriven<ReferenceVO> {

	private ReferenceVO referenceInfo;
	
	public String execute() {
		
		IReferenceService service = IReferenceServiceImp.getInstance();
		service.updateReferenceInfo(referenceInfo);;
		
		return "success";
	}

	@Override
	public ReferenceVO getModel() {
		this.referenceInfo = new ReferenceVO();
		return referenceInfo;
	}
	
}
