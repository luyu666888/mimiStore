
            还没写完 哈哈
搭建ssm项目的步骤：
1.新建Maven项目，或者空项目，新建Maven模块
2.修改目录，修改pom文件，添加依赖
3.添加jdbc.properties文件
4.新建applicationContext_dao.xml文件，进行数据访问层的配置
5.新建applicationContext_service.xml文件，进行业务逻辑层的配置
6.新建springmvc.xml文件，配置springmvc的配置
7.新建SqlMapConfig.xml文件，配置分页查询
8.使用逆向工程生成pojo和mapper文件
9，开发业务逻辑层，实现登录判断
10，开发控制器AdminAction，完成登录处理
11.改造页面，发送登录请求，验证登录