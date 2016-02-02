package com.eventos.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.eventos.model.Evento;
import com.eventos.model.TipoInscricao;

public abstract class EventoService extends RegraNegocioService<Evento> {

	public EventoService(EntityManager manager) {
		super(manager);
	}

	public void salvar(Evento evento) throws Exception{
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		manager.persist(evento);
		
		transaction.commit();
		manager.close();
	}
	
	public Evento buscarPorId(Long id) throws Exception{
		Evento evento = manager.find(Evento.class, id);
		
		return evento;
	}
	
	public List<Evento> listAll(){
		TypedQuery<Evento> query = manager.createQuery("from Evento", Evento.class);
		return query.getResultList();
	}
	
}
