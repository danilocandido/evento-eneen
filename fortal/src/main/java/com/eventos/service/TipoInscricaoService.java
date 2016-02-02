package com.eventos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.eventos.model.TipoInscricao;

public class TipoInscricaoService extends RegraNegocioService<TipoInscricao>{

//	EntityManager manager;
	
	public TipoInscricaoService(EntityManager manager) {
		super(manager);
	}

	
//	public TipoInscricaoService(EntityManager manager){
//		this.manager = manager;
//	}
	
	public Map<Long, String> getMap(List<TipoInscricao> lista){
		Map<Long, String> map = new HashMap<Long, String>();
		for (TipoInscricao tipoInscricao : lista) {
			map.put(tipoInscricao.getId(), tipoInscricao.getDescricao() + "( R$ "+ tipoInscricao.getValor()+ ")");
		}
		
		return map;
	}
	
	public TipoInscricao buscarPorId(Long id) throws Exception{
		TipoInscricao tipoInscricao = manager.find(TipoInscricao.class, id);
		
		return tipoInscricao;
	}
	
	public List<TipoInscricao> listAll(){
		TypedQuery<TipoInscricao> query = manager.createQuery("from TipoInscricao", TipoInscricao.class);
		return query.getResultList();
	}
	
	public void salvar(TipoInscricao tipoInscricao) throws Exception{
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		manager.persist(tipoInscricao);
		
		transaction.commit();
		manager.close();
	}
}
