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
	private String enderešo;
	
	public String getEnderešo() {
		return enderešo;
	}

	public void setEnderešo(String enderešo) {
		this.enderešo = enderešo;
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
