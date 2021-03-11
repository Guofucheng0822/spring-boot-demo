package com.pers.guofucheng.json.zhongjiao.aaa;

public class SimplePaginationResultVO<T> {
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalRecords;
    private T result;

    public SimplePaginationResultVO() {
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalRecords() {
        return this.totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SimplePaginationResultVO{");
        sb.append("pageSize=").append(this.pageSize);
        sb.append(", currentPage=").append(this.currentPage);
        sb.append(", totalRecords=").append(this.totalRecords);
        sb.append(", result=").append(this.result);
        sb.append('}');
        return sb.toString();
    }
}
