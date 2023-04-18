package com.atguigu.common.config.mp;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode
 */
@Configuration
@MapperScan(basePackages = {"com.atguigu.auth.mapper","com.atguigu.process.mapper","com.atguigu.wechat.mapper"})
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 分页插件，一级和二级缓存遵循mybatis的规则，
     * 需设置ConfigurationCustomizer=false避免缓存出现问题
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }
}
