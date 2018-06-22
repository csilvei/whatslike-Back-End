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
public class Mensagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	@NotNull
	private long   id;
	
	@NotNull
	private String   text;
	
	@NotNull
	private long remetente;
	
	@NotNull
	private long destinatario;
	
	private String remetenteNome;
	
	public String getRemetenteNome() {
		return remetenteNome;
	}

	public void setRemetenteNome(String RemetenteNome) {
		remetenteNome = RemetenteNome;
	}

	private boolean lida;
	
	public boolean isLida() {
		return lida;
	}
	

	public void setLida(boolean lida) {
		this.lida = lida;
	}

	@NotNull
	private boolean grupo;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getRemetente() {
		return remetente;
	}
	
	public void setRemetente(long remetente) {
		this.remetente = remetente;
	}

	public long getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(long destinatario) {
		this.destinatario = destinatario;
	}

	public boolean isGrupo() {
		return grupo;
	}

	public void setGrupo(boolean grupo) {
		this.grupo = grupo;
	}
	
}
