package br.imobifrn.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.imobifrn.daos.AnuncioDAO;
import br.imobifrn.daos.UsuarioDAO;
import br.imobifrn.entidades.Anuncio;
import br.imobifrn.entidades.Usuario;
import br.imobifrn.exception.UsuarioExistenteExecption;

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
	public boolean criarUsuario(Usuario usuario) {
		try {
			if (usuario != null) {
				daoUsuario.salvar(usuario);
				return true;
			}
			return false;
		}
		catch (UsuarioExistenteExecption ex) {
			return false;
		}
		catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Anuncio> getAnunciosByValorASC() {
		return daoAnuncio.getImovelValorAsc();
	}

	@Override
	public List<Anuncio> getAnunciosByValorDESC() {
		return daoAnuncio.getImovelValorDesc();
	}

}
