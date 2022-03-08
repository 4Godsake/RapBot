package com.rapdog.rapbot.bean.vo;

/**
 * @author rapdog
 */
public class CovTotal {

    private Integer confirm;

    private Integer provinceLocalConfirm;

    private Integer wzz;

    private Integer heal;

    private Integer nowConfirm;

    private Integer dead;

    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    public Integer getProvinceLocalConfirm() {
        return provinceLocalConfirm;
    }

    public void setProvinceLocalConfirm(Integer provinceLocalConfirm) {
        this.provinceLocalConfirm = provinceLocalConfirm;
    }

    public Integer getWzz() {
        return wzz;
    }

    public void setWzz(Integer wzz) {
        this.wzz = wzz;
    }

    public Integer getHeal() {
        return heal;
    }

    public void setHeal(Integer heal) {
        this.heal = heal;
    }

    public Integer getNowConfirm() {
        return nowConfirm;
    }

    public void setNowConfirm(Integer nowConfirm) {
        this.nowConfirm = nowConfirm;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CovTotal{");
        sb.append("confirm=").append(confirm);
        sb.append(", provinceLocalConfirm=").append(provinceLocalConfirm);
        sb.append(", wzz=").append(wzz);
        sb.append(", heal=").append(heal);
        sb.append(", nowConfirm=").append(nowConfirm);
        sb.append(", dead=").append(dead);
        sb.append('}');
        return sb.toString();
    }
}