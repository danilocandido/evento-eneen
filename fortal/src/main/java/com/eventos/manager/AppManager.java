package com.eventos.manager;

import org.mentawai.action.LogoutAction;
import org.mentawai.ajax.AjaxConsequence;
import org.mentawai.ajax.renderer.JsonRenderer;
import org.mentawai.authorization.AuthorizationManager;
import org.mentawai.authorization.Group;
import org.mentawai.core.ApplicationManager;
import org.mentawai.filter.AuthenticationFilter;

import com.eventos.action.EventoAction;
import com.eventos.action.HelloAction;
import com.eventos.action.LoginAction;
import com.eventos.action.PaginasAction;
import com.eventos.action.TipoInscricaoAction;
import com.eventos.action.UsuarioAction;
import com.eventos.enums.GrupoUsuarioEnum;

public class AppManager extends ApplicationManager {

	
	@Override
	public void init() {
		super.init();
		
		Group administrador = new Group(GrupoUsuarioEnum.GRUPO_ADMINISTRADOR.toString());
		AuthorizationManager.addGroup(administrador);
		
		Group participante = new Group(GrupoUsuarioEnum.GRUPO_PARTICIPANTE.toString());
		AuthorizationManager.addGroup(participante);
		
	}
	
	@Override
	public void loadFilters() {
	     
		// Setando o filtro de autenticação no application manager
	    filter(new AuthenticationFilter());
	    	on(LOGIN, fwd("/jsp/login/login.jsp"));
	    	
	    
	}
	
	@Override
    public void loadActions() {
		
		//LoginAction
		action(LoginAction.class, "execute")    // Nota: quando vc não define nenhum método, o método execute() é chamado
			.on(SUCCESS, redir(PaginasAction.class, "index"))
	        .on(ERROR, fwd("/jsp/login/login.jsp"));
		
		//LogoutAction
		action(LogoutAction.class, "execute")   // Nota: como nenhum método foi especificado, o método execute() será usado
        	.on(SUCCESS, redir("/jsp/login/login.jsp"));
		
		//PaginasAction
		action(PaginasAction.class, "index")
		 	.on(SUCCESS, fwd("/jsp/index.page"));
		
		//UsuarioAction
		action(UsuarioAction.class, "cadastro") //esse cadastro só é chamado quando um admin está logado
			.on(SUCCESS, fwd("/jsp/usuario/cadastro.page"))
			.on(ERROR, fwd("/jsp/usuario/cadastro.page"));
		
		action(UsuarioAction.class, "cadastroSemAutenticar") //esse cadastro é chamado por qualquer um sem precisar estar logado
		    .bypassAuthentication()
		    .on(SUCCESS, fwd("/jsp/usuario/cadastroSemAutenticar.jsp"))
		    .on(ERROR, fwd("/jsp/usuario/cadastroSemAutenticar.jsp"));
		
		action(UsuarioAction.class, "salvar")
			.on(ACCESSDENIED, redir(LoginAction.class, "execute"))
		    .bypassAuthentication()
		    .on(SUCCESS, fwd("/jsp/usuario/cadastro.page"))
		    .on(ERROR, fwd("/jsp/usuario/cadastro.page"));
		
		action(UsuarioAction.class, "carregarMunicipios")
			.bypassAuthentication()
			.on(SUCCESS, new AjaxConsequence(new JsonRenderer())); //isso salvou meu dia
		
        
		//EventoAction
		action(EventoAction.class, "cadastro")
			.on(SUCCESS, fwd("jsp/evento/cadastro.page"));
		
		action(EventoAction.class, "salvar")
		 	.on(SUCCESS, redir(EventoAction.class, "cadastro"));
		
		action(EventoAction.class, "listar")
	 	.on(SUCCESS, fwd("jsp/evento/lista.page"));
		
		
		//Tipo Inscricao
		action(TipoInscricaoAction.class, "cadastro")
			.on(SUCCESS, fwd("jsp/tipoInscricao/cadastro.page"));
		
		action(TipoInscricaoAction.class, "salvar")
			.on(SUCCESS, redir(TipoInscricaoAction.class, "cadastro"));
		
		
		//HelloAction
        action("/Hello", HelloAction.class, "hi")
            .on(SUCCESS, fwd("/jsp/hello.page"));
         
        
    }
}
