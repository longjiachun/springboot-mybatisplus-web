package com.vstaryw.web.param;

import java.io.Serializable;

/**
 * 基本参数
 */
public class BaseParam implements Serializable {
    private static final long serialVersionUID = 1875521096241717627L;

    /**
     * 第几页
     */
    private Integer pageNum;
    /**
     * 每页数据
     */
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
