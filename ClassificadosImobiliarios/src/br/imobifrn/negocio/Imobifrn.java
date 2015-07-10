package br.imobifrn.negocio;

import java.util.List;

import javax.ejb.Local;

import br.imobifrn.entidades.Anuncio;
import br.imobifrn.entidades.Usuario;

@Local
public interface Imobifrn {

	public boolean criarAnuncio(Anuncio anuncio);

	public List<Anuncio> getAnuncios();	
	
	public boolean criarUsuario(Usuario usuario);
}
