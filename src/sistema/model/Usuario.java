package sistema.model;


public class Usuario {	
	
	private int usuarioId;
	private String login;
	private String senha;
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	} 
	
	@Override
    public String toString() {
        return "Usuario [usuarioId=" + usuarioId + ", nome=" + nome
                + ", email=" + email + ", telefone=" + telefone + ", endereco="
                + endereco + "]";
    }    

}
