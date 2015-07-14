package br.imobifrn.mbeans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.imobifrn.entidades.Anuncio;
import br.imobifrn.fachada.AnuncioFachada;

@ManagedBean(name="anuncioMB")
@SessionScoped
public class AnuncioMB {
	
	@EJB
	AnuncioFachada fachada;
	
	private Anuncio anuncio;
	private List<Anuncio> anuncios;
	
	private boolean ordenaAsc = true;
	
	public AnuncioMB() {
		super();
		anuncio = new Anuncio();
		anuncios = new ArrayList<Anuncio>();
	}
	
	public String criarAnuncio(){
		fachada.criarAnuncio(anuncio);
		anuncio = new Anuncio();
		return "index.xhtml";
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public List<Anuncio> getAnuncios() {
		anuncios = fachada.getAnuncios();
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}
	
	public boolean isPossuiAnuncios () {
		return !this.getAnuncios().isEmpty();
	}
	
	
	public List<Anuncio> sortByAsc() {
		 
			if (ordenaAsc){
				anuncios = fachada.sortByValorASC();
			}else anuncios = fachada.sortByValorDESC();
		   return anuncios;
		   
		}

	
}
