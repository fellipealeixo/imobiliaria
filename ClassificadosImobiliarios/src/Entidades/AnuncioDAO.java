package Entidades;







import javax.ejb.Local;

@Local
public interface AnuncioDAO {
	
	public void criarAnuncio(Anuncio anuncio);

}
