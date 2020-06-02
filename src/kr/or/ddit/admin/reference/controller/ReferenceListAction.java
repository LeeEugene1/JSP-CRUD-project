package kr.or.ddit.admin.reference.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.reference.service.IReferenceService;
import kr.or.ddit.reference.service.IReferenceServiceImp;
import kr.or.ddit.utiles.RolePagingUtile;
import kr.or.ddit.vo.ReferenceVO;

public class ReferenceListAction {

	private List<ReferenceVO> referenceList;
	
	public String execute() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentPage = request.getParameter("currentPage");
		
		if ( currentPage == null ) {
			currentPage = "1";
		}
		
		String search_keycode = request.getParameter("search_keycode");
		String search_keyword = request.getParameter("search_keyword");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		IReferenceService service = IReferenceServiceImp.getInstance();
		String totalCount = service.totalCount(params);
		
		RolePagingUtile paginUtil = new RolePagingUtile(request, Integer.parseInt(totalCount), Integer.parseInt(currentPage));
		
		String startCount = String.valueOf(paginUtil.getStartCount());
		String endCount = String.valueOf(paginUtil.getEndCount());
		
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		this.referenceList = service.referenceList(params);
		
		request.setAttribute("pagingUtil", paginUtil.getPagingHtmls());
		request.setAttribute("referenceList", this.referenceList);
		
		return "success";
		
	}

	public List<ReferenceVO> getReferenceList() {
		return referenceList;
	}
	
}
