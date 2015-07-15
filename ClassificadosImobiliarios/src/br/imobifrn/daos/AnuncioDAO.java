package br.imobifrn.daos;

import java.util.List;

import javax.ejb.Local;

import br.imobifrn.entidades.Anuncio;
import br.imobifrn.entidades.TipoAnuncio;

@Local
public interface AnuncioDAO {
	
	public void criarAnuncio(Anuncio anuncio);

	public List<Anuncio> getAll();
	
	public void editarAnuncio(Anuncio anuncio, 
			String conteudo, 
			TipoAnuncio tipoAnuncio,
			double metragem,
			String bairro,
			int numeroDeQuartos, 
			double valor);

}
