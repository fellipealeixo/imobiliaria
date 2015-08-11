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
		if(queryString.contains("id"))
			queryString += " a.usuarioid = " + parametros.get("id");
		else
			queryString += " a.usuarioid != 0";
		
		if(queryString.contains("usuarioId"))
			queryString += " and a.usuarioId = " + parametros.get("usuarioId");
		if(queryString.contains("conteudo"))
			queryString += " and a.conteudo like '%" + parametros.get("conteudo") + "%'";
		if(queryString.contains("tipoAnuncio"))
			queryString += " and a.tipoAnuncio = " + parametros.get("tipoAnuncio");
		if(queryString.contains("metragem"))
			queryString += " and a.metragem = " + parametros.get("metragem");
		if(queryString.contains("bairro"))
			queryString += " and a.bairro = " + parametros.get("bairro");
		if(queryString.contains("numeroDeQuartos"))
			queryString += " and a.numeroDeQuartos = " + parametros.get("numeroDeQuartos");
		if(queryString.contains("valor"))
			queryString += " and a.valor = " + parametros.get("valor");

		Query query = em.createQuery(queryString);
		return query.getResultList();
	}
	
	public void removerAnuncio(Anuncio anuncio)
	{
		anuncio = em.merge(anuncio);
		em.remove(anuncio);
	}
}
