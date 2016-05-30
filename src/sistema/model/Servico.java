package sistema.model;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
*/
//@Entity
public class Servico {
	
	//@Id
	//@GeneratedValue
	private int servicoId;
	private String nome;
	private String preco;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	public int getServicoId() {
		return servicoId;
	}

	public void setServicoId(int servicoId) {
		this.servicoId = servicoId;
	}
	
}
