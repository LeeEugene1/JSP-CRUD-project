package kr.or.ddit.user.reference.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.ddit.reference.service.IReferenceService;
import kr.or.ddit.reference.service.IReferenceServiceImp;
import kr.or.ddit.vo.ReferenceVO;

public class InsertReferenceReplyAction implements ModelDriven<ReferenceVO> {
	
	private ReferenceVO referenceInfo;
	private String message;
	
	public String insertReferenceReplyInfo() {
		
		IReferenceService service = IReferenceServiceImp.getInstance();
		service.insertReferenceReply(this.referenceInfo);
		
		try {
			this.message = URLEncoder.encode("답글 등록이 완료되었습니다", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	@Override
	public ReferenceVO getModel() {
		this.referenceInfo = new ReferenceVO();
		return referenceInfo;
	}
	
	public String getMessage() {
		return message;
	}

}
