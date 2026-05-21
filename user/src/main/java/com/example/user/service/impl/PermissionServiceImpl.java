package com.example.user.service.impl;

import com.example.user.entity.Permission;
import com.example.user.mapper.PermissionMapper;
import com.example.user.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限明细表 服务实现类
 * </p>
 *
 * @author YourName
 * @since 2025-05-12
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
