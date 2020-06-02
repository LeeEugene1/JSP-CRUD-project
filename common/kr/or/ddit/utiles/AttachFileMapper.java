package kr.or.ddit.utiles;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.Fileitem_boardVO;
import kr.or.ddit.vo.Fileitem_imageboardVO;
import kr.or.ddit.vo.Fileitem_noticeVO;
import kr.or.ddit.vo.Fileitem_referenceVO;

public class AttachFileMapper {
	
	public static List<Fileitem_noticeVO> mapper_notice(File[] items, String no_no, List<String> contextType) {
		List<Fileitem_noticeVO> fileItemList = new ArrayList<Fileitem_noticeVO>();
		
		int i = 0;
		if (items != null) {
			Fileitem_noticeVO fileItemInfo = null;
			
			for(File item : items) {
				fileItemInfo = new Fileitem_noticeVO();
				fileItemInfo.setFile_no(no_no);
				
				String fileName = FilenameUtils.getName(item.getName());
				fileItemInfo.setFile_name(fileName);
				
				String baseName = FilenameUtils.getBaseName(fileName);
				String extension = FilenameUtils.getExtension(fileName);
				
				String genID = UUID.randomUUID().toString().replace("-", "");
				
				String saveFileName = baseName + genID + "." + extension;
				fileItemInfo.setFile_save_name(saveFileName);
				
				fileItemInfo.setFile_content_type(contextType.get(i++));
				fileItemInfo.setFile_size(String.valueOf(item.length()));
				
				fileItemList.add(fileItemInfo);
				
				File saveFile = new File(GlobalConstant.FILE_PATH, saveFileName);
				try {
					FileUtils.copyFile(item, saveFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileItemList;
	}
	
	public static List<Fileitem_referenceVO> mapper_reference(File[] items, String re_no, List<String> contextType) {
		List<Fileitem_referenceVO> fileItemList = new ArrayList<Fileitem_referenceVO>();
		
		int i = 0;
		if (items != null) {
			Fileitem_referenceVO fileItemInfo = null;
			
			for(File item : items) {
				fileItemInfo = new Fileitem_referenceVO();
				fileItemInfo.setFile_no(re_no);
				
				String fileName = FilenameUtils.getName(item.getName());
				fileItemInfo.setFile_name(fileName);
				
				String baseName = FilenameUtils.getBaseName(fileName);
				String extension = FilenameUtils.getExtension(fileName);
				
				String genID = UUID.randomUUID().toString().replace("-", "");
				
				String saveFileName = baseName + genID + "." + extension;
				fileItemInfo.setFile_save_name(saveFileName);
				
				fileItemInfo.setFile_content_type(contextType.get(i++));
				fileItemInfo.setFile_size(String.valueOf(item.length()));
				
				fileItemList.add(fileItemInfo);
				
				File saveFile = new File(GlobalConstant.FILE_PATH, saveFileName);
				try {
					FileUtils.copyFile(item, saveFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileItemList;
	}
	
	public static List<Fileitem_boardVO> mapper_board(File[] items, String bo_no, List<String> contextType) {
		List<Fileitem_boardVO> fileItemList = new ArrayList<Fileitem_boardVO>();
		
		int i = 0;
		if (items != null) {
			Fileitem_boardVO fileItemInfo = null;
			
			for(File item : items) {
				fileItemInfo = new Fileitem_boardVO();
				fileItemInfo.setFile_no(bo_no);
				
				String fileName = FilenameUtils.getName(item.getName());
				fileItemInfo.setFile_name(fileName);
				
				String baseName = FilenameUtils.getBaseName(fileName);
				String extension = FilenameUtils.getExtension(fileName);
				
				String genID = UUID.randomUUID().toString().replace("-", "");
				
				String saveFileName = baseName + genID + "." + extension;
				fileItemInfo.setFile_save_name(saveFileName);
				
				fileItemInfo.setFile_content_type(contextType.get(i++));
				fileItemInfo.setFile_size(String.valueOf(item.length()));
				
				fileItemList.add(fileItemInfo);
				
				File saveFile = new File(GlobalConstant.FILE_PATH, saveFileName);
				try {
					FileUtils.copyFile(item, saveFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileItemList;
	}
	
	public static List<Fileitem_imageboardVO> mapper_thumb(File[] items, String im_no, List<String> contextType) {
		List<Fileitem_imageboardVO> fileItemList = new ArrayList<Fileitem_imageboardVO>();
		
		int i = 0;
		if (items != null) {
			Fileitem_imageboardVO fileItemInfo = null;
			
			for(File item : items) {
				fileItemInfo = new Fileitem_imageboardVO();
				fileItemInfo.setFile_no(im_no);
				
				String fileName = FilenameUtils.getName(item.getName());
				fileItemInfo.setFile_name(fileName);
				
				String baseName = FilenameUtils.getBaseName(fileName);
				String extension = FilenameUtils.getExtension(fileName);
				
				String genID = UUID.randomUUID().toString().replace("-", "");
				
				String saveFileName = baseName + genID + "." + extension;
				fileItemInfo.setFile_save_name(saveFileName);
				
				fileItemInfo.setFile_content_type(contextType.get(i++));
				fileItemInfo.setFile_size(String.valueOf(item.length()));
				
				fileItemList.add(fileItemInfo);
				
				File saveFile = new File(GlobalConstant.FILE_PATH, saveFileName);
				try {
					FileUtils.copyFile(item, saveFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileItemList;
	}

}












