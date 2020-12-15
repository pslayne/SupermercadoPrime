package Model.DAO;
import java.sql.*;
import Model.BO.CargoBO;
import Model.VO.CargoVO;

public class CargoDAO extends BaseDAO{
	public void inserir(CargoVO cargo){
		conn = getConnection();
		String sql = "insert into cargo(nome_cargo) values(?);";
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setString(1, cargo.getNome());
			ptst.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(CargoVO cargo) {
		conn = getConnection();
		String sql = "delete from cargo where id_cargo = ?;";
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setInt(1, cargo.getCodigo());
			ptst.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(CargoVO cargo, CargoVO novoCargo) {
		conn = getConnection();
		CargoBO bo = new CargoBO();
		CargoVO c = bo.buscarID(cargo);
		PreparedStatement ptst;
		
		try {
			if (c != null) {
				String sql = "update cargo set nome_cargo = ? where id_cargo = ?;";
				ptst = conn.prepareStatement(sql);
				ptst.setString(1, novoCargo.getNome());
				ptst.setInt(2, cargo.getCodigo());
				ptst.execute();
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarID(CargoVO cargo) {
		conn = getConnection();
		String sql = "select * from cargo where id_cargo = ?;";
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, cargo.getCodigo());
			rs = ptst.executeQuery();
			conn.close();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarNome(CargoVO cargo) {
		conn = getConnection();
		String sql = "select * from cargo where nome_cargo ilike ?;";
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, cargo.getNome());
			rs = ptst.executeQuery();
			conn.close();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet listar() {
		conn = getConnection();
		String sql = "select * from cargo";
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			conn.close();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
