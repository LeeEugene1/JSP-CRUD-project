package kr.or.ddit.notice.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.NoticeVO;

public interface INoticeService {
	public NoticeVO noticeInfo(Map<String, String> params);
	public List<NoticeVO> noticeList(Map<String, String> params);
	public List<NoticeVO> noticeList();
	public void insertNoticeInfo(NoticeVO noticeInfo, File[] items, List<String> contentTypes);
	public void insertNoticeReply(NoticeVO noticeInfo);
	public void updateNoticeInfo(NoticeVO freeboardInfo);
	public void deleteNoticeInfo(Map<String, String> params);
	public String totalCount(Map<String, String> params);
}
