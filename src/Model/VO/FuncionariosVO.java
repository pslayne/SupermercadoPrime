package Model.VO;

import util.Validacoes;
import java.util.Calendar;

public class FuncionariosVO {
	 private String nome;
     private int codigo;
     private String cpf;
     private Calendar dataNascimento;
     private String telefone;
     private String email;
     private String endereco;
     private CargoVO cargo;
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
			this.nome = nome.toUpperCase();
		else 
			System.out.println("Nome inválido!");
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
		if (cpf == null)
			return "";
		else
			return cpf;
	}
	
	public void setCpf(String cpf) {
		if(Validacoes.isCPF(cpf)) {
			this.cpf = cpf;
			System.out.println("ok");
		}
		else
			System.out.println("CPF inválido");
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	
	public CargoVO getCargo() {
		return cargo;
	}
	
	public void setCargo(CargoVO cargo) {
		if(cargo != null) 
			this.cargo = cargo;
		else
			System.out.println("Cargo inválido");
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