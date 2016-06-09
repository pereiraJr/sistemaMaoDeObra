package sistema.model;

public class Anuncio {
	
	private int anuncioId;
	private String titulo;
	private String descricao;
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getAnuncioId() {
		return anuncioId;
	}
	public void setAnuncioId(int anuncioId) {
		this.anuncioId = anuncioId;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
    public String toString() {
        return "Anuncio [anuncioId=" + anuncioId + ", titulo=" + titulo + ", descricao=" + descricao + "]";
    } 

}
