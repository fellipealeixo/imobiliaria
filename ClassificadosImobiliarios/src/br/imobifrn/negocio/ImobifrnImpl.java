package br.imobifrn.negocio;

import java.util.List;

import javax.ejb.EJB;

import br.imobifrn.daos.AnuncioDAO;
import br.imobifrn.entidades.Anuncio;

public class ImobifrnImpl implements Imobifrn {

	@EJB
	AnuncioDAO daoAnuncio;
	
	@Override
	public void criarAnuncio(Anuncio anuncio) {
		if (anuncio != null && anuncio.getId() == 0) {
			daoAnuncio.criarAnuncio(anuncio);
		}
	}

	@Override
	public List<Anuncio> getAnuncios() {
		return daoAnuncio.getAll();
	}

}
