package util;

public class Validacoes {
	
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
		
		public static boolean isCNPJ(String CNPJ) {
			if(CNPJ.length() != 18) 
				return false;
			else {
				int soma = 0, resto = 0;
				int numeros[] = new int[14];
				
				//transforma o CPF em um vetor de inteiros desconsiderando pontos e traços 
				for(int i = 0, j = 0; i < 14; i++) {
					numeros[i] = Character.getNumericValue(CNPJ.charAt(j));	
					
					if (j == 1 || j == 5 || j == 9 || j == 14)  
						j += 2;
					  else 
						j++;
				}
				
				//testa se todos os dígitos são iguais
				boolean iguais[] = new boolean[13];
				boolean a = false;
				for (int i = 0; i < 13; i++) {
					int j = i + 1;
					
					for (; j < 14; j++) 
						if (numeros[i] == numeros[j])
							a = true;
						else
							a = false;
					
					iguais[i] = a;
				}
				
				for (int i = 0; i < 13; i++)
					if(!iguais[i]) {
						a = false;
						break;
					}
				
				//se forem o cnpj é inválido
				if (a) 
					return false;
				else {
					//teste do primeiro dígito verificador
					for (int i = 11, j = 2; i >= 0; i--) {
						soma += numeros[i] * j;
						j++;
						if (j == 10)
							j = 2;
					}
					
					resto = soma % 11;
					
					if (resto == 0 || resto == 1)
						resto = 0;
					else 
						resto = 11 - resto;
					
					//se for diferente o cnpj é inválido
					if (resto != numeros[12])
						return false;
					else {
						soma = 0;
						//teste do segundo dígito verificador
						for (int i = 12, j = 2; i >= 0; i--) {
							soma += numeros[i] * j;
							j++;
							if (j == 10)
								j = 2;
						}
						resto = soma % 11;
						
						if (resto == 0 || resto == 1)
							resto = 0;
						else 
							resto = 11 - resto;
						
						
						//se for diferente o cnpj é inválido
						if (resto != numeros[13])
							return false;
						else 
							return true;
					}
				}
			}
		}
}
