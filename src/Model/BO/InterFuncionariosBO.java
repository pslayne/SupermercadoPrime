package Model.BO;

import java.util.List;
import Model.VO.FuncionariosVO;

public interface InterFuncionariosBO {
	public void adicionar(FuncionariosVO funcionario);
	
	public void remover(FuncionariosVO funcionario);
	
	public void editar(FuncionariosVO funcionario, FuncionariosVO novoFuncionario);
	
	public FuncionariosVO buscarID(FuncionariosVO funcionario);
	
	public List<FuncionariosVO> buscarCPF(FuncionariosVO funcionario);
	
	public List<FuncionariosVO> buscarNome(FuncionariosVO funcionario);
	
	public FuncionariosVO buscarLoginSenha(FuncionariosVO funcionario);
	
	public List<FuncionariosVO> listar();
	
	public void mostrar(List <FuncionariosVO> funcionarios);
}
