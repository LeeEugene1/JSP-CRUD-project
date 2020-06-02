package kr.or.ddit.user.notice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import kr.or.ddit.global.GlobalConstant;

public class FileDownloadAction {

	private String contentDisposition;
	private long contentLength;
	private InputStream inputStream;
	private String fileName;

	public String execute() throws FileNotFoundException {
		File downloadFile = new File(GlobalConstant.FILE_PATH, this.fileName);
		
		this.contentDisposition = "attachment;fileName=" + this.fileName;
		this.contentLength = downloadFile.length();
		
		this.inputStream = new FileInputStream(downloadFile);
		
		return "success";
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
