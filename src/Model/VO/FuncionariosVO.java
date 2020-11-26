package Model.VO;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;

public class FuncionariosVO {
	 private static final AtomicInteger count = new AtomicInteger(0);
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
     
     public FuncionariosVO() {
    	 setCodigo();
     }
     
     // getters e setters
    public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo() {
		codigo = count.incrementAndGet(); 	
	} 
	
	public String getCpf() {
		if (cpf == null)
			return "";
		else
			return cpf;
	}
	
	public void setCpf(String cpf) {
		if(isCPF(cpf)) {
			this.cpf = cpf;
		}
		else
			System.out.println("CPF inválido");
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
			System.out.println("Nome inválido!");
	}
	
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String d) {
		if (d != null && !d.isEmpty()) {
			Calendar dataNascimento = new GregorianCalendar();
			
			int dia = Integer.parseInt(d.substring(0, 1));
			int mes = Integer.parseInt(d.substring(3, 4));
			int ano = Integer.parseInt(d.substring(6, 9));
			
			if(dia > 0 && dia <= 31 && mes > 0 && mes <= 12)
				if (mes == 2 && dia > 28)
					System.out.println("Data de nascimento inválida!");
				else
					dataNascimento.set(ano, mes, dia);
		}
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
			System.out.println("Endereco inválido!");
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
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		if (salario > 0) 
			this.salario = salario;
		else
			System.out.println("Salário inválido");
	}
	
	public String getLogin() {
		if (login == null)
			return "";
		else
			return login;
	}
	
	public void setLogin(String login) {
		if (login != null && !login.isEmpty())
			this.login = login.toUpperCase();
		else 
			System.out.println("Login inválido!");
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
			System.out.println("Senha inválido!");
	}
	
	public static boolean isCPF(String CPF) {
		if(CPF.length() != 14)
			return false;
		else {
			int soma = 0, resto = 0;
			int numeros[] = new int[11];
			
			//transforma o CPF em um vetor de inteiros desconsiderando pontos e traços 
			for(int i = 0, j = 0; i < 11; i++) {
				numeros[i] = Character.getNumericValue(CPF.charAt(j));	
				
				if (j == 2 || j == 6 || j == 10)  
					j += 2;
				  else 
					j++;
			}
			
			//testa se todos os dígitos são iguais
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
			
			//se forem o CPF é inválido
			if (a)
				return false;
			else {
				//teste do primeiro dígito verificador
				for (int i = 0, j = 10; i < 9; i++, j--)
					soma += numeros[i] * j;
				
				resto = (soma * 10) % 11;
				
				if (resto == 10 || resto == 11)
					resto = 0;
				
				//se for diferente o cpf é inválido
				if (resto != numeros[9]) {
					System.out.println("erro 1DV");
					return false;
				} else {
					soma = 0;
					//teste do segundo dígito verificador
					for (int i = 0, j = 11; i < 10; i++, j--)
						soma += numeros[i] * j;
					
					resto = (soma * 10) % 11;
					
					if (resto == 10 || resto == 11)
						resto = 0;
					
					//se for diferente o cpf é inválido
					if (resto != numeros[10])
						return false;
					else
						return true;
				}
			}
		}
		}
		
		public String gerarCPF(){
			Random random = new Random();
			int n[] = new int[11];
			int soma = 0;
			
			for(int i = 0; i < 9; i++) 
				n[i] = random.nextInt(10);
			
			for (int i = 0, j = 10; i < 9; i++, j--)
				soma += n[i] * j;
			
			n[9] = (soma * 10) % 11;
			
			if (n[9] == 10 || n[9] == 11)
				n[9] = 0;
			
			for (int i = 0, j = 11; i < 10; i++, j--)
				soma += n[i] * j;
			
			n[10] = (soma * 10) % 11;
			
			if (n[9] == 10 || n[9] == 11)
				n[9] = 0;
			
			String r = n[0] + "" + n[1] + "" + n[2] + "-" + n[3] + "" + n[4] + "" + n[5] + "-" + n[6] + "" + n[7] + "" + n[8] + "."+ n[9] + "" + n[10];
			
			return r;
		}
	}
		