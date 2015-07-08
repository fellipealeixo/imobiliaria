package br.imobifrn.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.imobifrn.daos.AnuncioDAO;
import br.imobifrn.entidades.Anuncio;

@Stateless
public class ImobifrnImpl implements Imobifrn {

	@EJB
	AnuncioDAO daoAnuncio;
	
	@Override
	public boolean criarAnuncio(Anuncio anuncio) {
		if (anuncio != null && anuncio.getId() == 0) {
			daoAnuncio.criarAnuncio(anuncio);
			return true;
		}
		return false;
	}

	@Override
	public List<Anuncio> getAnuncios() {
		return daoAnuncio.getAll();
	}

}
