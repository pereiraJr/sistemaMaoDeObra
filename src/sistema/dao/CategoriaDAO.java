package sistema.dao;

import java.util.List;

import Entidades.Categoria;

public interface CategoriaDAO {

	public boolean adicionarCategoria(Categoria categoria);
	public boolean excluirCategoria(String nome);
	public List<Categoria> listarCategoria();
	public boolean alterarCategoria(Categoria categoria);
}
