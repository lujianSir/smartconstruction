package com.bwsk.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 项目实体
 *
 * @author lujian
 */
public class Project {

    private int pid;// id

    private String pname;// 项目名称

    private String pabbreviation;// 项目简称

    private String pnumber;// 项目编号

    private String paddress;// 项目地址

    private int pstatus;// 项目状态 1 进行 2 未开工 3.已完工

    private String pstatusName;// 项目名称

    private String pcompany;// 公司名称

    private int cid;// 公司ID

    private int ptype;// 1 工程项目 2 部门项目 3个人项目

    private String ptypeName;// 工程名称

    private BigDecimal contractamount;// 合同金额

    private BigDecimal acceptedamount;// 已收款项

    private BigDecimal acceptedinvoice;// 已开发票

    private int totalartificial;// 累计人工

    private String approachDay;// 进场时间

    private String completeDay;// 竣工时间

    private String paycondition;// 付款条件

    private String fineremarks;// 罚款备注

    private int materialuid;// 材料负责人

    private String creattime;// 创建的时间

    private int uid;// 创建的人

    private String username;// 名称

    private String cabbreviation;// 公司的简称

    private String weixin;// 项目绑定的微信ID

    private String userpower;// 项目负责人(编辑项目、收款管理)

    private String materialpower;// 计划负责人(计划管理)

    private List<UserInfo> userinfos;// 项目绑定的人

    private String contractaqueryProjectmount;


    public List<UserInfo> getUserinfos() {
        return userinfos;
    }

    public void setUserinfos(List<UserInfo> userinfos) {
        this.userinfos = userinfos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCabbreviation() {
        return cabbreviation;
    }

    public void setCabbreviation(String cabbreviation) {
        this.cabbreviation = cabbreviation;
    }

    public String getUserpower() {
        return userpower;
    }

    public void setUserpower(String userpower) {
        this.userpower = userpower;
    }

    public String getMaterialpower() {
        return materialpower;
    }

    public void setMaterialpower(String materialpower) {
        this.materialpower = materialpower;
    }

    public int getMaterialuid() {
        return materialuid;
    }

    public void setMaterialuid(int materialuid) {
        this.materialuid = materialuid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPabbreviation() {
        return pabbreviation;
    }

    public void setPabbreviation(String pabbreviation) {
        this.pabbreviation = pabbreviation;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public int getPstatus() {
        return pstatus;
    }

    public void setPstatus(int pstatus) {
        this.pstatus = pstatus;
    }

    public String getPcompany() {
        return pcompany;
    }

    public void setPcompany(String pcompany) {
        this.pcompany = pcompany;
    }

    public int getPtype() {
        return ptype;
    }

    public void setPtype(int ptype) {
        this.ptype = ptype;
    }

    public BigDecimal getContractamount() {
        return contractamount;
    }

    public void setContractamount(BigDecimal contractamount) {
        this.contractamount = contractamount;
    }

    public BigDecimal getAcceptedamount() {
        return acceptedamount;
    }

    public void setAcceptedamount(BigDecimal acceptedamount) {
        this.acceptedamount = acceptedamount;
    }

    public BigDecimal getAcceptedinvoice() {
        return acceptedinvoice;
    }

    public void setAcceptedinvoice(BigDecimal acceptedinvoice) {
        this.acceptedinvoice = acceptedinvoice;
    }

    public int getTotalartificial() {
        return totalartificial;
    }

    public void setTotalartificial(int totalartificial) {
        this.totalartificial = totalartificial;
    }

    public String getApproachDay() {
        return approachDay;
    }

    public void setApproachDay(String approachDay) {
        this.approachDay = approachDay;
    }

    public String getCompleteDay() {
        return completeDay;
    }

    public void setCompleteDay(String completeDay) {
        this.completeDay = completeDay;
    }

    public String getPaycondition() {
        return paycondition;
    }

    public void setPaycondition(String paycondition) {
        this.paycondition = paycondition;
    }

    public String getFineremarks() {
        return fineremarks;
    }

    public void setFineremarks(String fineremarks) {
        this.fineremarks = fineremarks;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getPstatusName() {
        return pstatusName;
    }

    public void setPstatusName(String pstatusName) {
        this.pstatusName = pstatusName;
    }

    public String getPtypeName() {
        return ptypeName;
    }

    public void setPtypeName(String ptypeName) {
        this.ptypeName = ptypeName;
    }

    public String getContractaqueryProjectmount() {
        return contractaqueryProjectmount;
    }

    public void setContractaqueryProjectmount(String contractaqueryProjectmount) {
        this.contractaqueryProjectmount = contractaqueryProjectmount;
    }
}
