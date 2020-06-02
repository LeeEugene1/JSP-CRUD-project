package kr.or.ddit.user.freeboard.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.IBoardServiceImpl;
import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.BoardVO;

import com.opensymphony.xwork2.ModelDriven;

public class BoardInsertAction implements ModelDriven<BoardVO> {
	
	private BoardVO boardInfo;
	private String fileName;
	private String message;
	
	public String insertBoardInfo() throws Exception {
		
		IBoardService service = IBoardServiceImpl.getInstance();
		List<File> files = this.boardInfo.getFiles();
		List<String> contentTypes = this.boardInfo.getFilesContentType();
		List<String> fileNames = this.boardInfo.getFilesFileName();
		
		File[] file = new File[fileNames.size()];
		
		for (int i = 0; i < fileNames.size(); i++) {
			File target = files.get(i);
			
			if ( target.length() > 0 ) {
				
				File saveFile = new File(GlobalConstant.FILE_PATH, fileNames.get(i));
				file[i] = saveFile;
				this.fileName = fileNames.get(i);
			}
		}
		
		service.insertBoardInfo(this.boardInfo, file, contentTypes);
		
		this.message = URLEncoder.encode("게시물 작성이 완료되었습니다", "UTF-8");
		
		return "success";
	}

	@Override
	public BoardVO getModel() {
		this.boardInfo = new BoardVO();
		return boardInfo;
	}

	public String getMessage() {
		return message;
	}

}
