package br.imobifrn.daos;

import java.util.HashMap;
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
	@Override
	public List<Anuncio> pesquisarAnuncios(int idUsuarioLogado)
	{
		String queryString = "from Anuncio a where a.usuario.id = " + Integer.toString(idUsuarioLogado);
		
		
		
//		if(parametros.containsKey("id"))
//			queryString += " a.usuarioid = " + parametros.get("id");
//		else
//			queryString += " a.usuarioid != 0";
//		
//		if(parametros.containsKey("conteudo"))
//			queryString += " and conteudo like '%" + parametros.get("conteudo") + "%'";
//		if(parametros.containsKey("tipoAnuncio"))
//			queryString += " and tipoAnuncio = " + parametros.get("tipoAnuncio");
//		if(parametros.containsKey("metragem"))
//			queryString += " and metragem = " + parametros.get("metragem");
//		if(parametros.containsKey("bairro"))
//			queryString += " and bairro = " + parametros.get("bairro");
//		if(parametros.containsKey("numeroDeQuartos"))
//			queryString += " and numeroDeQuartos = " + parametros.get("numeroDeQuartos");
//		if(parametros.containsKey("valor"))
//			queryString += " and valor = " + parametros.get("valor");
		
		System.out.println(queryString);
		
		Query query = em.createQuery(queryString);
		return query.getResultList();
	}

	@Override
	public void removerAnuncio(Anuncio anuncio) {
		Anuncio anuncioParaRemocao = em.getReference(Anuncio.class, anuncio.getId());
		em.remove(anuncioParaRemocao);
	}
}
