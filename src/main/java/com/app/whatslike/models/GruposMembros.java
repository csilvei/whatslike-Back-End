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
public class GruposMembros implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	@NotNull
	private long   id;
	
	@NotNull
	private long membro;
	
	@NotNull
	private long grupo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMembro() {
		return membro;
	}

	public void setMembro(long membro) {
		this.membro = membro;
	}

	public long getGrupo() {
		return grupo;
	}

	public void setGrupo(long grupo) {
		this.grupo = grupo;
	}
	
	
	
}
