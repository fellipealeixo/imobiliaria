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
	EntityManager em;
	
	@Override
	public void salvar(Usuario usuario) throws Exception {
		em.persist(usuario);
	}

	@Override
	public void alterarUsuario(Usuario usuario) {
		//Usuario us;
		//us = em.find(Usuario.class, usuario.getId());
		//em.persist(usuario);
		em.merge(usuario);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario selecionarUsuario(Usuario usuario) {
		
		Query query = em.createNamedQuery("getUsuario");
		return (Usuario) query.getSingleResult();
		//return (Usuario) query.setParameter(1, usuario).getSingleResult();
		
	}

}
