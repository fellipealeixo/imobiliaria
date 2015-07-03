package negocio;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import Entidades.Anuncio;
import Entidades.AnuncioDAO;

@ManagedBean("AnuncioMB")
@Stateless
public class AnuncioFachada {
	
	@EJB
	AnuncioDAO anuncioDAO;
	
	Anuncio anuncio;
	public AnuncioFachada(){
		anuncio = new Anuncio();
	}
	
	public String paginaCadastro(){
		return "cadastroImovel.jsp";
	}
	public String criarAnuncio(){
		anuncioDAO.criarAnuncio(anuncio);
		return "main.jsp";
	}
	
}
