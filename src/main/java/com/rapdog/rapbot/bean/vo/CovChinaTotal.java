package com.rapdog.rapbot.bean.vo;

/**
 * @author rapdog
 */
public class CovChinaTotal {

    /**
     * 境外输入
     */
    private Integer importedCase;

    /**
     * 无症状
     */
    private Integer noInfectH5;

    /**
     * 死亡
     */
    private Integer dead;

    private Integer suspect;

    private Integer local_acc_confirm;

    /**
     * 本土确诊（不知道为什么和页面显示的数据不同，先以页面显示为准）
     */
    private Integer localConfirm;

    /**
     * 累计确诊
     */
    private Integer confirm;


    private Integer nowSevere;

    /**
     * 无症状
     */
    private Integer noInfect;

    /**
     * 治愈
     */
    private Integer heal;

    /**
     * 本土确诊（页面显示）
     */
    private Integer localConfirmH5;

    /**
     * 现有确诊
     */
    private Integer nowConfirm;

    public Integer getImportedCase() {
        return importedCase;
    }

    public void setImportedCase(Integer importedCase) {
        this.importedCase = importedCase;
    }

    public Integer getNoInfectH5() {
        return noInfectH5;
    }

    public void setNoInfectH5(Integer noInfectH5) {
        this.noInfectH5 = noInfectH5;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }

    public Integer getSuspect() {
        return suspect;
    }

    public void setSuspect(Integer suspect) {
        this.suspect = suspect;
    }

    public Integer getLocal_acc_confirm() {
        return local_acc_confirm;
    }

    public void setLocal_acc_confirm(Integer local_acc_confirm) {
        this.local_acc_confirm = local_acc_confirm;
    }

    public Integer getLocalConfirm() {
        return localConfirm;
    }

    public void setLocalConfirm(Integer localConfirm) {
        this.localConfirm = localConfirm;
    }

    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    public Integer getNowSevere() {
        return nowSevere;
    }

    public void setNowSevere(Integer nowSevere) {
        this.nowSevere = nowSevere;
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

    public Integer getLocalConfirmH5() {
        return localConfirmH5;
    }

    public void setLocalConfirmH5(Integer localConfirmH5) {
        this.localConfirmH5 = localConfirmH5;
    }

    public Integer getNowConfirm() {
        return nowConfirm;
    }

    public void setNowConfirm(Integer nowConfirm) {
        this.nowConfirm = nowConfirm;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CovChinaTotal{");
        sb.append("importedCase=").append(importedCase);
        sb.append(", noInfectH5=").append(noInfectH5);
        sb.append(", dead=").append(dead);
        sb.append(", suspect=").append(suspect);
        sb.append(", local_acc_confirm=").append(local_acc_confirm);
        sb.append(", localConfirm=").append(localConfirm);
        sb.append(", confirm=").append(confirm);
        sb.append(", nowSevere=").append(nowSevere);
        sb.append(", noInfect=").append(noInfect);
        sb.append(", heal=").append(heal);
        sb.append(", localConfirmH5=").append(localConfirmH5);
        sb.append(", nowConfirm=").append(nowConfirm);
        sb.append('}');
        return sb.toString();
    }
}
