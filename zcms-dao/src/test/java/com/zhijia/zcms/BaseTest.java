package com.zhijia.zcms;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

//使用@RunWith(SpringJUnit4ClassRunner.class),使测试运行于Spring测试环境，不过貌似删除也可以
@RunWith(SpringJUnit4ClassRunner.class)

//读取spring的配置文件，初始化容器数据
// @ContextConfiguration 注解有以下两个常用的属性：
// locations：可以通过该属性手工指定 Spring 配置文件所在的位置,可以指定一个或多个 Spring 配置文件
// inheritLocations：是否要继承父测试类的 Spring 配置文件，默认为 true
@ContextConfiguration(locations={"classpath:/spring-beans.xml"})
//@ContextConfiguration("classpath:beans.xml")
//@ContextConfiguration(locations={"classpath:spring-beans.xml"})
//测试方法的事务控制   
//transactionManager="txManager":spring配置文件中事务的管理   
//defaultRollback=false：是否恢复数据库的现场
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)

//AbstractTransactionalJUnit4SpringContextTests:这个类为我们解决了在web.xml中
//配置OpenSessionInview所解决的session生命周期延长的问题，所以要继承这个类
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests  {
	
}
