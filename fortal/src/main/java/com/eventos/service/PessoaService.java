package com.eventos.service;

import javax.persistence.EntityManager;

import com.eventos.model.Pessoa;

public class PessoaService extends RegraNegocioService<Pessoa>{

	public PessoaService(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
}
