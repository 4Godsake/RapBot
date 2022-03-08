package com.rapdog.rapbot.bean.vo;

/**
 * @author rapdog
 */
public class CovChinaAdd {

    /**
     * 累计确诊
     */
    private Integer confirm;

    /**
     * 无症状
     */
    private Integer noInfect;

    /**
     * 治愈
     */
    private Integer heal;

    /**
     * 境外输入
     */
    private Integer importedCase;

    /**
     * 死亡
     */
    private Integer dead;

    /**
     * 现有确诊
     */
    private Integer nowConfirm;

    /**
     * 本土确诊（页面显示）
     */
    private Integer localConfirmH5;

    /**
     * 本土确诊（不知道为什么和页面显示的数据不同，先以页面显示为准）
     */
    private Integer localConfirm;

    private Integer suspect;

    private Integer nowSevere;

    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    public Integer getNoInfect() {
        return noInfect;
    }

    public void setNoInfect(Integer noInfect) {
        this.noInfect = noInfect;
    }

    public Integer getHeal() {
        return heal;
    }

    public void setHeal(Integer heal) {
        this.heal = heal;
    }

    public Integer getImportedCase() {
        return importedCase;
    }

    public void setImportedCase(Integer importedCase) {
        this.importedCase = importedCase;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }

    public Integer getNowConfirm() {
        return nowConfirm;
    }

    public void setNowConfirm(Integer nowConfirm) {
        this.nowConfirm = nowConfirm;
    }

    public Integer getLocalConfirmH5() {
        return localConfirmH5;
    }

    public void setLocalConfirmH5(Integer localConfirmH5) {
        this.localConfirmH5 = localConfirmH5;
    }

    public Integer getLocalConfirm() {
        return localConfirm;
    }

    public void setLocalConfirm(Integer localConfirm) {
        this.localConfirm = localConfirm;
    }

    public Integer getSuspect() {
        return suspect;
    }

    public void setSuspect(Integer suspect) {
        this.suspect = suspect;
    }

    public Integer getNowSevere() {
        return nowSevere;
    }

    public void setNowSevere(Integer nowSevere) {
        this.nowSevere = nowSevere;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CovChinaAdd{");
        sb.append("confirm=").append(confirm);
        sb.append(", noInfect=").append(noInfect);
        sb.append(", heal=").append(heal);
        sb.append(", importedCase=").append(importedCase);
        sb.append(", dead=").append(dead);
        sb.append(", nowConfirm=").append(nowConfirm);
        sb.append(", localConfirmH5=").append(localConfirmH5);
        sb.append(", localConfirm=").append(localConfirm);
        sb.append(", suspect=").append(suspect);
        sb.append(", nowSevere=").append(nowSevere);
        sb.append('}');
        return sb.toString();
    }
}
