package br.imobifrn.fachada;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.imobifrn.entidades.Usuario;
import br.imobifrn.exception.UsuarioExistenteException;
import br.imobifrn.negocio.NegocioUsuario;

@Stateless
public class UsuarioFachadaImpl implements UsuarioFachada {

	@EJB
	private NegocioUsuario usuarios;
	
	public boolean criarUsuario(Usuario usuario) throws UsuarioExistenteException {
		return usuarios.criarUsuario(usuario);
	}

	@Override
	public Usuario autenticar(String login, String senha) {
		return usuarios.autenticar(login, senha);
	}

}
