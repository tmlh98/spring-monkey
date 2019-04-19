## 1 作品概述

### 1.1简介

> ​	Spring Monkey 是一个是一款基于最新技术开发的多人在线、简洁的博客社区系统。
>
> ​	点击查看:http://www.tmlh.xyz



### 1.2 项目特点

- [x] 项目使用springboot构建，技术选型新颖
- [x] 详细的代码注释，架构清晰，强扩展性，可配置性


- [x] 支持多平台(qq、github)社交账号登陆

- [x] spring security 做身份认证 ，权限控制，csrf防御

- [x] 丰富的日志记录，轻松监控网站

- [x] 界面简洁，舒适，良好的交互性

      ​

## 2 作品用到的相关技术概述



### 2.1 前端

| 框架               | 描述     | 相关资料                                     |
| ---------------- | ------ | ---------------------------------------- |
| bootstarp        | 布局与组件  | <http://www.bootcss.com/>                |
| jquery           | DOM操作  | <https://jquery.com/>                    |
| Font Awesome     | 字体图标   | <http://www.fontawesome.com.cn/>         |
| bootstrap-notify | 通知     | <http://bootstrap-notify.remabledesigns.com/> |
| adminlte         | 后台管理页面 | <https://adminlte.io/themes/AdminLTE/pages/tables/simple.html#> |
| bootstrap-table  | 列表管理   | <https://bootstrap-table.com/>           |
| sweetalert.js    | 弹层     | <https://sweetalert.js.org/guides/>      |
| wangEditor       | 富文本    | <https://www.kancloud.cn/>               |



### 2.2 后端

| 框架              | 描述          | 相关资料                                     |
| :-------------- | ----------- | :--------------------------------------- |
| spring boot     | 构建          | <https://spring.io/projects/spring-boot> |
| spring security | 安全          | <https://spring.io/projects/spring-security> |
| spring social   | 设计          | <https://projects.spring.io/spring-social/> |
| mybatis plus    | mybatis增强工具 | [https://mybatis.plus](https://mybatis.plus/) |
| thymeleaf       | 后端模板引擎      | <https://www.thymeleaf.org/>             |
| swagger2        | REST API文档  | <https://swagger.io/>                    |
| ...             |             |                                          |



## 3 设计过程及技术

### 3.1 工程结构



![structure](.\images\structure.png)

> spring monkey 采用maven构建，分为四个子工程，每个子工程担任不同的职责。

- tmlh-forum			父工程，管理依赖版本，项目打包发布


- tmlh-forum-scoail 	社交模板，集成QQ、GitHub社交登陆,及对可用配置的管理	
- tmlh-forum-security    安全模块，security的一些配置
- tmlh-forum-core           核心模块，管理data,model,dao,enum...
- tmlh-forum-web            web模块，页面显示用

### 3.2 数据库设计



![database](images\database.png)



> 为了以后程序的模块化，这里采用了逻辑外键的方式，考虑的级联删除的问题，只在article 与comment建立外键关系。
>

- tbl_userconnection	存放设计用户唯一标识
- tbl_article                       文章表
- tbl_user                          社交用户表
- tbl_admin                       管理员账户
- tbl_comment                 评论表
- tbl_social                        社交用户关系表，保存粉丝关联
- tbl_catalog                     文章分类表
- sys_log                            记录系统日志
- persistent_logins           登陆的token信息



结构设计遵循以下的原则：

（1）  尽可能的减少数据冗余和重复。

（2）  结构设计与操作设计相结合。

（3）  数据结构具有相对的稳定性。

（4）  遵循数据库设计三范式。



### 3.3 项目模块划分



#### 3.3.1 用户模块

​	使用spring social 对qq登陆，github 登陆进行统一整合, 并交给spring security 的过滤器链统一管理，

首次登陆的用户允许直接进入系统，后台进行隐式注册。用户可对自身资料进行修改。



#### 3.3.2 文章管理

​	登陆的用户可以发布文章和提问，并且能进行修改和删除操作。

#### 3.3.3 评论管理

​	登陆的用户在文章下面发布评论，并且能进行删除操作。

#### 3.3.4 社交模块

​	登陆的用户可以选择关注其他用户，也可被其他用户关注。并且可以在个人资料查看社交圈信息。

#### 3.3.5 后台管理模板

​	管理员可进行登陆后台，可对用户、文章、评论进行删除操作。对系统进行监控，查看数据源信息，API接口

。

#### 3.3.6 日志模块

​	完整的日志记录，使用	Spring AOP 特性,快速切入每个接口监控网站每一个变动，用户登陆时间，ip地址，退出时间，每一个操作，完整记录。管理员可登入后台查看日志记录。



### 3.4 系统主要界面实现

​	本系统UI设计采用Bootstarp，简单大气， 后台辅助adminlte快速搭建 ，响应式设计，适应三端设备。

#### 3.4.1 用户登陆

​	用户点击github 、qq图标可进行登陆

![QQ截图20190418170918](images\QQ截图20190418170918.png)

#### 3.4.2 首页

![QQ截图20190418171232](images\QQ截图20190418171232.png)



#### 3.4.3 发布文章

​	使用前端框架wangEditor快速构建，用户体验良好



![QQ截图20190418171158](images\QQ截图20190418171158.png)

#### 3.4.4 个人信息

![QQ截图20190418171517](images\QQ截图20190418171517.png)

#### 3.4.5 文章详情



![QQ截图20190418171345](images\QQ截图20190418171345.png)

#### 3.4.6 评论

​	![QQ截图20190418171413](images\QQ截图20190418171413.png)

#### 3.4.7 后台登陆

  ![QQ截图20190418171626](images\QQ截图20190418171626.png)

#### 3.4.8 系统Api管理

 ![QQ截图20190418172022](images\QQ截图20190418172022.png)



#### 3.4.9 列表管理

![QQ截图20190418171741](images\QQ截图20190418171741.png)

## 4 小结

​	毕业是一个重要的综合性实践环节，旨在培养学生综合运用所学知识和技术，针对具体应用问题，进行分析、设计和解决问题的能力，拓展学生的知识面，练习和掌握新而实用的开发技术，为毕业设计做好技术准备和课题调研等工作。按规范化方法逐步完成毕业设计工作。

​	以前做一些应用的系统开发，随意性大，想到那里做到那里，没有统一的规划，一旦系统成型，出现错误返工修改工作量大，最终的系统可靠性不高。另外一直以来，进行程序设计均采用结构化开发方法，对系统的全貌难以在开发前看到，导致实现的系统不满足需求。

这次的毕业设计开发，主要有以下几点收获：

1．学习到了很多web应用中需要的技术。

2．通过实践，提高了系统分析的能力，对数据流图、数据字典、系统流程图等系统设计工具的使用有了更深刻的认识.

3.更加的认识到自己的专业水平达到了什么高度，自己的弱点在哪。诸如此类的问题，毕业设计给了我更多的思考。

