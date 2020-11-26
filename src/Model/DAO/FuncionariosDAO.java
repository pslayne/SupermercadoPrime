package Model.DAO;

import java.sql.*;
import java.util.ArrayList;

import Model.VO.FuncionariosVO;

public class FuncionariosDAO extends BaseDAO{
	public void inserir(FuncionariosVO funcionario) {
		conn = getConnection();
		String sql = "insert into funcionarios(id_cargo, cpf, nome, endereco, email, data_nasc) values(?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setLong(1, funcionario.getCargo().getCodigo());
			ptst.setString(1, funcionario.getCpf());
			ptst.setString(3, funcionario.getNome());
			ptst.setString(4, funcionario.getEndereco());
			ptst.setString(5, funcionario.getEmail());
			ptst.setDate(6, new Date(funcionario.getDataNascimento().getTimeInMillis()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(FuncionariosVO funcionario){
		
	}
	
	public void atualizar(FuncionariosVO funcionario, FuncionariosVO novoFuncionario) {
		
	}
	
	public ArrayList<FuncionariosVO> buscarID(FuncionariosVO funcionarios){
		return null;
	}
	
	public ArrayList<FuncionariosVO> buscarCPF(FuncionariosVO funcionarios){
		return null;
	}
	
	public ArrayList<FuncionariosVO> buscarNome(FuncionariosVO ffuncionarios){
		return null;
	}
}
