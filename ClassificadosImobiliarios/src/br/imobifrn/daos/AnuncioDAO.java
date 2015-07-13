package br.imobifrn.daos;

import java.util.List;

import javax.ejb.Local;
import br.imobifrn.entidades.Anuncio;

@Local
public interface AnuncioDAO {
	
	public void criarAnuncio(Anuncio anuncio);

	public List<Anuncio> getAll();
	
	public List<Anuncio> getImovelValorAsc();
	
	public List<Anuncio> getImovelValorDesc();

}
