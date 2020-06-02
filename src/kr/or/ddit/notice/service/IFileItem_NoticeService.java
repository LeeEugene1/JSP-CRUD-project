package kr.or.ddit.notice.service;

import java.util.Map;

import kr.or.ddit.vo.Fileitem_noticeVO;

public interface IFileItem_NoticeService {
	public Fileitem_noticeVO fileitemInfo(Map<String, String> params);
}
