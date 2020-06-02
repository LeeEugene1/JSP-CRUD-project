package kr.or.ddit.user.thumb.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.thumb.service.IThumbService;
import kr.or.ddit.thumb.service.IThumbServiceImpl;

public class DeleteThumbAction {
	
	private String im_no;
	private String message;
	
	public String execute() throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("im_no", im_no);
		
		IThumbService service = IThumbServiceImpl.getInstance();
		service.deleteThumbInfo(params);
		
		this.message = URLEncoder.encode("게시물을 삭제하였습니다", "UTF-8");
		
		return "success";
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setIm_no(String im_no) {
		this.im_no = im_no;
	}

}
