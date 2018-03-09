package com.lc.hb.dao.base;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.lc.common.util.GenericsUtils;

/**
 * 公用接口实现[HibernateDao]
 */
@Repository("hibernateDao")
public class HibernateDaoImpl<T> extends HibernateDaoSupport implements HibernateDao<T> {

    @SuppressWarnings("unchecked")
    protected Class<T> t = GenericsUtils.getSuperClassGenricType(getClass(), 0);

    @Resource
    private HibernateTemplate hibernateTemplate;

    @PostConstruct
    public void initHibernateTemplate() {
        super.setHibernateTemplate(hibernateTemplate);
    }

    @Override
    public Serializable save(T entity) {
        return getHibernateTemplate().save(entity);
    }

    @Override
    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    public void delete(Serializable id) {
        getHibernateTemplate().delete(get(id));
    }

    @Override
    public void deleteAll(List<T> list) {
        getHibernateTemplate().deleteAll(list);
    }

    @Override
    public T get(Serializable id) {
        return getHibernateTemplate().get(t, id);
    }

    public List find(String hql) {
        return getHibernateTemplate().find(hql);
    }

    public List find(String hql, Object... values) {
        return getHibernateTemplate().find(hql, values);
    }
}
