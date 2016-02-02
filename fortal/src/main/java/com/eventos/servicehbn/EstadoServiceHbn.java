package com.eventos.servicehbn;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.eventos.model.Municipio;
import com.eventos.service.EstadoService;

public class EstadoServiceHbn extends EstadoService{

	EntityManager manager;
	
	public EstadoServiceHbn(EntityManager manager) {
		super(manager);
		this.manager = manager;
	}
	
	@Override
	public List<Municipio> listarPorEstado(Long estadoID) {
		Session session = (Session) manager.getDelegate();
		Criteria criteriaMunicipio = session.createCriteria(Municipio.class);
		
		criteriaMunicipio.add(Restrictions.eq("estado.id", estadoID));
		
		return criteriaMunicipio.list();
	}

}
