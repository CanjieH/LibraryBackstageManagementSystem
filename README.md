# 图书后台管理系统
---
## 项目环境
* 语言: Java
* IDE: Intellij IDEA
* Web服务器: Tomcat8.5
* 数据库: MySQL
* 设计模式: JSP+Servlet+JavaBean构成的MVC模型

## 实现功能
### 登陆注册功能
* 常规登陆注册操作，用户未登陆无法进入主界面，且注册字段经过正则表达式校验
### 图书分类管理
* 添加图书分类，未单独设计表
### 图书管理
* 图书添加
* 图书查询(使用AJAX局部刷新)
* 图书展示


## 使用方式
创建数据库libdb，导入sql脚本，将DBHelper中相关数据配置为自己的设置，导入jar包: servlet、jdbc。
