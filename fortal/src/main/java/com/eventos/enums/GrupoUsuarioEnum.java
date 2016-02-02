package com.eventos.enums;

import java.util.ArrayList;
import java.util.List;

public enum GrupoUsuarioEnum {

	GRUPO_ADMINISTRADOR("Administrador"),
	GRUPO_PARTICIPANTE("Participante");
	
	private String descricao;
	
	GrupoUsuarioEnum(String descricao){
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}
	
	static public List<StatusEventoEnum> lista(){
		List<StatusEventoEnum> lista = new ArrayList<StatusEventoEnum>();
		
		return lista;
	}

	//Getters and Setters
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static GrupoUsuarioEnum carregarPelaDescricao(String descricao){
		for(GrupoUsuarioEnum grupoUsuarioEnum : GrupoUsuarioEnum.values()){
			if(grupoUsuarioEnum.descricao.equals(descricao)){
				return grupoUsuarioEnum;
			}
		}
		return null;
	}
}
