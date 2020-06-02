package kr.or.ddit.admin.notice.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.INoticeServiceImp;
import kr.or.ddit.vo.NoticeVO;

import com.opensymphony.xwork2.ModelDriven;

public class InsertNoticeAction implements ModelDriven<NoticeVO> {
	
	private NoticeVO noticeInfo;
	private String fileName;
	private String message;
	
	public String insertNoticeInfo() throws Exception {
		
		INoticeService service = INoticeServiceImp.getInstance();
		
		List<File> files = this.noticeInfo.getFiles();
		List<String> contentTypes = this.noticeInfo.getFilesContentType();
		List<String> fileNames = this.noticeInfo.getFilesFileName();
		
		File[] file = new File[fileNames.size()];
		
		for (int i = 0; i < fileNames.size(); i++) {
			File target = files.get(i);
			
			if ( target.length() > 0 ) {
				File saveFile = new File(GlobalConstant.FILE_PATH, fileNames.get(i));
				file[i] = saveFile;
				this.fileName = fileNames.get(i);
			}
		}
		
		service.insertNoticeInfo(this.noticeInfo, file, contentTypes);
		
		this.message = URLEncoder.encode("게시물 등록이 완료되었습니다.", "UTF-8");
		
		return "success";
	}

	@Override
	public NoticeVO getModel() {
		this.noticeInfo = new NoticeVO();
		return this.noticeInfo;
	}

	public String getMessage() {
		return message;
	}

	public String getFileName() {
		return fileName;
	}
	
	
}
