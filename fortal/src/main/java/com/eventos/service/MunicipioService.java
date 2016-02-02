package com.eventos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.eventos.model.Estado;
import com.eventos.model.Municipio;

public class MunicipioService extends RegraNegocioService<Municipio> {

	public MunicipioService(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
	
	public Map<Long, String> getMap(List<Municipio> municipios) throws Exception{
		Map<Long, String> mapEstados = new HashMap<Long, String>();
		
		for (Municipio municipio : municipios) {
			mapEstados.put(municipio.getId(), municipio.getDescricao());
		}
		
		return mapEstados;
	}

}
