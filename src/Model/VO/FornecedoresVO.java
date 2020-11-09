package Model.VO;

import util.Validacoes;

public class FornecedoresVO {
	
	private String nome;
	private int codigo;
	private String cpf;
	private String telefone;
	private String email;
	private ProdutosVO produto;
	private String endereco;
	private String cidade;
	private String estado;
	
    // getters e setters
    
	public String getNome() {
		if (nome == null)
			return "";
		else 
			return nome;
	}
	
	public void setNome(String nome) {	
		if (nome != null && !nome.isEmpty())
			this.nome = nome;
		else
			System.out.println("Nome inválido");
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		if (codigo > 0) 
			this.codigo = codigo;
		else
			System.out.println("Código inválido");
	}
	
	public String getCpf() {
		if (cpf == null)
			return "";
		else
			return cpf;
	}
	
	public void setCpf(String cpf) {
		if(Validacoes.isCPF(cpf))
			this.cpf = cpf;
		else
			System.out.println("CPF inválido");
	}
	
	public String getTelefone() {
		if (telefone == null)
			return "";
		else
			return telefone;
	}
	
	public void setTelefone(String telefone) {
		if(telefone.length() == 9)
			this.telefone = telefone;
		else
			System.out.println("Telefone inválido");
	}
	
	public String getEmail() {
		if (email == null)
			return "";
		else
			return email;
	}
	
	public void setEmail(String email) {
		if(email.indexOf("@")> -1)
			this.email = email;
		else
			System.out.println("Email inválido");
	}
	
	public ProdutosVO getProduto() {
		return produto;
	}
	
	public void setProduto(ProdutosVO produto) {
		if (produto != null)
			this.produto = produto;
		else 
			System.out.println("Código Inválido!");
	}
	
	public String getEndereco() {
		if (endereco == null)
			return "";
		else
			return endereco;
	}
	
	public void setEndereco(String endereco) {
		if (endereco != null && !endereco.isEmpty())
			this.endereco = endereco.toUpperCase();
		else
			System.out.println("Endereço inválido");
	}
	
	public String getCidade() {
		if (cidade == null)
			return "";
		else
			return cidade;
	}
	
	public void setCidade(String cidade) {
		if (cidade != null && !cidade.isEmpty()) 
			this.cidade = cidade;
		else 
			System.out.println("Cidade inválida");
	}
	
	public String getEstado() {
		if (estado == null)
			return "";
		else
			return estado;
	}
	
	public void setEstado(String estado) {
		if (estado != null && !estado.isEmpty()) 
			this.estado = estado;
		else 
			System.out.println("Estado inválido");
	}
}