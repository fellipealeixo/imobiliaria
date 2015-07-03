package Entidades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AnuncioDAOImpl implements AnuncioDAO {

	@PersistenceContext(unitName="imobiliaria")
	EntityManager em;
	@Override
	public void criarAnuncio(Anuncio anuncio) {
		// TODO Auto-generated method stub
		
		em.persist(anuncio);

	}

}
