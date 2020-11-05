package Model.VO;

public class Funcionarios {
	 private String nome;
     private int codigo;
     private String cpf;
     private String telefone;
     private String email;
     private String endereco;
     private Cargo cargo;
     private String cidade;
     private String estado;
     
     // getters e setters
     
	public String getNome() {
		if (nome == null)
			return "";
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
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if(validaCPF(cpf))
			this.cpf = cpf;
		else
			System.out.println("CPF inválido");
	}
	
	public String getTelefone() {
		if (telefone == null)
			return "";
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
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		if (endereco != null && !endereco.isEmpty()) 
			this.endereco = endereco.toUpperCase();
		else
			System.out.println("Endereço inválido");
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public void setCargo(Cargo cargo) {
		if(cargo != null) 
			this.cargo = cargo;
		else
			System.out.println("Cargo inválido");
	}
	
	public String getCidade() {
		if (cidade == null)
			return "";
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
		return estado;
	}
	
	public void setEstado(String estado) {
		if (estado != null && !estado.isEmpty()) 
			this.estado = estado;
		else 
			System.out.println("Estado inválido");
	}
	
	public boolean validaCPF(String CPF) {
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
		boolean iguais = false;
		for (int i = 0; i < 11; i++) {
			int j = i + 1;
			
			for (; j < 11; j++) 
				if (numeros[i] == numeros[j])
					iguais = true;
				else
					iguais = false;
		}
		//se forem o CPF é inválido
		if (iguais)
			return false;
		else {
			//teste do primeiro dígito verificador
			for (int i = 0, j = 10; i < 9; i++, j--)
				soma += numeros[i] * j;
			
			resto = (soma * 10) % 11;
			
			if (resto == 10 || resto == 11)
				resto = 0;
			
			//se for diferente o cpf é inválido
			if (resto != numeros[9])
				return false;
			
			else {
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