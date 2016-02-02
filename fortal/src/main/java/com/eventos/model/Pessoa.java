package com.eventos.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pessoa")
public class Pessoa implements Serializable{

	private Long id;
	private String nome;
	private String email;
	private Usuario usuario; 
	private String cpf;
	private String rg;
	private Municipio municipio;
	private String telefone;
	private String telefoneEmergencia;
	private String universidade;
	
	//Getters and Setters
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false, length = 255)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(nullable = false, length = 255)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//relacionamento um para um com Usuario
	@OneToOne(cascade = CascadeType.ALL, optional = false, targetEntity = com.eventos.model.Usuario.class)
	@JoinColumn(name="usuario_id", nullable = false)
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Column(nullable = false, length = 13)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Column(nullable = false, length = 25)
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = com.eventos.model.Municipio.class)
	@JoinColumn(name = "municipio_id", nullable = false)
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	@Column(nullable = false, length = 255)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Column(nullable = false, length = 255)
	public String getTelefoneEmergencia() {
		return telefoneEmergencia;
	}
	public void setTelefoneEmergencia(String telefoneEmergencia) {
		this.telefoneEmergencia = telefoneEmergencia;
	}
	
	@Column(nullable = false, length = 255)
	public String getUniversidade() {
		return universidade;
	}
	public void setUniversidade(String universidade) {
		this.universidade = universidade;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
