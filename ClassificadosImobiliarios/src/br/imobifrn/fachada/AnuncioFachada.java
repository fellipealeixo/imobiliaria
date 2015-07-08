package br.imobifrn.fachada;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.imobifrn.entidades.Anuncio;
import br.imobifrn.negocio.Imobifrn;

@ManagedBean("anuncioMB")
@Stateless
public class AnuncioFachada {
	
	@EJB
	Imobifrn imobifrn;
	
	Anuncio anuncio;
	List<Anuncio> anuncios;
	
	public AnuncioFachada(){
		anuncio = new Anuncio();
		anuncios = new ArrayList<Anuncio>();
	}
	
	public String criarAnuncio(){
		imobifrn.criarAnuncio(anuncio);
		return "index.jsp";
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public List<Anuncio> getAnuncios() {
		anuncios = imobifrn.getAnuncios();
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}
}
