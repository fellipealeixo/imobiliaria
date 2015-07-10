package br.imobifrn.daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.eclipse.persistence.exceptions.DatabaseException;

import br.imobifrn.entidades.Usuario;
import br.imobifrn.exception.UsuarioExistenteExecption;

@Stateless
public class UsuarioDAOImpl implements UsuarioDAO {

	@PersistenceContext(unitName="imobiliaria")
	private EntityManager em;
	
	@Override
	public void salvar(Usuario usuario) throws Exception {
		try {
			em.persist(usuario);
		}
		catch (DatabaseException e) {
			throw new Exception(e.getMessage());
		}
	}
}
