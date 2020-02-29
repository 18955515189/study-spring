package com.weizhouck.ioc.dependency.lookup;

import com.weizhouck.ioc.dependency.annotation.Supper;
import com.weizhouck.ioc.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author 飞翔的胖哥
 * @version 1.0.0
 * @description 依赖查找示例
 * @since 2020/2/29 0029 15:13
 **/
public class DependencyLookupDemo {

    public static void main(String[] args){
        //配置 XML 配置文件
        //启动Spring 上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

        //按名称查找
        //实时查找方式
        lookupInRealTimeByName(beanFactory);
        //延时查找方式
        lookupInLazyTimeByName(beanFactory);

        //按类型查找
        //单个 Bean 对象
        lookupInByType(beanFactory);
        //多个 Bean 对象
        lookupCollectionInByType(beanFactory);

        //根据 Java 注解查找
        lookupByAnnotation(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = (Map)listableBeanFactory.getBeansWithAnnotation(Supper.class);
            System.out.println("按类型查找到的所有的User集合对象"+userMap);
        }
    }

    private static void lookupCollectionInByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("按类型查找到的所有的User集合对象"+userMap);
        }
    }

    private static void lookupInByType(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean(User.class);
        System.out.println("按类型实时查找："+user);
    }

    private static void lookupInRealTimeByName(BeanFactory beanFactory){
        User user = (User) beanFactory.getBean("user");
        System.out.println("按名称实时查找："+user);
    }

    private static void lookupInLazyTimeByName(BeanFactory beanFactory){
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("按名称延迟查找："+user);
    }
}
