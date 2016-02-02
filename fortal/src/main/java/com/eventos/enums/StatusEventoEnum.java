package com.eventos.enums;

import java.util.ArrayList;
import java.util.List;

public enum StatusEventoEnum {

	STATUS_ATIVO("Ativo"),
	STATUS_INATIVO("Inativo");
	
	private String descricao;
	
	StatusEventoEnum(String descricao){
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

}
