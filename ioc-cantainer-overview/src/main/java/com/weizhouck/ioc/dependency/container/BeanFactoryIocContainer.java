package com.weizhouck.ioc.dependency.container;

import com.weizhouck.ioc.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author 飞翔的胖哥
 * @version 1.0.0
 * @description IOC 容器示例
 * @since 2020/3/1 0001 2:06
 **/
public class BeanFactoryIocContainer {


    public static void main(String[] args){
        // 第一步 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int beanDefinitionsCount = reader.loadBeanDefinitions(location);
        System.out.println("Bean 定义加载数量: "+beanDefinitionsCount);

        //依赖查找 集合对象
        lookupCollectionInByType(beanFactory);
    }

    private static void lookupCollectionInByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("按类型查找到的所有的User集合对象"+userMap);
        }
    }
}
