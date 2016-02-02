package com.eventos.action;

import javax.persistence.EntityManager;

import org.mentawai.action.BaseLoginAction;
import org.mentawai.authorization.Group;

import com.eventos.enums.GrupoUsuarioEnum;
import com.eventos.model.Usuario;
import com.eventos.service.TipoInscricaoService;
import com.eventos.service.UsuarioService;
import com.eventos.servicehbn.UsuarioServiceHbn;
import com.eventos.util.JpaUtil;

public class LoginAction extends BaseLoginAction{

	/*		http://www.mentaframework.org/mtw/Page/Authentication/mentawai-autenticacao
	 * 
	 * ainda não implementei a entidade usuario nem configurei no app manager
	 * 
	 */
	
	@Override
	public String execute() throws Exception {
		EntityManager manager = JpaUtil.getEntityManager();
		UsuarioService usuarioService = new UsuarioServiceHbn(manager);
		
		
		String login = input.getString("login");
        String senha = input.getString("senha");
        
        if (!isPost()) return ERROR; // Permitir somente POST.
         
        if (login == null || login.trim().equals("")) {
            return ERROR;
        }
         
        if (senha == null || senha.trim().equals("")) {
            return ERROR;
        }
         
//        if (!login.equals("danilo") || !senha.equals("abc123")) {
//            return ERROR;
//        }
         
        
        Usuario usuario = null;
        usuario = usuarioService.getUsuario(login, senha); 
        
        
        
        /*Uma vez que você chama o método setSessionObj, o usuário ficará autenticado até que a session 
        seja invalidada (quando o método reset for chamado ou quando a session expirar). */
        setUserSession(usuario);
//        setSessionObj(usuario); 

        //editando aqui
        setUserGroup(usuario.getGrupoUsuario().getDescricao());
        System.out.println("GrupoUsuario Descricao: "+ usuario.getGrupoUsuario().getDescricao());
        
//        setSessionGroups();
        
         
        return SUCCESS;
	}
	
}
