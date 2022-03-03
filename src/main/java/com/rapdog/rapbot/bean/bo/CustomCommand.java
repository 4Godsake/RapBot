package com.rapdog.rapbot.bean.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CustomCommand implements Serializable {
    private String commandStr;

    private String replyStr;

    private Long createQid;

    private Date createTime;

    private Date updateTime;

    private List<Long> activeGroups;

    private static final long serialVersionUID = 1L;

    public String getCommandStr() {
        return commandStr;
    }

    public void setCommandStr(String commandStr) {
        this.commandStr = commandStr;
    }

    public String getReplyStr() {
        return replyStr;
    }

    public void setReplyStr(String replyStr) {
        this.replyStr = replyStr;
    }

    public Long getCreateQid() {
        return createQid;
    }

    public void setCreateQid(Long createQid) {
        this.createQid = createQid;
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

    public List<Long> getActiveGroups() {
        return activeGroups;
    }

    public void setActiveGroups(List<Long> activeGroups) {
        this.activeGroups = activeGroups;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commandStr=").append(commandStr);
        sb.append(", replyStr=").append(replyStr);
        sb.append(", createQid=").append(createQid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}