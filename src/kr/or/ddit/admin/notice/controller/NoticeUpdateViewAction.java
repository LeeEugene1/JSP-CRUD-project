package kr.or.ddit.admin.notice.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.INoticeServiceImp;
import kr.or.ddit.vo.NoticeVO;

import com.opensymphony.xwork2.Action;

public class NoticeUpdateViewAction implements Action {

	private String no_no;
	private NoticeVO noticeInfo;

	@Override
	public String execute() throws Exception {

		Map<String, String> params = new HashMap<String, String>();
		params.put("no_no", this.no_no);

		INoticeService service = INoticeServiceImp.getInstance();
		this.noticeInfo = service.noticeInfo(params);

		return "success";
	}

	public String getNo_no() {
		return no_no;
	}

	public void setNo_no(String no_no) {
		this.no_no = no_no;
	}

	public NoticeVO getNoticeInfo() {
		return noticeInfo;
	}
}
