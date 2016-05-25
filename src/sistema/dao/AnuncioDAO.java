package sistema.dao;

import java.util.List;

import Entidades.Anuncio;

public interface AnuncioDAO {
	
	public boolean adicionarAnuncio(Anuncio anuncio);
	public boolean excluirAnuncio(String titulo);
	public List<Anuncio> listarAnuncio();
	public boolean alterarAnuncio(Anuncio anuncio);

}
