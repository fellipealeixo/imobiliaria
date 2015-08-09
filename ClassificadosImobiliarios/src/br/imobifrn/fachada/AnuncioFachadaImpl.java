package br.imobifrn.fachada;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.imobifrn.entidades.Anuncio;
import br.imobifrn.entidades.Usuario;
import br.imobifrn.negocio.Imobifrn;
import br.imobifrn.negocio.NegocioUsuario;

@Stateless
public class AnuncioFachadaImpl implements AnuncioFachada {
	
	@EJB
	Imobifrn imobifrn;
	
	public AnuncioFachadaImpl() {
		super();
	}
	
	public boolean criarAnuncio(Anuncio anuncio){
		return imobifrn.criarAnuncio(anuncio);
	}

	public List<Anuncio> getAnuncios() {
		return imobifrn.getAnuncios();
	}
	
	public List<Anuncio> getAnunciosUsuarioLogado(int idUsuarioLogado)
	{
		return imobifrn.getAnunciosUsuarioLogado(idUsuarioLogado);
	}
	
	public void removerAnuncio(Anuncio anuncio)
	{
		imobifrn.removerAnuncio(anuncio);
	}
}
