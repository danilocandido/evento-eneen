package com.eventos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.eventos.model.Estado;
import com.eventos.model.Municipio;

public abstract class EstadoService extends RegraNegocioService<Estado> {

	public EstadoService(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	
	public abstract List<Municipio> listarPorEstado(Long estadoID);
	
	public Map<Long, String> getMap(List<Estado> estados) throws Exception{
		Map<Long, String> mapEstados = new HashMap<Long, String>();
		
		for (Estado estado : estados) {
			mapEstados.put(estado.getId(), estado.getDescricao());
		}
		
		return mapEstados;
	}
	
}
