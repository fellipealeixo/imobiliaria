package br.imobifrn.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.imobifrn.daos.UsuarioDAO;
import br.imobifrn.entidades.Usuario;
import br.imobifrn.exception.UsuarioExistenteException;

@Stateless
public class NegocioUsuarioImpl implements NegocioUsuario {

	@EJB
	UsuarioDAO daoUsuario;
	
	@Override
	public Usuario autenticar(String login, String senha) {
		return daoUsuario.getUsuarioByLoginESenha(login, senha);
	}

	@Override
	public boolean criarUsuario(Usuario usuario) throws UsuarioExistenteException {
		daoUsuario.salvar(usuario);
		return true;
	}

	@Override
	public List<Usuario> listarUsuarios()
	{
		return daoUsuario.listarUsuarios();
	}
}
