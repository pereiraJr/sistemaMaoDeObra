package sistema.model;

import java.util.Date;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
*/
//@Entity
public class Anuncio {
	
/*	@Id
	@GeneratedValue
*/	private int anuncioId;
	private String descricao;
	private String titulo;
	private Date data;
	private String endere�o;
	
	public String getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public int getAnuncioId() {
		return anuncioId;
	}

	public void setAnuncioId(int anuncioId) {
		this.anuncioId = anuncioId;
	}
}
