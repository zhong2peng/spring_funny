package com.dnight.framework.kernel.base.dao;

import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/11/7
 */
public class PageList<E> {

    public static final long FIRST_PAGE = 1;

    private long currPage;
    private long maxPage;
    private long pageSize;
    private long totalCount;
    private List<E> dataList;

    public PageList(long currPage, long maxPage, long pageSize, long totalCount, List<E> dataList) {
        this.currPage = currPage;
        this.maxPage = maxPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.dataList = dataList;
    }
}
