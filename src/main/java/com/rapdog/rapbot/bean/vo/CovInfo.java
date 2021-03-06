package com.rapdog.rapbot.bean.vo;

import java.util.List;

/**
 * 树形结构疫情详情
 * @author rapdog
 */
public class CovInfo {

    private String name;

    private CovToday today;

    private CovTotal total;

    private List<CovInfo> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CovToday getToday() {
        return today;
    }

    public void setToday(CovToday today) {
        this.today = today;
    }

    public CovTotal getTotal() {
        return total;
    }

    public void setTotal(CovTotal total) {
        this.total = total;
    }

    public List<CovInfo> getChildren() {
        return children;
    }

    public void setChildren(List<CovInfo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CovInfo{");
        sb.append("name='").append(name).append('\'');
        sb.append(", today=").append(today);
        sb.append(", total=").append(total);
        sb.append(", children=").append(children);
        sb.append('}');
        return sb.toString();
    }

    public void traversalNowConfirmTree(StringBuilder sb){
        if (this.getTotal().getNowConfirm() > 0){
            sb.append(this.getName())
                    .append(this.getTotal().getNowConfirm())
                    .append("例，");
            if (this.getChildren() != null && !this.getChildren().isEmpty()){
                sb.append("其中");
                this.getChildren().forEach(covInfo -> {
                    covInfo.traversalNowConfirmTree(sb);
                });
            }
        }
    }

    public void traversalTodayConfirmTree(StringBuilder sb){
        if (this.getToday().getConfirm() > 0){
            sb.append("「")
                    .append(this.getName())
                    .append("」")
                    .append("新增")
                    .append(this.getToday().getConfirm())
                    .append("例，");
            if (this.getChildren() != null && !this.getChildren().isEmpty()){
                sb.append("其中");
                this.getChildren().forEach(covInfo -> {
                    covInfo.traversalTodayConfirmTree(sb);
                });
            }
        }
    }
}
