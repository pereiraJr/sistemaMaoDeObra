package sistema.model;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
*/
//@Entity
public class Categoria {
	
	//@Id
	//@GeneratedValue
	private Integer categoriaId;
	private String nome;
	
	public Integer getcategoriaId() {
		return categoriaId;
	}

	public void setcategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}