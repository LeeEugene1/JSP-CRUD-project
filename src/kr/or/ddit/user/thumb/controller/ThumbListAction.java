package kr.or.ddit.user.thumb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.thumb.service.IThumbService;
import kr.or.ddit.thumb.service.IThumbServiceImpl;
import kr.or.ddit.utiles.RolePagingUtile;
import kr.or.ddit.vo.Fileitem_imageboardVO;
import kr.or.ddit.vo.ThumbVO;

public class ThumbListAction {
private List<ThumbVO> thumbList;
private ThumbVO thumOne;

private Fileitem_imageboardVO fileitemInfo;
	
	public String execute(){
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

		IThumbService service = IThumbServiceImpl.getInstance();
		String totalCount = service.totalCount(params);
		
		RolePagingUtile paginUtil = new RolePagingUtile(request, Integer.parseInt(totalCount), Integer.parseInt(currentPage));
		
		String startCount = String.valueOf(paginUtil.getStartCount());
		String endCount = String.valueOf(paginUtil.getEndCount());
		
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		this.thumbList = service.thumbList(params);
		this.thumOne = thumbList.get(0);		
		
		request.setAttribute("pagingUtil", paginUtil.getPagingHtmls());
		request.setAttribute("thumbList", this.thumbList);
		
		return "success";
	}
	
	public List<ThumbVO> getThumbList(){
		return thumbList;
	}
}



