package com.lc.hb.dao.base;

import java.io.Serializable;
import java.util.List;

/**
 * 公用接口[HibernateDao]
 * 
 * @author meihl
 * 
 */
public interface HibernateDao<T> {

	/**
	 * 保存实体
	 * 
	 * @param entity
	 * @return
	 */
	public Serializable save(T entity);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 保存或更新实体
	 * 
	 * @param entity
	 */
	public void saveOrUpdate(T entity);

	/**
	 * 删除实体
	 * 
	 * @param entity
	 */
	public void delete(Serializable id);

	/**
	 * 批量删除
	 * 
	 * @param list
	 */
	public void deleteAll(List<T> list);

	/**
	 * 获取单个实体
	 * 
	 * @param entity
	 * @param id
	 * @return
	 */
	public T get(Serializable id);

	/**
	 * 不带参数查询
	 * 
	 * @param sql
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public List find(String hql);

	/**
	 * 带参数查询
	 * 
	 * @param sql
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List find(String hql, Object... values);
}