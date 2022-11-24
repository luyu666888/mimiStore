package com.tyut.mimi.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.tyut.mimi.pojo.ProductInfo;
import com.tyut.mimi.service.ProductInfoService;
import com.tyut.mimi.utils.FileNameUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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

    //异步ajax文件上传
    @ResponseBody
    @RequestMapping("/ajaxImg")
    public Object ajaxImg(MultipartFile pimage, HttpServletRequest request){

        //提取生成文件名 UUID+图片后最
        String saveFileName = FileNameUtil.getUUIDFileName()+FileNameUtil.getFileType(pimage.getOriginalFilename());

        //得到项目中图片存储的路径 获取项目于根路径，再将image_big加到后面
        String path = request.getServletContext().getRealPath("/image_big");

        //转存 File.separator 获取当前系统文件分隔符
        try {
            pimage.transferTo(new File(path+File.separator+saveFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //返回客户端JSON对象
        JSONObject object = new JSONObject();
        object.put("imgurl", saveFileName);

        return object.toString();
    }
}
