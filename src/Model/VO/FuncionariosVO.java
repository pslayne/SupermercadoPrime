package Model.VO;

import java.util.Calendar;

public class FuncionariosVO {
     private int codigo;
	 private String cpf; 
     private String nome;
     private Calendar dataNascimento; 
     private String email;
     private String endereco;
     private CargoVO cargo;
     private double salario;
     private String login;
     private String senha;
     
     // getters e setters
    public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int cod) {
		codigo = cod; 	
	} 
	
	public String getCpf() {
		if (cpf == null)
			return "";
		else
			return cpf;
	}
	
	public void setCpf(String cpf) {
		//if(isCPF(cpf)) {
			this.cpf = cpf;
		//}
		//else
			//System.out.println("CPF inv�lido");
	}
	
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
			System.out.println("Nome inv�lido!");
	}
	
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	
	public String getDataNascimento(Calendar data) {
		return Util.formataData(data);
	}
	
	public void setDataNascimento(String d) {
		if (d != null && !d.isEmpty()) {
			Calendar dataNascimento = Util.formataData(d);
			if(dataNascimento != null)		
				this.dataNascimento = dataNascimento;
			else System.out.println("Data de nascimento inv�lida!");
		} else System.out.println("Data de nascimento inv�lida!");
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
			System.out.println("Email inv�lido");	
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
			System.out.println("Endereco inv�lido!");
	}
	
	public CargoVO getCargo() {
		return cargo;
	}
	
	public void setCargo(CargoVO cargo) {
		if(cargo != null) 
			this.cargo = cargo;
		else
			System.out.println("Cargo inv�lido");
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		if (salario > 0) 
			this.salario = salario;
		else
			System.out.println("Sal�rio inv�lido");
	}
	
	public String getLogin() {
		if (login == null)
			return "";
		else
			return login;
	}
	
	public void setLogin(String login) {
		if (login != null && !login.isEmpty())
			this.login = login;
		else 
			System.out.println("Login inv�lido!");
	}
	
	public String getSenha() {
		if (senha == null)
			return "";
		else
			return senha;
	}
	public void setSenha(String senha) {
		if (senha != null && !senha.isEmpty())
			this.senha = senha.toUpperCase();
		else 
			System.out.println("Senha inv�lido!");
	}
	
	public String toString() {
		String r = "nome: " + getNome() + "\nCargo: " + getCargo().getNome() + "\nCPF: " + getCpf() + "\nC�digo: " + getCodigo();
		r = r + "\nEndere�o: " + getEndereco() + "\nEmail: " + getEmail() + "\nData de Nascimento: " + getDataNascimento(getDataNascimento()) + "\nSal�rio: ";
		r = r + getSalario() + "\nLogin: " + getLogin();
		return r;
	}
	
	public static boolean isCPF(String CPF) {
		if(CPF.length() != 14)
			return false;
		else {
			int soma = 0, resto = 0;
			int numeros[] = new int[11];
			
			//transforma o CPF em um vetor de inteiros desconsiderando pontos e tra�os 
			for(int i = 0, j = 0; i < 11; i++) {
				numeros[i] = Character.getNumericValue(CPF.charAt(j));	
				
				if (j == 2 || j == 6 || j == 10)  
					j += 2;
				  else 
					j++;
			}
			
			//testa se todos os d�gitos s�o iguais
			boolean iguais[] = new boolean[10];
			boolean a = false;
			for (int i = 0; i < 10; i++) {
				int j = i + 1;
				
				for (; j < 11; j++) 
					if (numeros[i] == numeros[j])
						a = true;
					else
						a = false;
				
				iguais[i] = a;
			}
			
			for (int i = 0; i < 10; i++)
				if(!iguais[i]) {
					a = false;
					break;
				}
			
			//se forem o CPF � inv�lido
			if (a)
				return false;
			else {
				//teste do primeiro d�gito verificador
				for (int i = 0, j = 10; i < 9; i++, j--)
					soma += numeros[i] * j;
				
				resto = (soma * 10) % 11;
				
				if (resto == 10 || resto == 11)
					resto = 0;
				
				//se for diferente o cpf � inv�lido
				if (resto != numeros[9]) {
					System.out.println("erro 1DV");
					return false;
				} else {
					soma = 0;
					//teste do segundo d�gito verificador
					for (int i = 0, j = 11; i < 10; i++, j--)
						soma += numeros[i] * j;
					
					resto = (soma * 10) % 11;
					
					if (resto == 10 || resto == 11)
						resto = 0;
					
					//se for diferente o cpf � inv�lido
					if (resto != numeros[10])
						return false;
					else
						return true;
				}
			}
		}
	}
	}
		