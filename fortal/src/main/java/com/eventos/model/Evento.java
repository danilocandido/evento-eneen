package com.eventos.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.eventos.enums.StatusEventoEnum;

@Entity
@Table(name = "Evento")
public class Evento {

	private Long id;
	private String descricao;
	private Set<TipoInscricao> tipoInscricoes;
	private Date dataInicio;
	private Date dataFim;
	private String urlSite;
	private String email;
	private int limite;
	private Date dataInicioInscricao;
	private Date dataFimInscricao;
	private StatusEventoEnum statusEventoEnum;
	
	//Getters and Setters
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 255, nullable = false)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="evento_tiposInscricao", 
		joinColumns={@JoinColumn(name="evento_id", referencedColumnName="id")}, 
		inverseJoinColumns={@JoinColumn(name="tipo_inscricao_id", referencedColumnName="id")})
	public Set<TipoInscricao> getTipoInscricoes() {
		return tipoInscricoes;
	}
	public void setTipoInscricoes(Set<TipoInscricao> tipoInscricoes) {
		this.tipoInscricoes = tipoInscricoes;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	@Column(length = 255, nullable = false)
	public String getUrlSite() {
		return urlSite;
	}
	public void setUrlSite(String urlSite) {
		this.urlSite = urlSite;
	}
	
	@Column(length = 255, nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(nullable = false)
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	@Temporal(TemporalType.DATE)
	@Column( nullable = false)
	public Date getDataInicioInscricao() {
		return dataInicioInscricao;
	}
	public void setDataInicioInscricao(Date dataInicioInscricao) {
		this.dataInicioInscricao = dataInicioInscricao;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	public Date getDataFimInscricao() {
		return dataFimInscricao;
	}
	public void setDataFimInscricao(Date dataFimInscricao) {
		this.dataFimInscricao = dataFimInscricao;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public StatusEventoEnum getStatusEventoEnum() {
		return statusEventoEnum;
	}
	public void setStatusEventoEnum(StatusEventoEnum statusEventoEnum) {
		this.statusEventoEnum = statusEventoEnum;
	}
	
	
	//Equals and Hascode
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
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
