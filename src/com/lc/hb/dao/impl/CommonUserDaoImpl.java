package com.lc.hb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lc.entity.CommonUser;
import com.lc.hb.dao.CommonUserDao;
import com.lc.hb.dao.base.HibernateDaoImpl;

@Repository("commonUserDao")
public class CommonUserDaoImpl extends HibernateDaoImpl<CommonUser> implements CommonUserDao {

    /**
     * 根据用户名查询user
     */
    @SuppressWarnings("unchecked")
    @Override
    public CommonUser getUserByName(String name) {
        String hql = "from CommonUser t where t.name = ?";
        List<CommonUser> list = find(hql, name);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

}
