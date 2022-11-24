package com.tyut.mimi.service.impl;

import com.tyut.mimi.mapper.ProductTypeMapper;
import com.tyut.mimi.pojo.ProductType;
import com.tyut.mimi.pojo.ProductTypeExample;
import com.tyut.mimi.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getAll() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }

}
