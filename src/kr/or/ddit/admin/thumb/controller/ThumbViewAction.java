package kr.or.ddit.admin.thumb.controller;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;

import kr.or.ddit.thumb.service.IThumbService;
import kr.or.ddit.thumb.service.IThumbServiceImpl;
import kr.or.ddit.vo.ThumbVO;

public class ThumbViewAction implements Action{
	
	private String im_no;
	private ThumbVO thumbInfo;
	
	@Override
	public String execute() throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("im_no", this.im_no);
		
		IThumbService service = IThumbServiceImpl.getInstance();
		this.thumbInfo = service.thumbInfo(params);
		
		return "success";
	}

	public String getIm_no() {
		return im_no;
	}

	public void setIm_no(String im_no) {
		this.im_no = im_no;
	}

	public ThumbVO getThumbInfo() {
		return thumbInfo;
	}

	public void setThumbInfo(ThumbVO thumbInfo) {
		this.thumbInfo = thumbInfo;
	}


}
