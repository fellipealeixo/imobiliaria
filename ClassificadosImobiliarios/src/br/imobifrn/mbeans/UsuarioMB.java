package br.imobifrn.mbeans;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.imobifrn.entidades.Anuncio;
import br.imobifrn.entidades.Usuario;
import br.imobifrn.exception.UsuarioExistenteException;
import br.imobifrn.fachada.AnuncioFachada;
import br.imobifrn.fachada.UsuarioFachada;

@ManagedBean(name="usuarioMB")
@SessionScoped
public class UsuarioMB {
	
	@EJB
	AnuncioFachada anuncioFachada;
	
	@EJB
	UsuarioFachada usuarioFachada;
	
	private Usuario usuario;
	private String confirmarSenha;
	private String mensagem;
	private String login, senha;
	private boolean logado;
	
	/*
	 * LÃ³gica
	 * */
	public String criarUsuario() throws UsuarioExistenteException{
		if (login != null && !login.equals("") &&
			senha != null && !senha.equals("") &&
			confirmarSenha != null && !confirmarSenha.equals("")) {
			if (senha.equals(confirmarSenha)) {
				usuario = new Usuario(login, senha);
				usuarioFachada.criarUsuario(usuario);
				usuario = new Usuario();
				return "index.xhtml";
			}
			else {
				this.setMensagem("As senha nÃ£o correspondem");
			}
		}
		else {
			this.setMensagem("Todos os campos precisam ser preenchidos");
		}
		return "cadastroUsuario.xhtml";
	}
	
	public String efetuarLogin() {
		if (!login.isEmpty() && !senha.isEmpty() ) {
			usuario = usuarioFachada.autenticar(login, senha);
			if (usuario == null) {
				this.setMensagem("Informações não correspondem a um usuário válido!");
			}
			else {
				logado = true;
			}
		} else {
			this.setMensagem("Forneça as informações de login e senha!");
		}
		return "index.xhtml";
	}
	
	public String logout() {
		usuario = new Usuario();
		login = "";
		logado = false;
		return "index.xhtml";
	}
	
	/*
	 * Gets e Seters	
	 * */
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getMensagem() {
		String retorno = mensagem;
		mensagem = "";
		return retorno;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isComMensagem() {
		return !mensagem.isEmpty();
	}
	
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
	
	public boolean isLogado() {
		return logado;
	}
	
	public boolean isNotLogado() {
		return !logado;
	}

	public UsuarioMB() {
		super();
		usuario = new Usuario();
		confirmarSenha = "";
		mensagem = "";
		logado = false;
	}
	
	public List<Anuncio> getAnunciosUsuarioLogado()
	{
		if(isLogado())
			return fachada.getAnunciosUsuarioLogado(usuario.getId());
		
		this.setMensagem("NÃ£o existe usuario logado");
		return "index.xhtml";
	}
}
