package br.imobifrn.daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import br.imobifrn.entidades.Usuario;
import br.imobifrn.exception.UsuarioExistenteExecption;

@Stateless
public class UsuarioDAOImpl implements UsuarioDAO {

	@PersistenceContext(unitName="imobiliaria")
	private EntityManager em;
	
	@Override
	public void salvar(Usuario usuario) throws Exception {
		em.persist(usuario);
	}

	@Override
	public void alterarUsuario(Usuario usuario) {
		//Usuario us;
		//us = em.find(Usuario.class, usuario.getId());
		em.merge(usuario);
	}

	@Override
	public Usuario selecionarUsuario(Usuario usuario) {
		// Query para obter um usuário.
		//Query query = em.createQuery("Select e FROM usuario e WHERE e.id = :id");
		//query.setParameter("id", usuario.getId());
		//Usuario result2 = (Usuario)query.getSingleResult();
		Usuario result2 = new Usuario();
		result2.setId(1);
		result2.setLogin("Marcelo");
		result2.setSenha("123");
		
		return result2;
	}
}
