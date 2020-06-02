package kr.or.ddit.admin.freeboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.IBoardServiceImpl;
import kr.or.ddit.utiles.RolePagingUtile;
import kr.or.ddit.vo.BoardVO;

public class BoardListAction {
	
	private List<BoardVO> boardList;
	String search_keycode;
	String search_keyword;
	
	public String getSearch_keycode() {
		return search_keycode;
	}

	public void setSearch_keycode(String search_keycode) {
		this.search_keycode = search_keycode;
	}

	public String getSearch_keyword() {
		return search_keyword;
	}

	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}

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
		
		IBoardService service = IBoardServiceImpl.getInstance();
		String totalCount = service.totalCount(params);
		
		RolePagingUtile paginUtil = new RolePagingUtile(request, Integer.parseInt(totalCount), Integer.parseInt(currentPage));
		
		String startCount = String.valueOf(paginUtil.getStartCount());
		String endCount = String.valueOf(paginUtil.getEndCount());
		
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		this.boardList = service.boardList(params);
		
		request.setAttribute("pagingUtil", paginUtil.getPagingHtmls());
		request.setAttribute("noticeList", this.boardList);
		
		return "success";
	}

	public List<BoardVO> getBoardList() {
		return boardList;
	}
}
