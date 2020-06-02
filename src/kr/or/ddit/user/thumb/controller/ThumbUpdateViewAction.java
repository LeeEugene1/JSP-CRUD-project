package kr.or.ddit.user.thumb.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.thumb.service.IThumbService;
import kr.or.ddit.thumb.service.IThumbServiceImpl;
import kr.or.ddit.vo.ThumbVO;

import com.opensymphony.xwork2.Action;

public class ThumbUpdateViewAction implements Action {

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

	public String getim_no() {
		return im_no;
	}

	public String getIm_no() {
		return im_no;
	}

	public void setIm_no(String im_no) {
		this.im_no = im_no;
	}

	public void setim_no(String im_no) {
		this.im_no = im_no;
	}

	public ThumbVO getThumbInfo() {
		return thumbInfo;
	}




}
