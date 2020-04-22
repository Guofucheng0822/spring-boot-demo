package com.pers.guofucheng.web;

import com.pers.guofucheng.service.AbstractUserService;
import com.pers.guofucheng.vo.AbstractUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * BaseController
 * 所有Controller的父类
 *
 * @author guofucheng
 * @date 2020/04/21
 */
public abstract class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired(required = false)
    private AbstractUserService abstractUserService;

    public AbstractUser getLoginUser() {
        return abstractUserService.getLoginUser();
    }

}
