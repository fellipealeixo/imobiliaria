package br.imobifrn.mbeans;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.imobifrn.entidades.Anuncio;
import br.imobifrn.entidades.Usuario;
import br.imobifrn.fachada.AnuncioFachada;

@ManagedBean(name="usuarioMB")
@SessionScoped
public class UsuarioMB {
	
	@EJB
	AnuncioFachada fachada;
	private Usuario usuario;
	private String confirmarSenha;
	private String mensagem;
	
	public UsuarioMB() {
		super();
		usuario = new Usuario();
		confirmarSenha = "";
		mensagem = "";
	}
	
	/*
	 * Lógica
	 * */
	public String criarUsuario(){
		if (usuario.getLogin() != null && !usuario.getLogin().equals("") &&
			usuario.getSenha() != null && !usuario.getSenha().equals("") &&
			confirmarSenha != null && !confirmarSenha.equals("")) {
			if (usuario.getSenha().equals(confirmarSenha)) {
				fachada.criarUsuario(usuario);
				usuario = new Usuario();
				return "index.xhtml";
			}
			else {
				this.setMensagem("As senha não correspondem");
			}
		}
		else {
			this.setMensagem("Todos os campos precisam ser preenchidos");
		}
		return "cadastroUsuario.xhtml";
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
	
	public List<Anuncio> getAnunciosUsuarioLogado()
	{
		if(isLogado())
			return fachada.getAnunciosUsuarioLogado(usuario.getId());
		
		this.setMensagem("Não existe usuario logado");
		return "index.xhtml";
	}
}
