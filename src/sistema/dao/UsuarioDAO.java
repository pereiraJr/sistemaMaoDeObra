package sistema.dao;

import java.util.List;

import sistema.model.Usuario;

public interface UsuarioDAO {
	public void adicionarUsuario(Usuario usuario);
	public void excluirUsuario(Integer usuarioId);
	public List<Usuario> listarTodosUsuarios();
	public void alterarUsuario(Usuario usuario);
	public Usuario buscarUsuarioPorId(Integer usuarioId);
}
