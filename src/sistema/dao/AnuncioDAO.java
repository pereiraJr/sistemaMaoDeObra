package sistema.dao;

import java.util.List;

import sistema.model.Anuncio;

public interface AnuncioDAO {
	public void adicionarAnuncio(Anuncio anuncio);
	public void excluirAnuncio(int  anuncioId);
	public void alterarAnuncio(Anuncio anuncio);
	public List<Anuncio> listarTodosAnuncios();
	public Anuncio buscarAnuncioPorId(int anuncioId);
}
