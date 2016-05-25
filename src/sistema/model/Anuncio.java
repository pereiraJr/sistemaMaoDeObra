package sistema.model;

import java.util.Date;

public class Anuncio {

	private String descricao;
	private String titulo;
	private Date data;
	private Endereco endereço;
	
	public Anuncio() {
		
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
}
