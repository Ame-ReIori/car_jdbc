# Car JDBC
Implement the a web system of two-handed car. Now the user's interface is finished.

If you want to run this project.

Make sure the environment!⬇️

	* JDK 1.8 +
	* Maven 3.5 +
	* IntelliJ IDEA (need lombok plugin)
	* Mysql 5.7 +

## 目录结构
|分类|目录|作用|
|---|---|---|
|src/main/java/com/yygq/demo/|annotation/|一些注解|
|src/main/java/com/yygq/demo/|const/|用于存储常量|
|src/main/java/com/yygq/demo/|controller/|控制器，前后端交互|
|src/main/java/com/yygq/demo/|dao/|基础的实现方法|
|src/main/java/com/yygq/demo/|entity/|实体|
|src/main/java/com/yygq/demo/|service/|所提供的服务|
|src/main/java/com/yygq/demo/|DemoApplication.java|启动类|
|---------------------------------------|--------------|---------------------------|
|src/main/resources/|db/|数据库资源|
|src/main/resources/|static/|静态资源|
|src/main/resources/|templates/|模板资源|
|src/main/resources/|application.yml|配置资源|



## 用法说明

首页：http://localohost:8080/index，可跳转到汽车详情界面、订单界面与用户中心

管理员界面：http://localhost:8080/adminInfo

评估师界面：http://localhost:8080/assessorInfo

## 注意事项

- 个人数据库不一样，为了测试翻页我在data.sql里面写了十辆车，四个管理员，四个评估师，但是用户没怎么写，所以大家想测试的话，先多生成一点用户，不然从汽车的ownerID检索不到车主
- html的位置不要随便更改
- 评估师和管理员界面展示的都是ID为1的评估师和管理员，因为我懒得改前端了=.=
- 因为不是真正从前段获得评估师ID，所以大家不要用评估师的启用或禁用功能，删除可用

## BUG

- 第二页的车辆index栏图片无法正常显示，问题不大=.=，回头再dede
- 用户页面的”注销“无法跳转回首页

