package br.imobifrn.fachada;

import java.util.List;

import javax.ejb.Local;

import br.imobifrn.entidades.Anuncio;
import br.imobifrn.entidades.Usuario;

@Local
public interface AnuncioFachada {
	
	public boolean criarAnuncio(Anuncio anuncio);

	public List<Anuncio> getAnuncios();
	
	public boolean criarUsuario(Usuario usuario);
	public boolean alterarUsuario(Usuario usuario);

	public Usuario selecionarUsuario(Usuario usuario);
}
