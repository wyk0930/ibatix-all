package com.ibatix.data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable {
    private List<T> content;
    private Integer pageNo;
    private Integer pageSize;
    private Integer total;

    private Page() {
        this(-1,-1);
    }

    private Page(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.content = new ArrayList<>();
    }

    public static Page of(Integer pageNo, Integer pageSize) {
        return new Page(pageNo, pageSize);
    }

    public static Page of() {
        return new Page();
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public void addItem(T item) {
        content.add(item);
    }


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
