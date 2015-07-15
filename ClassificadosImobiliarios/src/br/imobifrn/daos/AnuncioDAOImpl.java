package br.imobifrn.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.imobifrn.entidades.Anuncio;
import br.imobifrn.entidades.TipoAnuncio;

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
	
	public void editarAnuncio(Anuncio anuncio, 
	String conteudo, 
	TipoAnuncio tipoAnuncio,
	double metragem,
	String bairro,
	int numeroDeQuartos, 
	double valor)
	{
		anuncio.setBairro(bairro);
		anuncio.setConteudo(conteudo);
		anuncio.setMetragem(metragem);
		anuncio.setNumeroDeQuartos(numeroDeQuartos);
		anuncio.setTipoAnuncio(tipoAnuncio);
		anuncio.setValor(valor);
		em.merge(anuncio);
	}


}
