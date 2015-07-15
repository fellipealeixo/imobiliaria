package br.imobifrn.fachada;

import java.util.List;

import javax.ejb.Local;

import br.imobifrn.entidades.Anuncio;
import br.imobifrn.entidades.TipoAnuncio;
import br.imobifrn.entidades.Usuario;

@Local
public interface AnuncioFachada {
	
	public boolean criarAnuncio(Anuncio anuncio);

	public List<Anuncio> getAnuncios();
	
	public boolean criarUsuario(Usuario usuario);
	
	public boolean editarAnuncio(Anuncio anuncio, 
			String conteudo, 
			TipoAnuncio tipoAnuncio,
			double metragem,
			String bairro,
			int numeroDeQuartos, 
			double valor);
}
