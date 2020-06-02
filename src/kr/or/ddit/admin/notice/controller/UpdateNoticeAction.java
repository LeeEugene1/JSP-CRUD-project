package kr.or.ddit.admin.notice.controller;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.INoticeServiceImp;
import kr.or.ddit.vo.NoticeVO;

import com.opensymphony.xwork2.ModelDriven;

public class UpdateNoticeAction implements ModelDriven<NoticeVO> {
	
	private NoticeVO noticeInfo;
	
	public String execute() {
		INoticeService service = INoticeServiceImp.getInstance();
		service.updateNoticeInfo(noticeInfo);
		
		return "success";
	}

	@Override
	public NoticeVO getModel() {
		
		this.noticeInfo = new NoticeVO();
		return noticeInfo;
	}
}
