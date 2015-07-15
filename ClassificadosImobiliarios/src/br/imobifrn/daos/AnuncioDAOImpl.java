package br.imobifrn.daos;

import java.util.List;
import java.util.HashMap;

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
	@Override
	public List<Anuncio> pesquisarAnuncios(HashMap<String, String> parametros)
	{
		String queryString = "select a from Anuncio a where";
		if(queryString.containsKey("id"))
			queryString += " id = " + parametros.get("id");
		else
			queryString += " id > 0"
		
		if(queryString.containsKey("conteudo"))
			queryString += " and conteudo like '%" + parametros.get("conteudo") + "%'";
		if(queryString.containsKey("tipoAnuncio"))
			queryString += " and tipoAnuncio = " + parametros.get("tipoAnuncio");
		if(queryString.containsKey("metragem"))
			queryString += " and metragem = " + parametros.get("metragem");
		if(queryString.containsKey("bairro"))
			queryString += " and bairro = " + parametros.get("bairro");
		if(queryString.containsKey("numeroDeQuartos"))
			queryString += " and numeroDeQuartos = " + parametros.get("numeroDeQuartos");
		if(queryString.containsKey("valor"))
			queryString += " and valor = " + parametros.get("valor");

		Query query = em.createQuery(queryString);
		return query.getResultList();
	}
}
