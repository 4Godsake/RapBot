package com.rapdog.rapbot.bean.vo;

/**
 * @author rapdog
 */
public class CovToday {

    private Integer confirm;

    private Boolean isUpdated;

    private String tip;

    private Integer confirmCuts;


    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    public Boolean getUpdated() {
        return isUpdated;
    }

    public void setUpdated(Boolean updated) {
        isUpdated = updated;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Integer getConfirmCuts() {
        return confirmCuts;
    }

    public void setConfirmCuts(Integer confirmCuts) {
        this.confirmCuts = confirmCuts;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CovToday{");
        sb.append("confirm=").append(confirm);
        sb.append(", isUpdated=").append(isUpdated);
        sb.append(", tip='").append(tip).append('\'');
        sb.append(", confirmCuts=").append(confirmCuts);
        sb.append('}');
        return sb.toString();
    }
}