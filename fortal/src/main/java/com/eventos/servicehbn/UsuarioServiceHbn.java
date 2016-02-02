package com.eventos.servicehbn;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.eventos.model.Usuario;
import com.eventos.service.UsuarioService;

public class UsuarioServiceHbn extends UsuarioService{

	EntityManager manager;
	
	public UsuarioServiceHbn(EntityManager manager) {
		super(manager);
		this.manager = manager;
	}

	@Override
	public Usuario getUsuario(String login, String senha) throws Exception {
		Session session = (Session) manager.getDelegate();
		
		Criteria criteriaUsuario = session.createCriteria(Usuario.class);
		
		criteriaUsuario.add(Restrictions.eq("login", login));
		criteriaUsuario.add(Restrictions.eq("senha", senha));
		
		Usuario usuario = (Usuario) criteriaUsuario.uniqueResult();
		
		return (Usuario) criteriaUsuario.uniqueResult();
	}
}
