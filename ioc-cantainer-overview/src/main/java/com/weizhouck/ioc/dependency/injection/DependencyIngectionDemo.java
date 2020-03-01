package com.weizhouck.ioc.dependency.injection;

import com.weizhouck.ioc.dependency.annotation.Supper;
import com.weizhouck.ioc.dependency.domain.User;
import com.weizhouck.ioc.dependency.respository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author 飞翔的胖哥
 * @version 1.0.0
 * @description 依赖注入示例
 * @since 2020/2/29 0029 15:13
 **/
public class DependencyIngectionDemo {

    public static void main(String[] args){
        //配置 XML 配置文件
        //启动Spring 上下文
        //内建依赖Bean BeanFactory
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        //自定义依赖Bean BeanFactory
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);

        System.out.println(userRepository);
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory()==beanFactory);
        //System.out.println(beanFactory.getBean(BeanFactory.class));
        ObjectFactory<User> objectFactory = userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject());
        ObjectFactory<ApplicationContext> objectFactoryApp = userRepository.getObjectFactoryApp();
        System.out.println(objectFactoryApp.getObject());
        System.out.println(objectFactoryApp.getObject()==beanFactory);

        //容器内建Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取Environment 类型的 Bean :"+environment);
        whoIsIocContainer(userRepository,beanFactory);
    }

    private static void whoIsIocContainer(UserRepository userRepository,BeanFactory beanFactory){
        // 为什么不成立
        System.out.println("为什么不成立 ? "+ (userRepository.getBeanFactory()==beanFactory));
    }

}
