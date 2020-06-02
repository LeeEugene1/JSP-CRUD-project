package kr.or.ddit.thumb.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.thumb.dao.IFileItem_ThumbDAO;
import kr.or.ddit.thumb.dao.IFileItem_ThumbDAOImp;
import kr.or.ddit.thumb.dao.IThumbDao;
import kr.or.ddit.thumb.dao.IThumbDaoImpl;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.vo.Fileitem_imageboardVO;
import kr.or.ddit.vo.ThumbVO;

public class IThumbServiceImpl implements IThumbService {

	private static IThumbService service = new IThumbServiceImpl();
	private IThumbDao dao;
	private IFileItem_ThumbDAO fileitemDAO;

	private IThumbServiceImpl() {
		dao = IThumbDaoImpl.getInstance();
		fileitemDAO = IFileItem_ThumbDAOImp.getInstance();
	}

	public static IThumbService getInstance() {
		return (service == null) ? service = new IThumbServiceImpl() : service;
	}

	@Override
	public ThumbVO thumbInfo(Map<String, String> params) {
		ThumbVO thumbInfo = null;
		try {
			thumbInfo = dao.thumbInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thumbInfo;
	}

	@Override
	public List<ThumbVO> thumbList(Map<String, String> params) {
		List<ThumbVO> thumbInfo = null;
		try {
			thumbInfo = dao.thumbList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thumbInfo;
	}

	@Override
	public List<ThumbVO> thumbList() {
		List<ThumbVO> thumbList = null;
		try {
			thumbList = dao.thumbList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thumbList;
	}

	@Override
	public String insertThumbInfo(ThumbVO thumbInfo) {
		String im_no = null;
		try {
			im_no = dao.insertThumbInfo(thumbInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return im_no;
	}

	@Override
	public void updateThumbInfo(ThumbVO thumbInfo) {
		try {
			dao.updateThumbInfo(thumbInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteThumbInfo(Map<String, String> params) {
		try {
			dao.deleteThumbInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount = "0";
		try {
			totalCount = dao.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	@Override
	public void insertThumbReply(ThumbVO thumbInfo) {

		try {
			dao.insertThumbReply(thumbInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insertThumbInfo(ThumbVO thumbInfo, File[] items,
			List<String> contentType) {
		try {
			String im_no = dao.insertThumbInfo(thumbInfo);
			if (items != null) {
				List<Fileitem_imageboardVO> fileItemList = AttachFileMapper
						.mapper_thumb(items, im_no, contentType);
				fileitemDAO.insertFileItem(fileItemList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateThumbInfo(ThumbVO thumbInfo, File[] items, List<String> contentTypes) {
		try {
			String im_no = dao.insertThumbInfo(thumbInfo);
			if (items != null) {
				List<Fileitem_imageboardVO> fileItemList 
					= AttachFileMapper.mapper_thumb(items, im_no, contentTypes);
				fileitemDAO.insertFileItem(fileItemList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
