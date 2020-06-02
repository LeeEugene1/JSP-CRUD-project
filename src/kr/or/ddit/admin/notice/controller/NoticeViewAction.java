package kr.or.ddit.admin.notice.controller;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.INoticeServiceImp;
import kr.or.ddit.vo.Fileitem_noticeVO;
import kr.or.ddit.vo.NoticeVO;

public class NoticeViewAction implements Action{
	
	private String no_no;
	private NoticeVO noticeInfo;
	private Fileitem_noticeVO fileitemInfo;
	
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
