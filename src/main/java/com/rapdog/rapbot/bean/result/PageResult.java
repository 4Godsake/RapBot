package com.rapdog.rapbot.bean.result;

import com.github.pagehelper.PageInfo;

/**
 * @author renzx
 * @date 2020-12-10 11:11
 */
public class PageResult {

    /**
     * 总条数
     */
    private long total;
    /**
     * 每页数据量
     */
    private int pageSize;

    /**
     * 当前页
     */
    private int pageNum;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 分页数据
     */
    private Object pageData;

    public PageResult(PageInfo pageInfo) {

        this.total = pageInfo.getTotal();
        this.pageSize = pageInfo.getPageSize();
        this.pageNum = pageInfo.getPageNum();
        this.totalPage = pageInfo.getPages();
        this.pageData = pageInfo.getList();
    }


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Object getPageData() {
        return pageData;
    }

    public void setPageData(Object pageData) {
        this.pageData = pageData;
    }
}
