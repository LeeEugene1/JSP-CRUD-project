package kr.or.ddit.thumb.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ThumbVO;

public interface IThumbDao {
	public ThumbVO thumbInfo(Map<String, String> params) throws SQLException;
	public List<ThumbVO> thumbList(Map<String, String> params) throws SQLException;
	public List<ThumbVO> thumbList() throws SQLException;
	public String insertThumbInfo(ThumbVO thumbInfo) throws SQLException;
	public void updateThumbInfo(ThumbVO thumbInfo) throws SQLException;
	public void deleteThumbInfo(Map<String, String> params) throws SQLException;
	public String totalCount(Map<String, String> params) throws SQLException;
	public void insertThumbReply(ThumbVO thumbInfo) throws SQLException;
}