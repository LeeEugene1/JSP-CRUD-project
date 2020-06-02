package kr.or.ddit.admin.notice.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.INoticeServiceImp;

public class DeleteNoticeAction {
	
	private String no_no;
	private String message;
	
	public String deleteNoticeInfo() throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("no_no", no_no);
		
		INoticeService service = INoticeServiceImp.getInstance();
		service.deleteNoticeInfo(params);
		
		this.message = URLEncoder.encode("게시물을 삭제하였습니다", "UTF-8");
		
		return "success";
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setNo_no(String no_no) {
		this.no_no = no_no;
	}
	
}
