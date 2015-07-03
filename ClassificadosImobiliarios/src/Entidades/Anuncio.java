package Entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Anuncio
 *
 */
@Entity

public class Anuncio implements Serializable {
	private int id;
	private String conteudo;
	private TipoAnuncio tipoAnuncio;
	private double metragem;
	private String bairro;
	private int numeroDeQuartos;
	private double valor;
	private static final long serialVersionUID = 1L;

	public Anuncio() {
		super();
	}   
	
	
	public Anuncio(int id, String conteudo, TipoAnuncio tipoAnuncio, double metragem, String bairro,
			int numeroDeQuartos, double valor) {
		super();
		this.id = id;
		this.conteudo = conteudo;
		this.tipoAnuncio = tipoAnuncio;
		this.metragem = metragem;
		this.bairro = bairro;
		this.numeroDeQuartos = numeroDeQuartos;
		this.valor = valor;
	}


	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	
	public String getConteudo() {
		return this.conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	} 
	
	@Enumerated(EnumType.STRING)
	public TipoAnuncio getTipoAnuncio() {
		return this.tipoAnuncio;
	}
	
	public void setTipoAnuncio(TipoAnuncio tipoAnuncio) {
		this.tipoAnuncio = tipoAnuncio;
	}   
	
	public double getMetragem() {
		return this.metragem;
	}

	public void setMetragem(double metragem) {
		this.metragem = metragem;
	}   
	
	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}   
	
	public int getNumeroDeQuartos() {
		return this.numeroDeQuartos;
	}

	public void setNumeroDeQuartos(int numeroDeQuartos) {
		this.numeroDeQuartos = numeroDeQuartos;
	}   
	
	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
   
}
