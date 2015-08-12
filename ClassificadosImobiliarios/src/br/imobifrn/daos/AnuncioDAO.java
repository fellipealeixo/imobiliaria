package br.imobifrn.daos;

import java.util.List;
import java.util.HashMap;

import javax.ejb.Local;
import br.imobifrn.entidades.Anuncio;

@Local
public interface AnuncioDAO {
	
	public void criarAnuncio(Anuncio anuncio);

	public List<Anuncio> getAll();
	
	public List<Anuncio> pesquisarAnuncios(HashMap<String, String> parametros);

	public void removerAnuncio(Anuncio anuncio);

	public List<Anuncio> pesquisarAnunciosDeUsuario(int idUsuario);
}
