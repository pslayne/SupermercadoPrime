package Model.VO;

public class Funcionarios {
	 private String nome;
     private int codigo;
     private String cpf;
     private String telefone;
     private String email;
     private String endereco;
     private int codigoCargo;
     private String cidade;
     private String estado;
     
     // getters e setters
     
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		if(codigo>0)
		   this.codigo = codigo;
		else
		   System.out.println("Código inválido");	
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if(cpf.length() == 11)
			this.cpf = cpf;
		else
			System.out.println("CPF inválido");
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		if(telefone.length() == 9)
			this.telefone = telefone;
		else
			System.out.println("Telefone inválido");	
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if(email.indexOf("@")> -1)
			this.email = email;
		else
			System.out.println("Email inválido");	
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco.toUpperCase();
	}
	
	public int getCodigoCargo() {
		return codigoCargo;
	}
	
	public void setCodigoCargo(int codigoCargo) {
		if(codigoCargo>0)
			this.codigoCargo = codigoCargo;
		else
			System.out.println("Código inválido");	
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
}