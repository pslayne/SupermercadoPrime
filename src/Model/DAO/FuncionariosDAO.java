package Model.DAO;

import java.sql.*;
import Model.VO.FuncionariosVO;

public class FuncionariosDAO extends BaseDAO{
	public void inserir(FuncionariosVO funcionario) {
		conn = getConnection();
		String sql = "insert into funcionarios(id_cargo, cpf, nome, endereco, email, data_nasc, salario, login, senha) values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setInt(1, funcionario.getCargo().getCodigo());
			ptst.setString(2, funcionario.getCpf());
			ptst.setString(3, funcionario.getNome());
			ptst.setString(4, funcionario.getEndereco());
			ptst.setString(5, funcionario.getEmail());
			ptst.setDate(6, new Date(funcionario.getDataNascimento().getTimeInMillis()));
			ptst.setDouble(7, funcionario.getSalario());
			ptst.setString(8, funcionario.getLogin());
			ptst.setString(9, funcionario.getSenha());
			
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(FuncionariosVO funcionario){
		conn = getConnection();
		String sql = "delete from funcionarios where id_func = ?;";
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setInt(1, funcionario.getCodigo());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(FuncionariosVO funcionario, FuncionariosVO novoFuncionario) {
		conn = getConnection();
		String sql = "update funcionarios set id_cargo = ?, cpf = ?, nome = ?, endereco = ?, email = ?, data_nasc = ?, login = ?, senha = ?, salario = ? where id_func = ?";
		PreparedStatement ptst;
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, novoFuncionario.getCargo().getCodigo());
			ptst.setString(2, novoFuncionario.getCpf());
			ptst.setString(3, novoFuncionario.getNome());
			ptst.setString(4, novoFuncionario.getEndereco());
			ptst.setString(5, novoFuncionario.getEmail());
			ptst.setDate(6, new Date(novoFuncionario.getDataNascimento().getTimeInMillis()));
			ptst.setString(7, novoFuncionario.getLogin());
			ptst.setString(8, novoFuncionario.getSenha());
			ptst.setDouble(9, novoFuncionario.getSalario());
			
			ptst.setInt(10, funcionario.getCodigo());
			ptst.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarID(FuncionariosVO funcionario){
		conn = getConnection();
		String sql = "select * from funcionarios where id_func = ?";
		
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, funcionario.getCodigo());
			rs = ptst.executeQuery();
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarCPF(FuncionariosVO funcionario){
		conn = getConnection();
		String sql = "select * from funcionarios where cpf = ?;";
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, funcionario.getCpf());
			rs = ptst.executeQuery();
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarNome(FuncionariosVO funcionario){
		conn = getConnection();
		String sql = "select * from funcionarios where nome = ?;";
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, "%" + funcionario.getNome() + "%");
			rs = ptst.executeQuery();
			
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet listar(){
		conn = getConnection();
		String sql = "select * from funcionarios";
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}
