package br.imobifrn.negocio;

import java.util.List;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.imobifrn.daos.AnuncioDAO;
import br.imobifrn.daos.UsuarioDAO;
import br.imobifrn.entidades.Anuncio;
import br.imobifrn.entidades.Usuario;
import br.imobifrn.exception.UsuarioExistenteException;

@Stateless
public class ImobifrnImpl implements Imobifrn {

	@EJB
	AnuncioDAO daoAnuncio;
	@EJB
	UsuarioDAO daoUsuario;
	
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
	
	@Override
	public List<Anuncio> getAnunciosUsuarioLogado(int idUsuarioLogado)
	{
		HashMap<String, String> parametros = new HashMap<String, String>();
		parametros.put("id", isUsuarioLogado);
		return daoAnuncio.pesquisarAnuncios(parametros);
	}
}
