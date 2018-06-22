package com.app.whatslike.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class MensagemGrupo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	@NotNull
	private long   id;
	
	@NotNull
	private long   grupo;
	
	@NotNull
	private long msg;
	
	@NotNull
	private long rem;
	
	public long getRem() {
		return rem;
	}

	public void setRem(long rem) {
		this.rem = rem;
	}

	@NotNull
	private boolean lida;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGrupo() {
		return grupo;
	}

	public void setGrupo(long grupo) {
		this.grupo = grupo;
	}

	public long getMsg() {
		return msg;
	}

	public void setMsg(long remetente) {
		this.msg = remetente;
	}

	public boolean getLida() {
		return lida;
	}

	public void setLida(boolean lida) {
		this.lida = lida;
	}
	
}
