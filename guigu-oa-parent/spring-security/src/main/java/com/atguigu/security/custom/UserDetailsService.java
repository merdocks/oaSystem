package com.atguigu.security.custom;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode
 */
public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService {
    /**
     * 根据用户名获取用户对象（获取不到直接抛异常）
     */
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
