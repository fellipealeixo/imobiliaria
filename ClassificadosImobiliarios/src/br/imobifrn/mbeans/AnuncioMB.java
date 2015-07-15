package br.imobifrn.mbeans;

import java.util.ArrayList;
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
	
	private List<Anuncio> anunciosCrescente;
	private List<Anuncio> anunciosDecrescente;
	
	private boolean ordena = true;
	private boolean ordenaDesc = false;
	
	public AnuncioMB() {
		super();
		anuncio = new Anuncio();
		anuncios = new ArrayList<Anuncio>();
		anunciosCrescente  = new ArrayList<Anuncio>();
		anunciosDecrescente = new ArrayList<Anuncio>();
		
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
	
	public List<Anuncio> getAnunciosCrescente(){
		anunciosCrescente = fachada.sortByValorASC();
		return anunciosCrescente;
	}
	
	public List<Anuncio> getAnunciosDecrescente(){
		anunciosDecrescente = fachada.sortByValorDESC();
		return anunciosDecrescente;
	}
	
	public List<Anuncio> sortByAsc() {
		 
			if (ordena && (ordenaDesc == false)){
				//setAnuncios(fachada.sortByValorASC());
				ordena = false;
				ordenaDesc = true;
			}else
				{
				//setAnuncios(fachada.sortByValorDESC());
				ordena = true;
				ordenaDesc = false;
				}
		   return anuncios;
		   
	}
	
	public boolean isSortAscTrue() {
		return ordena == true;
	}
	
	public boolean isSortDescTrue(){
		return ordenaDesc == true;
	}
	
	
	
}
