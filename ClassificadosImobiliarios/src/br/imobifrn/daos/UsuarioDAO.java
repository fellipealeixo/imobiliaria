package br.imobifrn.daos;

import java.util.List;

import javax.ejb.Local;

import br.imobifrn.entidades.Usuario;
import br.imobifrn.exception.UsuarioExistenteException;

@Local
public interface UsuarioDAO {
	void salvar(Usuario usuario) throws UsuarioExistenteException;
	
	Usuario getUsuarioByLoginESenha(String login, String senha);
	
	List<Usuario> listarUsuarios();
}
