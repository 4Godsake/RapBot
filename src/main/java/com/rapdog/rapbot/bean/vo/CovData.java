package com.rapdog.rapbot.bean.vo;

import java.util.Date;
import java.util.List;

/**
 * @author rapdog
 */
public class CovData {

    Date lastUpdateTime;

    CovChinaAdd chinaAdd;

    CovChinaTotal chinaTotal;

    List<CovInfo> areaTree;

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public CovChinaAdd getChinaAdd() {
        return chinaAdd;
    }

    public void setChinaAdd(CovChinaAdd chinaAdd) {
        this.chinaAdd = chinaAdd;
    }

    public CovChinaTotal getChinaTotal() {
        return chinaTotal;
    }

    public void setChinaTotal(CovChinaTotal chinaTotal) {
        this.chinaTotal = chinaTotal;
    }

    public List<CovInfo> getAreaTree() {
        return areaTree;
    }

    public void setAreaTree(List<CovInfo> areaTree) {
        this.areaTree = areaTree;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CovData{");
        sb.append("lastUpdateTime=").append(lastUpdateTime);
        sb.append(", chinaAdd=").append(chinaAdd);
        sb.append(", chinaTotal=").append(chinaTotal);
        sb.append(", areaTree=").append(areaTree);
        sb.append('}');
        return sb.toString();
    }

    public String getChinaOverview() {
        final StringBuilder sb = new StringBuilder("【国内疫情】");
        sb.append("\n「本土现有确诊」：").append(chinaTotal.getLocalConfirm()).append("，较昨日")
                .append(chinaAdd.getLocalConfirmH5() > 0 ? "+"+chinaAdd.getLocalConfirmH5() : chinaAdd.getLocalConfirmH5());
        sb.append("\n「现有确诊」：").append(chinaTotal.getNowConfirm()).append("，较昨日")
                .append(chinaAdd.getNowConfirm() > 0 ? "+"+chinaAdd.getNowConfirm() : chinaAdd.getNowConfirm());
        sb.append("\n「累计确诊」：").append(chinaTotal.getConfirm()).append("，较昨日")
                .append(chinaAdd.getConfirm() > 0 ? "+"+chinaAdd.getConfirm() : chinaAdd.getConfirm());
        sb.append("\n「无症状感染者」：").append(chinaTotal.getNoInfect()).append("，较昨日")
                .append(chinaAdd.getNoInfect() > 0 ? "+"+chinaAdd.getNoInfect() : chinaAdd.getNoInfect());
        sb.append("\n「境外输入」：").append(chinaTotal.getImportedCase()).append("，较昨日")
                .append(chinaAdd.getImportedCase() > 0 ? "+"+chinaAdd.getImportedCase() : chinaAdd.getImportedCase());
        sb.append("\n「累计死亡」：").append(chinaTotal.getDead()).append("，较昨日")
                .append(chinaAdd.getDead() > 0 ? "+"+chinaAdd.getDead() : chinaAdd.getDead());
        return sb.toString();
    }
}
