package com.tyut.mimi.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.tyut.mimi.pojo.ProductInfo;
import com.tyut.mimi.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/prod")
public class ProductInfoController {


    //每页显示的记录条数
    public static final int PAGE_SIZE = 5;
    //controller层中一定有service层对象
    @Autowired
    ProductInfoService productInfoService;

    //查询所有商品信息
    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request){

        List<ProductInfo> productInfos = productInfoService.getAll();
        request.setAttribute("list", productInfos);
        return "product";
    }

    /**
     * 显示第一页5个商品
     */
    @RequestMapping("/split")
    public String split(HttpServletRequest request){

        PageInfo info = productInfoService.splitPage(1,PAGE_SIZE);
        request.setAttribute("info", info);

        return "product";
    }

    /**
     * ajax分页翻页处理
     */

    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void ajaxSplit(int page, HttpSession session){

        PageInfo info = productInfoService.splitPage(page, PAGE_SIZE);
        session.setAttribute("info", info);
    }
}
