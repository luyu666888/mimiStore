package com.tyut.mimi.listener;

import com.tyut.mimi.pojo.ProductType;
import com.tyut.mimi.service.ProductTypeService;
import com.tyut.mimi.service.impl.ProductTypeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class ProductTypeListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        //手动从当前Spring容器中取出ProductTypeServiceImpl对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-*.xml");

        //这里注意必要返回ProductTypeService的具体实现类
        ProductTypeService productTypeServiceImpl =applicationContext.getBean("ProductTypeServiceImpl", ProductTypeService.class);
        List<ProductType> typeList = productTypeServiceImpl.getAll();
        //放入全局应用作用域中
        servletContextEvent.getServletContext().setAttribute("typeList", typeList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
