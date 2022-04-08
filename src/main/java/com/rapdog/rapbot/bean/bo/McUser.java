package com.rapdog.rapbot.bean.bo;

import java.io.Serializable;
import java.util.Date;

public class McUser implements Serializable {
    private Long userQid;

    private String userMcid;

    private String userStat;

    private String userRole;

    private String mcPosition;

    private Integer userPoint;

    private Date createTime;

    private Date updateTime;

    private String extA;

    private String extB;

    private String extC;

    private static final long serialVersionUID = 1L;

    public Long getUserQid() {
        return userQid;
    }

    public void setUserQid(Long userQid) {
        this.userQid = userQid;
    }

    public String getUserMcid() {
        return userMcid;
    }

    public void setUserMcid(String userMcid) {
        this.userMcid = userMcid;
    }

    public String getUserStat() {
        return userStat;
    }

    public void setUserStat(String userStat) {
        this.userStat = userStat;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getMcPosition() {
        return mcPosition;
    }

    public void setMcPosition(String mcPosition) {
        this.mcPosition = mcPosition;
    }

    public Integer getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(Integer userPoint) {
        this.userPoint = userPoint;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getExtA() {
        return extA;
    }

    public void setExtA(String extA) {
        this.extA = extA;
    }

    public String getExtB() {
        return extB;
    }

    public void setExtB(String extB) {
        this.extB = extB;
    }

    public String getExtC() {
        return extC;
    }

    public void setExtC(String extC) {
        this.extC = extC;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("【用户信息】");
        sb.append("\nmcId：").append(userMcid);
        sb.append("\nqq：").append(userQid);
        sb.append("\n职位：").append(mcPosition);
        sb.append("\n狗币：").append(userPoint);
        return sb.toString();
    }
}