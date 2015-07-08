package br.imobifrn.negocio;

import java.util.List;

import javax.ejb.Remote;

import br.imobifrn.entidades.Anuncio;

@Remote
public interface Imobifrn {

	void criarAnuncio(Anuncio anuncio);

	List<Anuncio> getAnuncios();	
}
