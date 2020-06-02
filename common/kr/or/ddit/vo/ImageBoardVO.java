package kr.or.ddit.vo;

import java.util.List;

public class ImageBoardVO {
	private String im_no;
	private String im_title;
	private String im_writer;
	private String im_content;
	private String im_hit;
	private String im_reg_date;
	private String im_delete;
	private String im_group;
	private String im_seq;
	private String im_depth;
	private String bo_ip;
	private List<Fileitem_imageboardVO> items;
	
	
	
	public List<Fileitem_imageboardVO> getItems() {
		return items;
	}
	public void setItems(List<Fileitem_imageboardVO> items) {
		this.items = items;
	}
	public String getBo_ip() {
		return bo_ip;
	}
	public void setBo_ip(String bo_ip) {
		this.bo_ip = bo_ip;
	}
	public String getIm_no() {
		return im_no;
	}
	public void setIm_no(String im_no) {
		this.im_no = im_no;
	}
	public String getIm_title() {
		return im_title;
	}
	public void setIm_title(String im_title) {
		this.im_title = im_title;
	}
	public String getIm_writer() {
		return im_writer;
	}
	public void setIm_writer(String im_writer) {
		this.im_writer = im_writer;
	}
	public String getIm_content() {
		return im_content;
	}
	public void setIm_content(String im_content) {
		this.im_content = im_content;
	}
	public String getIm_hit() {
		return im_hit;
	}
	public void setIm_hit(String im_hit) {
		this.im_hit = im_hit;
	}
	public String getIm_reg_date() {
		return im_reg_date;
	}
	public void setIm_reg_date(String im_reg_date) {
		this.im_reg_date = im_reg_date;
	}
	public String getIm_delete() {
		return im_delete;
	}
	public void setIm_delete(String im_delete) {
		this.im_delete = im_delete;
	}
	public String getIm_group() {
		return im_group;
	}
	public void setIm_group(String im_group) {
		this.im_group = im_group;
	}
	public String getIm_seq() {
		return im_seq;
	}
	public void setIm_seq(String im_seq) {
		this.im_seq = im_seq;
	}
	public String getIm_depth() {
		return im_depth;
	}
	public void setIm_depth(String im_depth) {
		this.im_depth = im_depth;
	}
	
	
}
