package com.tyut.mimi.service;

import com.github.pagehelper.PageInfo;
import com.tyut.mimi.pojo.ProductInfo;

import java.util.List;

public interface ProductInfoService {

    /**
     * 查询所有商品信息
     * @return
     */
    List<ProductInfo> getAll();

    /**
     * 分页功能实现
     */
    PageInfo splitPage(int pageNum, int pageSize);
}
