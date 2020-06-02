package kr.or.ddit.admin.thumb.controller;

import java.net.URLEncoder;

import kr.or.ddit.thumb.service.IThumbService;
import kr.or.ddit.thumb.service.IThumbServiceImpl;
import kr.or.ddit.vo.ThumbVO;

import com.opensymphony.xwork2.ModelDriven;

public class UpdateThumbAction implements ModelDriven<ThumbVO> {
	
	private ThumbVO thumbInfo;
	private String message;
	
	public String execute() throws Exception {
		IThumbService service = IThumbServiceImpl.getInstance();
		service.updateThumbInfo(thumbInfo);
		
		this.message = URLEncoder.encode("게시물을 수정하였습니다", "UTF-8");
		
		return "success";
	}

	@Override
	public ThumbVO getModel() {
		this.thumbInfo = new ThumbVO();
		return thumbInfo;
	}

	public ThumbVO getThumbInfo() {
		return thumbInfo;
	}

	public void setThumbInfo(ThumbVO thumbInfo) {
		this.thumbInfo = thumbInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
