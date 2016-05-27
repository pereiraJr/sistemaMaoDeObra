package sistema.dao;

import java.util.List;

import sistema.model.Servico;

public interface ServicoDAO {
	public boolean adicionarServico(Servico servico);
	public boolean excluirServico(String nome);
	public List<Servico> listarServico();
	public boolean alterarServico(Servico servico);
}