package kr.or.ddit.reference.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ReferenceVO;

public interface IReferenceService {
	public ReferenceVO referenceInfo(Map<String, String> params);
	public List<ReferenceVO> referenceList(Map<String, String> params);
	public List<ReferenceVO> referenceList();
	public void insertReferenceInfo(ReferenceVO referenceInfo);
	public void insertReferenceInfo(ReferenceVO referenceInfo, File[] items, List<String> contentTypes);
	public void updateReferenceInfo(ReferenceVO referenceInfo);
	public void deleteReferenceInfo(Map<String, String> params);
	public void insertReferenceReply(ReferenceVO referenceInfo);
	public String totalCount(Map<String, String> params);
}
