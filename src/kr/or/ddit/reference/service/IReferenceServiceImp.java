package kr.or.ddit.reference.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.reference.dao.IFileItem_referenceDAO;
import kr.or.ddit.reference.dao.IFileItem_referenceDAOImp;
import kr.or.ddit.reference.dao.IReferenceDao;
import kr.or.ddit.reference.dao.IReferenceDaoImp;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.vo.Fileitem_referenceVO;
import kr.or.ddit.vo.ReferenceVO;

public class IReferenceServiceImp implements IReferenceService {
	private static IReferenceService service = new IReferenceServiceImp();
	private IReferenceDao referenceDAO;
	private IFileItem_referenceDAO fileitemDAO;
	
	private IReferenceServiceImp() {
		referenceDAO = IReferenceDaoImp.getInstance();
		fileitemDAO = IFileItem_referenceDAOImp.getInstance();
	}
	
	public static IReferenceService getInstance(){
		return(service == null) ? service = new IReferenceServiceImp() : service;
	}
	
	@Override
	public ReferenceVO referenceInfo(Map<String, String> params) {
		ReferenceVO referenceInfo = null;
		try {
			referenceInfo = referenceDAO.referenceInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return referenceInfo;
	}

	@Override
	public List<ReferenceVO> referenceList(Map<String, String> params) {
		List<ReferenceVO> referenceList = null;
		try {
			referenceList = referenceDAO.referenceList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return referenceList;
	}

	@Override
	public List<ReferenceVO> referenceList() {
		List<ReferenceVO> referenceList = null;
		try {
			referenceList = referenceDAO.referenceList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return referenceList;
	}

	@Override
	public void insertReferenceInfo(ReferenceVO referenceInfo) {
		try {
			String re_no = referenceDAO.insertReferenceInfo(referenceInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertReferenceReply(ReferenceVO referenceInfo) {
		try {
			referenceDAO.insertReferenceReply(referenceInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateReferenceInfo(ReferenceVO referenceInfo) {
		try {
			referenceDAO.updateReferenceInfo(referenceInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteReferenceInfo(Map<String, String> params) {
		try {
			referenceDAO.deleteReferenceInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount="0";
		try {
			totalCount = referenceDAO.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	@Override
	public void insertReferenceInfo(ReferenceVO referenceInfo, File[] items, List<String> contentTypes) {
		
		try {
			String re_no = referenceDAO.insertReferenceInfo(referenceInfo);
			if (items != null) {
				List<Fileitem_referenceVO> fileItemList = AttachFileMapper.mapper_reference(items, re_no, contentTypes);
				fileitemDAO.insertFileItem(fileItemList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
