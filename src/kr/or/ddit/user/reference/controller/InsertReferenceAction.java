package kr.or.ddit.user.reference.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.reference.service.IReferenceService;
import kr.or.ddit.reference.service.IReferenceServiceImp;
import kr.or.ddit.vo.ReferenceVO;

public class InsertReferenceAction implements ModelDriven<ReferenceVO> {
	
	private ReferenceVO referenceInfo;
	private String fileName;
	private String message;
	
	public String insertReferenceInfo() throws Exception {
		
		IReferenceService service = IReferenceServiceImp.getInstance();
		
		List<File> files = this.referenceInfo.getFiles();
		List<String> contentTypes = this.referenceInfo.getFilesContentType();
		List<String> fileNames = this.referenceInfo.getFilesFileName();
		
		File[] file = new File[fileNames.size()];
		
		for (int i = 0; i < fileNames.size(); i++) {
			File target = files.get(i);
			
			if ( target.length() > 0 ) {
				File saveFile = new File(GlobalConstant.FILE_PATH, fileNames.get(i));
				file[i] = saveFile;
				this.fileName = fileNames.get(i);
			}
		}
		
		service.insertReferenceInfo(this.referenceInfo, file, contentTypes);
		
		this.message = URLEncoder.encode("게시물 등록이 완료되었습니다.", "UTF-8");
		
		return "success";
	}
	
	@Override
	public ReferenceVO getModel() {
		this.referenceInfo = new ReferenceVO();
		return referenceInfo;
	}

	public String getMessage() {
		return message;
	}
	
}
