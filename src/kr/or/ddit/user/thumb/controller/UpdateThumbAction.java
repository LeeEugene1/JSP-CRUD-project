package kr.or.ddit.user.thumb.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.thumb.service.IThumbService;
import kr.or.ddit.thumb.service.IThumbServiceImpl;
import kr.or.ddit.vo.ThumbVO;

import com.opensymphony.xwork2.ModelDriven;

public class UpdateThumbAction implements ModelDriven<ThumbVO> {
	
	private ThumbVO thumbInfo;
	private String message;
	private String fileName;
	
	public String execute() throws Exception {
		IThumbService service = IThumbServiceImpl.getInstance();
		
		List<File> files = this.thumbInfo.getFiles();
		List<String> contentTypes = this.thumbInfo.getFilesContentType();
		List<String> fileNames = this.thumbInfo.getFilesFileName();
		
		File[] file = new File[fileNames.size()];
		
		for (int i = 0; i < fileNames.size(); i++) {
			File target = files.get(i);
			if ( target.length() > 0 ) {
				File saveFile = new File(GlobalConstant.FILE_PATH, fileNames.get(i));
				file[i] = saveFile;
				this.fileName = fileNames.get(i);
			}
		}
		
		service.updateThumbInfo(this.thumbInfo, file, contentTypes);
		
		this.message = URLEncoder.encode("게시물을 수정하였습니다", "UTF-8");
		
		return "success";
	}

	@Override
	public ThumbVO getModel() {
		
		this.thumbInfo = new ThumbVO();
		return thumbInfo;
	}

	public ThumbVO getThumbInfo() {
		return thumbInfo;
	}

	public void setThumbInfo(ThumbVO thumbInfo) {
		this.thumbInfo = thumbInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
