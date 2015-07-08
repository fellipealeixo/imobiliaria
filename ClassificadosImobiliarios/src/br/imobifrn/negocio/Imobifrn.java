package br.imobifrn.negocio;

import java.util.List;

import javax.ejb.Local;

import br.imobifrn.entidades.Anuncio;

@Local
public interface Imobifrn {

	public boolean criarAnuncio(Anuncio anuncio);

	public List<Anuncio> getAnuncios();	
}
