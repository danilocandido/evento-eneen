package com.eventos.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eventos.enums.GrupoUsuarioEnum;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

	private Long id;
	private String login;
	private String senha;
	private Pessoa pessoa;
	private GrupoUsuario grupoUsuario;
	
	//Getters and Setters
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable=false, unique =  true)
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Column(nullable = false, length = 15)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//Na verdade isso é um relacionamento um para um com Pessoa
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = com.eventos.model.Pessoa.class)
	@JoinColumn(name= "pessoa_id", nullable = true)
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = com.eventos.model.GrupoUsuario.class)
	@JoinColumn(name = "grupoUsuario_id", nullable = false)
	public GrupoUsuario getGrupoUsuario() {
		return grupoUsuario;
	}
	public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
		this.grupoUsuario = grupoUsuario;
	}
	
	//Equals and HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
