package com.weizhouck.ioc.dependency.container;

import com.weizhouck.ioc.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author 飞翔的胖哥
 * @version 1.0.0
 * @description IOC 容器示例
 * @since 2020/3/1 0001 2:06
 **/
@Configuration
public class AnnotationApplicationContextIocContainer {

    public static void main(String[] args){
        // 第一步 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类作为配置类
        applicationContext.register(AnnotationApplicationContextIocContainer.class);
        applicationContext.refresh();
        //依赖查找 集合对象
        lookupCollectionInByType(applicationContext);
    }

    @Bean
    public User user(){
        User user = new User();
        user.setId(1L);
        user.setName("zhouwei");
        return user;
    }


    private static void lookupCollectionInByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("按类型查找到的所有的User集合对象"+userMap);
        }
    }
}
