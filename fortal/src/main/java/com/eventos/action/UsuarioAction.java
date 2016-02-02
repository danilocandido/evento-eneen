package com.eventos.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import net.sf.json.JSONObject;

import org.mentawai.core.BaseAction;

import com.eventos.enums.GrupoUsuarioEnum;
import com.eventos.model.Estado;
import com.eventos.model.GrupoUsuario;
import com.eventos.model.Municipio;
import com.eventos.model.Pessoa;
import com.eventos.model.Usuario;
import com.eventos.service.EstadoService;
import com.eventos.service.GrupoUsuarioService;
import com.eventos.service.MunicipioService;
import com.eventos.service.PessoaService;
import com.eventos.servicehbn.EstadoServiceHbn;
import com.eventos.util.JpaUtil;


// implementar esse cadastro e mais atributos na Pessoa: http://bazeet.com/pre-eneen2015/inscricoes/ 

public class UsuarioAction extends BaseAction {

	private EntityManager manager;
	
	private PessoaService pessoaService;
//	private UsuarioService usuarioService;
	private GrupoUsuarioService grupoUsuarioService;
	private MunicipioService municipioService;
	private EstadoService estadoService;
	
	
	public UsuarioAction() {
		manager = JpaUtil.getEntityManager();
		
		pessoaService = new PessoaService(manager);
//		usuarioService = new UsuarioServiceHbn(manager);
		grupoUsuarioService = new GrupoUsuarioService(manager);
		municipioService = new MunicipioService(manager);
		estadoService = new EstadoServiceHbn(manager);
	}
	
	

	public String cadastro() throws Exception{
		boolean ehAdmin = input.getBoolean("ehAdmin");
		
		GrupoUsuario grupoUsuario = null;
		if(ehAdmin){
			grupoUsuario = grupoUsuarioService.carregarPorDescricao(GrupoUsuario.class, GrupoUsuarioEnum.GRUPO_ADMINISTRADOR.name());
		}else{
			grupoUsuario = grupoUsuarioService.carregarPorDescricao(GrupoUsuario.class, GrupoUsuarioEnum.GRUPO_PARTICIPANTE.name());
		}
		
		GrupoUsuarioEnum grupoUsuarioEnum = GrupoUsuarioEnum.valueOf(grupoUsuario.getDescricao());
		
		output.setValue("grupoUsuarioDescricao", grupoUsuarioEnum.toString());
		output.setValue("ehAdmin", ehAdmin);
		output.setValue("estados", estadoService.listAll(Estado.class));
		
		List<Municipio> municipios = new ArrayList<Municipio>();
		output.setValue("municipios", municipios);
		
		return SUCCESS;
	}
	
	public String cadastroSemAutenticar() throws Exception{
		
		List<Estado> listAll = (List<Estado>) estadoService.listAll(Estado.class);
		
		Map<Long, String> mapEstados = estadoService.getMap(listAll);
		mapEstados.put(-1L, "-- Selecione --");
		output.setValue("estados", mapEstados);
		
		List<Municipio> municipios = new ArrayList<Municipio>();
		
		Map<Long, String> mapMunicipios = new HashMap<Long, String>();
		mapMunicipios.put(-1L, " -- Selecione --");
		for (Municipio municipio : municipios) {
			mapMunicipios.put(municipio.getId(), municipio.getDescricao());
		}
		
		output.setValue("municipios", mapMunicipios);
		
		return SUCCESS;
	}
	
	public String salvar() throws Exception{
		
		Pessoa pessoa = new Pessoa();
		input.inject(pessoa);
		
		boolean ehAdmin = input.getBoolean("ehAdmin");
		
		GrupoUsuario grupoParticiante = null;
		if(ehAdmin){
			grupoParticiante = grupoUsuarioService.carregarPorDescricao(GrupoUsuario.class, GrupoUsuarioEnum.GRUPO_ADMINISTRADOR.name());
		}else{
			grupoParticiante = grupoUsuarioService.carregarPorDescricao(GrupoUsuario.class, GrupoUsuarioEnum.GRUPO_PARTICIPANTE.name());
		}
		
		//testes
		Municipio municipio = municipioService.carregarPorId(Municipio.class, 1L);
		pessoa.setMunicipio(municipio);
		
		Usuario usuario = new Usuario();
		usuario.setLogin(input.getString("email"));
		usuario.setGrupoUsuario(grupoParticiante);
		
		input.inject(usuario);
		
		
		pessoa.setUsuario(usuario);
		usuario.setPessoa(pessoa);
		
		pessoaService.salveOrUpdate(pessoa);
		
		if(input.hasValue("semAutenticar")){
			return ACCESSDENIED;
		}
		
		return SUCCESS;
	}
	
	public String carregarMunicipios() throws Exception{
	
		Long estadoID = input.getLong("estadoID");
		
		
		List<Municipio> municipios = estadoService.listarPorEstado(estadoID);
		
//		output.setValue("municipios", municipios);
		
		Map<Long, String> map = municipioService.getMap(municipios);
		
		JSONObject jsonObject = new JSONObject();
		for (Municipio municipio : municipios) {
			jsonObject.put(municipio.getId(), municipio.getDescricao());
		}
		
//		output.setValue("municipios", municipios);
		
		ajax(jsonObject);
		
		return SUCCESS;
	}
}
