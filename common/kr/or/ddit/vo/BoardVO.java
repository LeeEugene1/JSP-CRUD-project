package kr.or.ddit.vo;

import java.io.File;
import java.util.List;

public class BoardVO {
	private String rnum;
	private String bo_no;
	private String bo_title;
	private String bo_writer;
	private String bo_content;
	private String bo_hit;
	private String bo_reg_date;
	private String bo_delete;
	private String bo_group;
	private String bo_seq;
	private String bo_depth;
	private List<Fileitem_boardVO> items;
	private String max_group_no  ;
	private String bo_ip;
	
	private String bo_nickname;
	private String bo_pwd;
	private String bo_mail;
	
	private List<File> files;
	private List<String> filesContentType;
	private List<String> filesFileName;
	
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
	public String getBo_nickname() {
		return bo_nickname;
	}
	public void setBo_nickname(String bo_nickname) {
		this.bo_nickname = bo_nickname;
	}
	public String getBo_pwd() {
		return bo_pwd;
	}
	public void setBo_pwd(String bo_pwd) {
		this.bo_pwd = bo_pwd;
	}
	public String getBo_mail() {
		return bo_mail;
	}
	public void setBo_mail(String bo_mail) {
		this.bo_mail = bo_mail;
	}
	public List<Fileitem_boardVO> getItems() {
		return items;
	}
	public void setItems(List<Fileitem_boardVO> items) {
		this.items = items;
	}
	public String getBo_ip() {
		return bo_ip;
	}
	public void setBo_ip(String bo_ip) {
		this.bo_ip = bo_ip;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getBo_no() {
		return bo_no;
	}
	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}
	public String getBo_title() {
		return bo_title;
	}
	public void setBo_title(String bo_title) {
		this.bo_title = bo_title;
	}
	public String getBo_writer() {
		return bo_writer;
	}
	public void setBo_writer(String bo_writer) {
		this.bo_writer = bo_writer;
	}
	public String getBo_content() {
		return bo_content;
	}
	public void setBo_content(String bo_content) {
		this.bo_content = bo_content;
	}
	public String getBo_hit() {
		return bo_hit;
	}
	public void setBo_hit(String bo_hit) {
		this.bo_hit = bo_hit;
	}
	public String getBo_reg_date() {
		return bo_reg_date;
	}
	public void setBo_reg_date(String bo_reg_date) {
		this.bo_reg_date = bo_reg_date;
	}
	public String getBo_delete() {
		return bo_delete;
	}
	public void setBo_delete(String bo_delete) {
		this.bo_delete = bo_delete;
	}
	public String getBo_group() {
		return bo_group;
	}
	public void setBo_group(String bo_group) {
		this.bo_group = bo_group;
	}
	public String getBo_seq() {
		return bo_seq;
	}
	public void setBo_seq(String bo_seq) {
		this.bo_seq = bo_seq;
	}
	public String getBo_depth() {
		return bo_depth;
	}
	public void setBo_depth(String bo_depth) {
		this.bo_depth = bo_depth;
	}
	public String getMax_group_no() {
		return max_group_no;
	}
	public void setMax_group_no(String max_group_no) {
		this.max_group_no = max_group_no;
	}
	
	
}