package sistema.dao;

import java.util.List;

import Entidades.Usuario;

public interface IRepositorioUsuario {
	
	public boolean adicionarUsuario(Usuario usuario);
	public boolean excluirUsuario(String email);
	public List<Usuario> listarUsuario();
	public boolean alterarUsuario(Usuario usuario);

}
