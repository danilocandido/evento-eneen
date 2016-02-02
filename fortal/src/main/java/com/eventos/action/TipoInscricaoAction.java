package com.eventos.action;

import java.util.List;

import javax.persistence.EntityManager;

import org.mentawai.core.BaseAction;

import com.eventos.model.TipoInscricao;
import com.eventos.service.TipoInscricaoService;
import com.eventos.util.JpaUtil;

public class TipoInscricaoAction extends BaseAction {

	public String cadastro() throws Exception{
		
		Long id = input.getLong("id");
		
		EntityManager manager = JpaUtil.getEntityManager();
		TipoInscricaoService tipoInscricaoService = new TipoInscricaoService(manager);
		
		if(id > -1){
			TipoInscricao tipoInscricao = tipoInscricaoService.buscarPorId(id);
			
			output.setObject(tipoInscricao);
			output.setValue("editando", true);
			
		}
		
		List<TipoInscricao> lista = tipoInscricaoService.listAll();
		
		output.setValue("tipoInscricoes", lista);
		
		return SUCCESS;
	}
	
	public String salvar() throws Exception{
		EntityManager manager = JpaUtil.getEntityManager();
		TipoInscricaoService tipoInscricaoService = new TipoInscricaoService(manager);
		
		TipoInscricao tipoInscricao = new TipoInscricao();
		
		input.inject(tipoInscricao);
		
		tipoInscricaoService.salveOrUpdate(tipoInscricao);
		
		return SUCCESS;
	}
}
