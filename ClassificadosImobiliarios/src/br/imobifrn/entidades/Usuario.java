package br.imobifrn.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
	@NamedQuery(name="buscarUsuario", query="SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha")
})

@Entity
public class Usuario implements Serializable {
	private int id;
	private String login;
	private String senha;
	private boolean bloqueado;
	private boolean admi;
	private List<Anuncio> anuncios;
	private static final long serialVersionUID = 1L;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
		this.bloqueado = false;
		this.admi = false;
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

	public boolean isAdmi() {
		return admi;
	}

	public void setAdmi(boolean admi) {
		this.admi = admi;
	}
	
	@OneToMany(mappedBy="usuario")
	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}
}
