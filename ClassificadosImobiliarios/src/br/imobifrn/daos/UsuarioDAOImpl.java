package br.imobifrn.daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.eclipse.persistence.exceptions.DatabaseException;

import br.imobifrn.entidades.Usuario;
import br.imobifrn.exception.UsuarioExistenteException;

@Stateless
public class UsuarioDAOImpl implements UsuarioDAO {

	@PersistenceContext(unitName="imobiliaria")
	private EntityManager em;
	
	@Override
	public void salvar(Usuario usuario) throws UsuarioExistenteException {
		try {
			em.persist(usuario);
		}
		catch (DatabaseException e) {
			throw new UsuarioExistenteException(e.getMessage());
		}
	}

	@Override
	public Usuario getUsuarioByLoginESenha(String login, String senha) {
		Query consulta = em.createNamedQuery("buscarUsuario"); 
		consulta.setParameter("login", login);
		consulta.setParameter("senha", senha);
		Usuario usr = null;
		try {
			usr = (Usuario) consulta.getSingleResult();
		} catch (PersistenceException pex) {
		}
		return usr;
	}
}
