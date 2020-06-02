package kr.or.ddit.admin.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.INoticeServiceImp;
import kr.or.ddit.utiles.RolePagingUtile;
import kr.or.ddit.vo.NoticeVO;

public class NoticeListAction {
	
	private List<NoticeVO> noticeList;
	
	public String execute() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentPage = request.getParameter("currentPage");
		
		if (currentPage == null) {
			currentPage = "1";
		}
		
		String search_keycode = request.getParameter("search_keycode");
		String search_keyword = request.getParameter("search_keyword");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		INoticeService service = INoticeServiceImp.getInstance();
		String totalCount = service.totalCount(params);
		
		RolePagingUtile paginUtil = new RolePagingUtile(request, Integer.parseInt(totalCount), Integer.parseInt(currentPage));
		
		String startCount = String.valueOf(paginUtil.getStartCount());
		String endCount = String.valueOf(paginUtil.getEndCount());
		
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		this.noticeList = service.noticeList(params);
		
		request.setAttribute("pagingUtil", paginUtil.getPagingHtmls());
		request.setAttribute("noticeList", this.noticeList);
		
		return "success";
	}

	public List<NoticeVO> getNoticeList() {
		return noticeList;
	}

}
