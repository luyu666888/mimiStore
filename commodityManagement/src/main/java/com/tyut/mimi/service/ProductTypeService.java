package com.tyut.mimi.service;

import com.tyut.mimi.pojo.ProductType;

import java.util.List;

public interface ProductTypeService {

    /**
     * 查询所哟商品类型
     * @return
     */
    List<ProductType> getAll();
}
