package br.imobifrn.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.imobifrn.entidades.Anuncio;

@Stateless
public class AnuncioDAOImpl implements AnuncioDAO {

	@PersistenceContext(unitName="imobiliaria")
	EntityManager em;
	
	@Override
	public void criarAnuncio(Anuncio anuncio) {
		em.persist(anuncio);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Anuncio> getAll() {
		Query query = em.createNamedQuery("getAllAnuncios");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Anuncio> getImovelValorAsc() {
		Query query = em.createNamedQuery("getAnunciosByPriceASC");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Anuncio> getImovelValorDesc() {
		Query query = em.createNamedQuery("getAnunciosByPriceDESC");
		return query.getResultList();
	}
}
