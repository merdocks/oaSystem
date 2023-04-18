package com.atguigu.auth.activiti;

import org.springframework.stereotype.Component;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode
 */
@Component
public class UserBean {

    public String getUsername(int id){
        if (id==1){
            return "lilei";
        }
        if (id==2){
            return "hanmeimei";
        }
        return "admin";
    }
}
