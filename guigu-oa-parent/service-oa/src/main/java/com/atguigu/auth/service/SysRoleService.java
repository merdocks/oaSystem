package com.atguigu.auth.service;

import com.atguigu.model.system.SysRole;
import com.atguigu.vo.system.AssginRoleVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode
 */
public interface SysRoleService extends IService<SysRole> {

    //1 查询所有的角色和当前用户所属角色
    Map<String, Object> findRoleDataByUserId(Long userId);


    //2 为用户分配角色
    void doAssign(AssginRoleVo assginRoleVo);
}
