package com.lc.hb.dao;

import com.lc.entity.CommonUser;
import com.lc.hb.dao.base.HibernateDao;

public interface CommonUserDao extends HibernateDao<CommonUser> {

    /**
     * 根据用户名查询user
     */
    public CommonUser getUserByName(String name);
}
