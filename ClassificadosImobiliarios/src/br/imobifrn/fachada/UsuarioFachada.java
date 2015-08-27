package br.imobifrn.fachada;

import java.util.List;

import javax.ejb.Local;

import br.imobifrn.entidades.Usuario;
import br.imobifrn.exception.UsuarioExistenteException;

@Local
public interface UsuarioFachada {
	
	public boolean criarUsuario(Usuario usuario) throws UsuarioExistenteException;

	public Usuario autenticar(String login, String senha);
	
	public List<Usuario> listarUsuarios();
}
