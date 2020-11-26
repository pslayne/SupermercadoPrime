package Model.BO;

import java.util.ArrayList;

import Model.VO.FuncionariosVO;

public interface InterFuncionariosBO {
	public void adicionar(FuncionariosVO funcionario);
	
	public void remover(FuncionariosVO funcionario);
	
	public void editar(FuncionariosVO funcionario, FuncionariosVO novoFuncionario);
	
	public void buscarID(FuncionariosVO funcionario);
	
	public void buscarCPF(FuncionariosVO funcionario);
	
	public void buscarNome(FuncionariosVO funcionario);
	
	public void listar(ArrayList <FuncionariosVO> funcionarios);
}
