package br.imobifrn.fachada;

import javax.ejb.Local;

import br.imobifrn.entidades.Usuario;
import br.imobifrn.exception.UsuarioExistenteException;

@Local
public interface UsuarioFachada {
	
	public boolean criarUsuario(Usuario usuario) throws UsuarioExistenteException;

	public Usuario autenticar(String login, String senha);
}
