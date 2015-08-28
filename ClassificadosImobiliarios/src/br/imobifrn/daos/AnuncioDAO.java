package br.imobifrn.daos;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;

import br.imobifrn.entidades.Anuncio;

@Local
public interface AnuncioDAO {
	
	public void criarAnuncio(Anuncio anuncio);

	public List<Anuncio> getAll();
	
	public List<Anuncio> pesquisarAnuncios(int idUsuarioLogado);

	public void removerAnuncio(Anuncio anuncio);

	public void editarAnuncio(Anuncio anuncio);


}
