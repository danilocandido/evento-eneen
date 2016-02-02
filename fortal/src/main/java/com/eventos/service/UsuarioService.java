package com.eventos.service;

import javax.persistence.EntityManager;

import com.eventos.model.Usuario;

public abstract class UsuarioService extends RegraNegocioService<Usuario>{

	public UsuarioService(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
	

	public abstract Usuario getUsuario( String login , String senha ) throws Exception;
	
}
