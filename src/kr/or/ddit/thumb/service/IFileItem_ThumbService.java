package kr.or.ddit.thumb.service;

import java.util.Map;

import kr.or.ddit.vo.Fileitem_imageboardVO;

public interface IFileItem_ThumbService {
	public Fileitem_imageboardVO fileitemInfo(Map<String, String> params);
}
