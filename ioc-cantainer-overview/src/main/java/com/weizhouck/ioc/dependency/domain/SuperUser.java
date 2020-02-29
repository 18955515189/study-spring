package com.weizhouck.ioc.dependency.domain;

import com.weizhouck.ioc.dependency.annotation.Supper;
import lombok.Data;

/**
 * @author 飞翔的胖哥
 * @version 1.0.0
 * @description 超级用户
 * @since 2020/2/29 0029 15:43
 **/
@Data
@Supper
public class SuperUser extends User {

    private String adress;

    @Override
    public String toString() {
        return "SuperUser{" +
                "adress='" + adress + '\'' +
                "} " + super.toString();
    }
}
