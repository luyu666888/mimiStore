package com.tyut.mimi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tyut.mimi.mapper.ProductInfoMapper;
import com.tyut.mimi.pojo.ProductInfo;
import com.tyut.mimi.pojo.ProductInfoExample;
import com.tyut.mimi.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> getAll() {

        List<ProductInfo> productInfos = productInfoMapper.selectByExample(new ProductInfoExample());
        return productInfos;

    }

    /**
     * 分页查询
     * @param pageNum   当前页
     * @param pageSize  每页显示的条数
     * @return  PageInfo对象，其中分装了分页信息
     */
    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {

        //使用PageHelper完成分页设置
        PageHelper.startPage(pageNum, pageSize);

        //进行PageInfo的史具封装
        //进项条件查询操作
        ProductInfoExample example = new ProductInfoExample();
        //设置排序，按当前主键降序排序
        //select * from product_info order by p-id desc
        example.setOrderByClause("p_id desc");
        //设置完排序后，取集合，一定再取集合之前，一定要设置   PageHelper.startPage(pageNum, pageSize);
        List<ProductInfo> list = productInfoMapper.selectByExample(example);
        //将查到的集合封装到PageInfo中
         PageInfo<ProductInfo> pageInfo = new PageInfo<>(list);
         return pageInfo;
    }
}
