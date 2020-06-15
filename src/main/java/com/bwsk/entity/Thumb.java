package com.bwsk.entity;

/**
 * 点赞
 * 
 * @author Administrator
 *
 */
public class Thumb {

	private int tid;// 点赞ID

	private int tdid;// 被点赞的日报

	private int tuid;// 点赞的人

	private String upic;// 点赞人的照片

	private String creattime;// 点赞的时间

	public String getCreattime() {
		return creattime;
	}

	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}

	public String getUpic() {
		return upic;
	}

	public void setUpic(String upic) {
		this.upic = upic;
	}

	public int getTid() {
		return tid;
	}

	public int getTdid() {
		return tdid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public void setTdid(int tdid) {
		this.tdid = tdid;
	}

	public int getTuid() {
		return tuid;
	}

	public void setTuid(int tuid) {
		this.tuid = tuid;
	}

}
