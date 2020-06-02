package kr.or.ddit.thumb.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.ThumbVO;

public class IThumbDaoImpl implements IThumbDao {
	
	private static IThumbDao dao = new IThumbDaoImpl();
	private SqlMapClient client;
	
	private IThumbDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}

	public static IThumbDao getInstance() {
		return (dao == null) ? dao = new IThumbDaoImpl() : dao;
	}

	@Override
	public ThumbVO thumbInfo(Map<String, String> params) throws SQLException {
		ThumbVO thumbInfo = null;
		try {
			client.startTransaction();
			thumbInfo = (ThumbVO) client.queryForObject("thumb.thumbInfo", params);
			client.update("thumb.updateHIT", params);
			client.commitTransaction();
		} finally{
			client.endTransaction();
		}
		return thumbInfo;
	}

	@Override
	public List<ThumbVO> thumbList(Map<String, String> params)
			throws SQLException {
		return client.queryForList("thumb.thumbList", params);
	}

	@Override
	public List<ThumbVO> thumbList() throws SQLException {
		return client.queryForList("thumb.thumbList");
	}

	@Override
	public String insertThumbInfo(ThumbVO thumbInfo) throws SQLException {
		return (String) client.insert("thumb.insertThumb", thumbInfo);
	}

	@Override
	public void updateThumbInfo(ThumbVO thumbInfo) throws SQLException {
		client.update("thumb.updateThumb", thumbInfo);
	}

	@Override
	public void deleteThumbInfo(Map<String, String> params) throws SQLException {
		client.delete("thumb.deleteThumb", params);
	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("thumb.totalCount", params);
	}

	@Override
	public void insertThumbReply(ThumbVO thumbInfo) throws SQLException {
		try {
			client.startTransaction();
			String im_seq;
			if ("0".intern() == thumbInfo.getIm_seq().intern()){
				im_seq = (String) client.queryForObject("thumb.incrementSEQ", thumbInfo);
			}else{
				client.update("thumb.updateSEQ", thumbInfo);
				im_seq = String.valueOf(Integer.parseInt(thumbInfo.getIm_seq())+1);
			}
			thumbInfo.setIm_seq(im_seq);
			
			String im_depth = String.valueOf(Integer.parseInt(thumbInfo.getIm_depth())+1);
			thumbInfo.setIm_depth(im_depth);
			client.insert("thumb.insertThumbReply",thumbInfo);
			
			client.commitTransaction();
			
		} finally {
			client.endTransaction();
		}
		
	}
}
