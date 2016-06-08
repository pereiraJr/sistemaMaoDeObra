package sistema.dao;

import java.util.List;

import sistema.model.Usuario;

public interface UsuarioDAO {
	public void adicionarUsuario(Usuario usuario);
	public void excluirUsuario(int  usuarioId);
	public void alterarUsuario(Usuario usuario);
	public List<Usuario> listarTodosUsuarios();
	public Usuario buscarUsuarioPorId(int usuarioId);
	public Usuario buscarUsuarioPorLogin (String login);
}
