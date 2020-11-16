package Model.BO;

import Model.VO.FuncionariosVO;

public class FuncionariosBO {
	FuncionariosVO funcionario = new FuncionariosVO();
	
	public void adicionar(FuncionariosVO funcionario) {
		//verifica se o funcionário já existe, se não, adiciona um novo funcionario 
	}
	
	public void remover(FuncionariosVO funcionario) {
		//verifica se o funcionário existe, se sim, remove um funcionario 
	}
	
	public void editar(FuncionariosVO funcionario) {
		//verifica se o funcionário existe, se sim, atualiza um funcionario 
	}
	
	public static void buscar(FuncionariosVO funcionario) {
		//busca entre os funcionarios no banco de dados
	}
	
	public static void listar() {
		//lista todos os funcionarios que resultaram da busca
	}
}
