package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.BO.TipoBO;
import Model.VO.TipoVO;

public class TipoDAO extends BaseDAO {
	public void inserir(TipoVO tipo) {
		conn = getConnection();
		String sql = "insert into tipos(nome_tipo) values(?);";
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setString(1, tipo.getNome());
			ptst.execute();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(TipoVO tipo) {
		conn = getConnection();
		String sql = "delete from tipos where id_tipo = ?;";
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setInt(1, tipo.getCodigo());
			ptst.execute();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(TipoVO tipo, TipoVO novoTipo) {
		conn = getConnection();
		TipoBO bo = new TipoBO();
		TipoVO t = bo.buscarID(tipo);
		PreparedStatement ptst;
		
		try {
			if (t != null) {
				String sql = "update tipos set nome_tipo = ?, forma_venda = ? where id_cargo = ?;";
				ptst = conn.prepareStatement(sql);
				ptst.setString(1, novoTipo.getNome());
				ptst.setString(1, novoTipo.getFormaDeVenda());
				ptst.setInt(2, tipo.getCodigo());
				ptst.execute();
				//conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarID(TipoVO tipo) {
		conn = getConnection();
		String sql = "select * from tipos where id_tipo = ?;";
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, tipo.getCodigo());
			rs = ptst.executeQuery();
			//conn.close();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet buscarNome(TipoVO tipo) {
		conn = getConnection();
		String sql = "select * from tipos where nome_tipo = ?;";
		
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, tipo.getNome());
			rs = ptst.executeQuery();
			//conn.close();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet listar() {
		conn = getConnection();
		String sql = "select * from tipos";
		
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//conn.close();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
