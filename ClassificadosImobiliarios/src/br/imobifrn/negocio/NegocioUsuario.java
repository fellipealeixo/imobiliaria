package br.imobifrn.negocio;

import java.util.List;

import javax.ejb.Local;

import br.imobifrn.entidades.Usuario;
import br.imobifrn.exception.UsuarioExistenteException;

@Local
public interface NegocioUsuario {

	public Usuario autenticar(String login, String senha);

	public boolean criarUsuario(Usuario usuario) throws UsuarioExistenteException;
	
	public List<Usuario> listarUsuarios();
}
