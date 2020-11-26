package Model.BO;

import java.util.ArrayList;
import java.util.Iterator;

import Model.DAO.FuncionariosDAO;
import Model.VO.FuncionariosVO;

public class FuncionariosBO implements InterFuncionariosBO{
	FuncionariosDAO dao = new FuncionariosDAO();
	
	public void adicionar(FuncionariosVO funcionario) {
		if(funcionario != null) {
			ArrayList<FuncionariosVO> resultado = dao.buscarCPF(funcionario);
			if(resultado.isEmpty()) 
				dao.inserir(funcionario);
			else System.out.println("Este funcionário já existe");
		} else System.out.println("Funcionário inválido");
	}

	public void remover(FuncionariosVO funcionario) {
		if(funcionario != null) {
			ArrayList<FuncionariosVO> resultado = dao.buscarCPF(funcionario);
			if(!resultado.isEmpty()) 
				dao.remover(funcionario);
			else System.out.println("Este funcionário não existe");
		} else System.out.println("Funcionário inválido");
	}

	public void editar(FuncionariosVO funcionario, FuncionariosVO novoFuncionario) {
		if(funcionario != null && novoFuncionario != null) {
			ArrayList<FuncionariosVO> resultado = dao.buscarNome(funcionario);
			if(!resultado.isEmpty()) 
				dao.atualizar(funcionario, novoFuncionario);
			else System.out.println("Este funcionário não existe");
		} else System.out.println("Funcionário inválido");
	}

	public void buscarID(FuncionariosVO funcionario) {
		listar(dao.buscarID(funcionario));
	}

	public void buscarCPF(FuncionariosVO funcionario) {
		listar(dao.buscarCPF(funcionario));
	}

	public void buscarNome(FuncionariosVO funcionario) {
		listar(dao.buscarNome(funcionario));
	}

	public void listar(ArrayList<FuncionariosVO> funcionarios) {
		Iterator<FuncionariosVO> iterator = funcionarios.iterator();
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
	}

}
