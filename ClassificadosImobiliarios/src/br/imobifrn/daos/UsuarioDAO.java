package br.imobifrn.daos;

import javax.ejb.Local;

import br.imobifrn.entidades.Usuario;
import br.imobifrn.exception.UsuarioExistenteExecption;

@Local
public interface UsuarioDAO {
	void salvar(Usuario usuario) throws Exception;
}
