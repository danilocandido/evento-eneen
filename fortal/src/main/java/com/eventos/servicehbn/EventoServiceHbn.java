package com.eventos.servicehbn;

import javax.persistence.EntityManager;

import com.eventos.model.Evento;
import com.eventos.service.EventoService;

public class EventoServiceHbn extends EventoService {

	EntityManager manager;
	
	public EventoServiceHbn(EntityManager manager) {
		super(manager);
		this.manager = manager;
	}

	public Evento buscarUltimoEventoAtivo() throws Exception{
		
		/* esse método deve buscar o ultimo evento ativo - isso esse evento será mostrado
		 * para o usuario participante
		 */
		
		
		return null;
	}
}
