package com.bwsk.entity;

/**
 * 评论
 * 
 * @author Administrator
 *
 */
public class Comment {

	private int cmid;//
	private int cmuid;// 评论用户ID
	private int cmdid;// 评论日报ID
	private String cmcomment;// 评论内容
	private String cmdatime;// 评论的时间
	private String cmupic;// 照片
	private String cmusername;// 名称
	private String creattime;// 点赞的时间

	public String getCreattime() {
		return creattime;
	}

	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}

	public String getCmupic() {
		return cmupic;
	}

	public void setCmupic(String cmupic) {
		this.cmupic = cmupic;
	}

	public String getCmusername() {
		return cmusername;
	}

	public void setCmusername(String cmusername) {
		this.cmusername = cmusername;
	}

	public int getCmid() {
		return cmid;
	}

	public void setCmid(int cmid) {
		this.cmid = cmid;
	}

	public int getCmuid() {
		return cmuid;
	}

	public void setCmuid(int cmuid) {
		this.cmuid = cmuid;
	}

	public int getCmdid() {
		return cmdid;
	}

	public void setCmdid(int cmdid) {
		this.cmdid = cmdid;
	}

	public String getCmcomment() {
		return cmcomment;
	}

	public void setCmcomment(String cmcomment) {
		this.cmcomment = cmcomment;
	}

	public String getCmdatime() {
		return cmdatime;
	}

	public void setCmdatime(String cmdatime) {
		this.cmdatime = cmdatime;
	}

}
