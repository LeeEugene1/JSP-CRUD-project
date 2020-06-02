package kr.or.ddit.board.service;

import java.util.Map;

import kr.or.ddit.vo.Fileitem_boardVO;

public interface IFileItem_boardService {
	public Fileitem_boardVO fileitemInfo(Map<String, String> params);
}
