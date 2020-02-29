package com.weizhouck.ioc.dependency.respository;

import com.weizhouck.ioc.dependency.domain.User;
import lombok.Data;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @author 飞翔的胖哥
 * @version 1.0.0
 * @description 用户信息仓库
 * @since 2020/2/29 0029 18:54
 **/
@Data
public class UserRepository {

    private Collection<User> users; //自定义Bean

    private BeanFactory beanFactory;//内建非Bean对象 依赖

    private ObjectFactory<User> objectFactory;

    private ObjectFactory<ApplicationContext> objectFactoryApp;


}
