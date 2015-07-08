package br.imobifrn.fachada;

import java.util.List;

import javax.ejb.Local;

import br.imobifrn.entidades.Anuncio;

@Local
public interface AnuncioFachada {
	
	public boolean criarAnuncio(Anuncio anuncio);

	public List<Anuncio> getAnuncios();
}
