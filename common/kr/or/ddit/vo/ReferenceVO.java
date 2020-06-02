package kr.or.ddit.vo;

import java.io.File;
import java.util.List;

public class ReferenceVO {
	private int rnum;
	private String re_no 		;
	private String re_title 	;
	private String re_writer 	;
	private String re_content 	;
	private String re_hit 		;
	private String re_reg_date ;
	private String re_delete 	;
	private String re_group 	;
	private String re_seq 		;
	private String re_depth    ;
	private String bo_ip        ;
	private List<Fileitem_referenceVO> items;
	
	private List<File> files;
	private List<String> filesContentType;
	private List<String> filesFileName;
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public List<Fileitem_referenceVO> getItems() {
		return items;
	}
	public void setItems(List<Fileitem_referenceVO> items) {
		this.items = items;
	}
	public String getBo_ip() {
		return bo_ip;
	}
	public void setBo_ip(String bo_ip) {
		this.bo_ip = bo_ip;
	}
	public String getRe_no() {
		return re_no;
	}
	public void setRe_no(String re_no) {
		this.re_no = re_no;
	}
	public String getRe_title() {
		return re_title;
	}
	public void setRe_title(String re_title) {
		this.re_title = re_title;
	}
	public String getRe_writer() {
		return re_writer;
	}
	public void setRe_writer(String re_writer) {
		this.re_writer = re_writer;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public String getRe_hit() {
		return re_hit;
	}
	public void setRe_hit(String re_hit) {
		this.re_hit = re_hit;
	}
	public String getRe_reg_date() {
		return re_reg_date;
	}
	public void setRe_reg_date(String re_reg_date) {
		this.re_reg_date = re_reg_date;
	}
	public String getRe_delete() {
		return re_delete;
	}
	public void setRe_delete(String re_delete) {
		this.re_delete = re_delete;
	}
	public String getRe_group() {
		return re_group;
	}
	public void setRe_group(String re_group) {
		this.re_group = re_group;
	}
	public String getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(String re_seq) {
		this.re_seq = re_seq;
	}
	public String getRe_depth() {
		return re_depth;
	}
	public void setRe_depth(String re_depth) {
		this.re_depth = re_depth;
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
