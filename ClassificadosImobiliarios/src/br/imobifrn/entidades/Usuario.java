package br.imobifrn.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="buscarUsuario", query="SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha")
})

@Entity
public class Usuario implements Serializable {
	private int id;
	private String login;
	private String senha;
	private boolean bloqueado;
	private static final long serialVersionUID = 1L;
	
	public Usuario() {
		super();
		anuncios = new List<Anuncio>();
	}
	
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
		this.bloqueado = false;
		anuncios = new List<Anuncio>();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(unique=true)
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
}
