package kr.or.ddit.vo;

import java.io.File;
import java.util.List;

public class NoticeVO {
	private int rnum;
	private String no_no 		;
	private String no_title 	;
	private String no_writer 	;
	private String no_content 	;
	private String no_hit 		;
	private String no_reg_date  ;
	private String no_delete 	;
	private String no_group 	;
	private String no_seq 		;
	private String no_depth     ;
	private String bo_ip        ;
	private List<Fileitem_noticeVO> items;
	
	private List<File> files;
	private List<String> filesContentType;
	private List<String> filesFileName;
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public List<Fileitem_noticeVO> getItems() {
		return items;
	}
	public void setItems(List<Fileitem_noticeVO> items) {
		this.items = items;
	}
	public String getBo_ip() {
		return bo_ip;
	}
	public void setBo_ip(String bo_ip) {
		this.bo_ip = bo_ip;
	}
	public String getNo_no() {
		return no_no;
	}
	public void setNo_no(String no_no) {
		this.no_no = no_no;
	}
	public String getNo_title() {
		return no_title;
	}
	public void setNo_title(String no_title) {
		this.no_title = no_title;
	}
	public String getNo_writer() {
		return no_writer;
	}
	public void setNo_writer(String no_writer) {
		this.no_writer = no_writer;
	}
	public String getNo_content() {
		return no_content;
	}
	public void setNo_content(String no_content) {
		this.no_content = no_content;
	}
	public String getNo_hit() {
		return no_hit;
	}
	public void setNo_hit(String no_hit) {
		this.no_hit = no_hit;
	}
	public String getNo_reg_date() {
		return no_reg_date;
	}
	public void setNo_reg_date(String no_reg_date) {
		this.no_reg_date = no_reg_date;
	}
	public String getNo_delete() {
		return no_delete;
	}
	public void setNo_delete(String no_delete) {
		this.no_delete = no_delete;
	}
	public String getNo_group() {
		return no_group;
	}
	public void setNo_group(String no_group) {
		this.no_group = no_group;
	}
	public String getNo_seq() {
		return no_seq;
	}
	public void setNo_seq(String no_seq) {
		this.no_seq = no_seq;
	}
	public String getNo_depth() {
		return no_depth;
	}
	public void setNo_depth(String no_depth) {
		this.no_depth = no_depth;
	}
	public List<File> getFiles() {
		return files;
	}
	public void setFiles(List<File> files) {
		this.files = files;
	}
	public List<String> getFilesContentType() {
		return filesContentType;
	}
	public void setFilesContentType(List<String> filesContentType) {
		this.filesContentType = filesContentType;
	}
	public List<String> getFilesFileName() {
		return filesFileName;
	}
	public void setFilesFileName(List<String> filesFileName) {
		this.filesFileName = filesFileName;
	}
	
	
}
