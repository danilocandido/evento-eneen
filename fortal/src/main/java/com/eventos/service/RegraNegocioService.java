package com.eventos.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class RegraNegocioService<T> {
	
	EntityManager manager;
	
	public RegraNegocioService(EntityManager manager){
		this.manager = manager;
	}

	public void salveOrUpdate(T object) throws Exception{
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Object identifier = manager.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(object);
		
		if(identifier == null){
			manager.persist(object);
		}else{
			manager.merge(object);
		}
		
		transaction.commit();
		manager.close();
	}
	
	public T carregarPorDescricao(Class<T> classeGenerica, String descricao) throws Exception{
		Session session = (Session) manager.getDelegate();
		
		Criteria criteria = session.createCriteria(classeGenerica);
		
		criteria.add(Restrictions.eq("descricao", descricao));
		
		return (T) criteria.uniqueResult();
	}
	
	public T carregarPorId(Class<T> classeGenerica, Long id) throws Exception{
		Session session = (Session) manager.getDelegate();
		
		Criteria criteria = session.createCriteria(classeGenerica);
		
		criteria.add(Restrictions.eq("id", id));
		
		return (T) criteria.uniqueResult();
	}
	
	public T listAll(Class<T> classeGenerica) throws Exception{
		Session session = (Session) manager.getDelegate();
		
		Criteria criteria = session.createCriteria(classeGenerica);
		
		return (T) criteria.list();
	}
	
}
