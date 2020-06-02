package kr.or.ddit.thumb.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ThumbVO;

public interface IThumbService {
	public ThumbVO thumbInfo(Map<String, String> params);
	public List<ThumbVO> thumbList(Map<String, String> params);
	public List<ThumbVO> thumbList();
	public String insertThumbInfo(ThumbVO thumbInfo);
	public void updateThumbInfo(ThumbVO thumbInfo);
	public void updateThumbInfo(ThumbVO thumbInfo, File[] items, List<String> contentTypes);
	public void deleteThumbInfo(Map<String, String> params);
	public String totalCount(Map<String, String> params);
	public void insertThumbReply(ThumbVO thumbInfo);
	public void insertThumbInfo(ThumbVO thumbInfo, File[] items, List<String> contentTypes);
}
