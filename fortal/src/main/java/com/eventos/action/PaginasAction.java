package com.eventos.action;

import javax.persistence.EntityManager;

import org.mentawai.core.BaseAction;

import com.eventos.enums.GrupoUsuarioEnum;
import com.eventos.model.GrupoUsuario;
import com.eventos.model.Usuario;
import com.eventos.service.EventoService;
import com.eventos.service.GrupoUsuarioService;
import com.eventos.servicehbn.EventoServiceHbn;
import com.eventos.util.JpaUtil;

//	${pageContext.request.contextPath}/resources/css/lineicons/style.css"

public class PaginasAction extends BaseAction {
	
	private EntityManager manager;
	private GrupoUsuarioService grupoUsuarioService;
	private EventoService eventoService;
	
	public PaginasAction() {
		manager = JpaUtil.getEntityManager();
		
		grupoUsuarioService = new GrupoUsuarioService(manager);
		eventoService = new EventoServiceHbn(manager);
	}

	public String index() throws Exception{
		
		Usuario usuario = (Usuario) getUserSession();
		
		application.setAttribute("usuario", usuario);
		
		
		GrupoUsuario grupoUsuarioParticipante = grupoUsuarioService.carregarPorDescricao(GrupoUsuario.class, GrupoUsuarioEnum.GRUPO_PARTICIPANTE.name());
		if(usuario.getGrupoUsuario().getId() == grupoUsuarioParticipante.getId()){
			 
		}
		
		return SUCCESS;
	}
}
