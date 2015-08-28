package br.imobifrn.fachada;

import java.util.List;

import javax.ejb.Local;

import br.imobifrn.entidades.Anuncio;
import br.imobifrn.entidades.Usuario;

@Local
public interface AnuncioFachada {
	
	public boolean criarAnuncio(Anuncio anuncio);

	public List<Anuncio> getAnuncios();
	
	public List<Anuncio> getAnunciosUsuarioLogado(int idUsuarioLogado);
	
	public void removerAnuncio (Anuncio anuncio);

	public void editarAnuncio(Anuncio anuncio);

}
	
