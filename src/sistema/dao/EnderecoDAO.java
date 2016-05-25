package sistema.dao;

import java.util.List;

import Entidades.Endereco;

public interface EnderecoDAO {

	public boolean adicionarEndereco(Endereco endereco);
	public boolean excluirEndereco(String cep);
	public List<Endereco> listarEndereco();
	public boolean alterarEndereco(Endereco endereco);
}
