package com.varaisys.intranet.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractDao<PK extends Serializable, T> {
	private final Class<T> persistentClass;
	@Resource
	@Qualifier(value = "mysql")
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];

	}

	@SuppressWarnings("deprecation")
	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);

	}

	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(T entity) {
		getSession().persist(entity);
		getSession().flush();
	}

}
