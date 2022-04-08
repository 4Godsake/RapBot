package com.rapdog.rapbot.bean.bo;

import java.io.Serializable;
import java.util.Date;

public class McGoods implements Serializable {
    private Integer goodsId;

    private String goodsName;

    private String goodsDesc;

    private String goodsClassName;

    private Integer goodsInventory;

    private Float goodsPrice;

    private Long createQid;

    private Date createTime;

    private Date updateTime;

    private String extA;

    private String extB;

    private String extC;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsClassName() {
        return goodsClassName;
    }

    public void setGoodsClassName(String goodsClassName) {
        this.goodsClassName = goodsClassName;
    }

    public Integer getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(Integer goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
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
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsDesc=").append(goodsDesc);
        sb.append(", goodsClassName=").append(goodsClassName);
        sb.append(", goodsInventory=").append(goodsInventory);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", createQid=").append(createQid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", extA=").append(extA);
        sb.append(", extB=").append(extB);
        sb.append(", extC=").append(extC);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}