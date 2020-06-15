package com.bwsk.entity;

/**
 * 文件的实体
 * 
 * @author lujian
 *
 */
public class FileInfo {

	private int fid;// 文件的ID

	private String fname;// 文件的名称

	private String frealurl;// 文件的真实路径

	private String fvirtualurl;// 文件的虚拟路径

	private String fuploadtime;// 文件上传的时间

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFrealurl() {
		return frealurl;
	}

	public void setFrealurl(String frealurl) {
		this.frealurl = frealurl;
	}

	public String getFvirtualurl() {
		return fvirtualurl;
	}

	public void setFvirtualurl(String fvirtualurl) {
		this.fvirtualurl = fvirtualurl;
	}

	public String getFuploadtime() {
		return fuploadtime;
	}

	public void setFuploadtime(String fuploadtime) {
		this.fuploadtime = fuploadtime;
	}

}
