package com.eventos.action;

import java.util.List;

import javax.persistence.EntityManager;

import org.mentawai.core.BaseAction;

import com.eventos.enums.StatusEventoEnum;
import com.eventos.model.Evento;
import com.eventos.model.TipoInscricao;
import com.eventos.service.EventoService;
import com.eventos.service.TipoInscricaoService;
import com.eventos.servicehbn.EventoServiceHbn;
import com.eventos.util.JpaUtil;

public class EventoAction extends BaseAction {
	
	private EntityManager manager;
	
	private TipoInscricaoService tipoInscricaoService;
	private EventoService eventoService;
	
	public EventoAction() {
		manager = JpaUtil.getEntityManager();
		
		tipoInscricaoService = new TipoInscricaoService(manager);
		eventoService = new EventoServiceHbn(manager);
	}

	public String cadastro() throws Exception{
		
		Long id = input.getLong("id");
		
		if(tipoInscricaoService.listAll() == null || tipoInscricaoService.listAll().size() <= 0){
			addError("Nenhum Tipo Inscrição cadastrado, por favor cadastre um no link a seguir: "
					 +" <a href='TipoInscricaoAction.cadastro.mtw'>Cadastrar Tipo Inscricao</a>");
			output.setValue("inabilitaForm", true);
		}
		
		if(id > -1){
			Evento evento = eventoService.buscarPorId(id);
			output.setObject(evento);
			
			output.setValue("statusEventoEnums", StatusEventoEnum.values());
			output.setValue("editando", true);
			
		}
		
		List<TipoInscricao> lista = tipoInscricaoService.listAll();
		
		output.setValue("tipoInscricoes", tipoInscricaoService.getMap(lista));
		
		return SUCCESS;
	}
	
	public String salvar() throws Exception{
		
		Evento evento = new Evento();
		
		input.inject(evento);
		evento.setStatusEventoEnum(StatusEventoEnum.STATUS_ATIVO);
		
		eventoService.salvar(evento);
		
		return SUCCESS;
	}
	
	public String listar() throws Exception{
		
		List<Evento> lista = eventoService.listAll();
		
		output.setValue("lista", lista);
		
		return SUCCESS;
	}
}
