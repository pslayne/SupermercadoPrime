package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.VO.ProdutosVO;

public class ProdutosDAO extends BaseDAO {
	public void inserir(ProdutosVO produto) {
		conn = getConnection();
		String sql = "insert into produtos(id_tipo, nome, marca, quantidade, preco) values(?, ?, ?, ?, ?);";
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setInt(1, produto.getTipo().getCodigo());
			ptst.setString(2, produto.getNome());
			ptst.setString(3, produto.getMarca());
			ptst.setInt(4, produto.getQuantidadeEstoque());
			ptst.setDouble(5, produto.getPreco());
			
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(ProdutosVO produto) {
		conn = getConnection();
		String sql = "delete from produtos where cod_produto = ?";
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setInt(1, produto.getCodigo());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(ProdutosVO produto, ProdutosVO novoProduto) {
		conn = getConnection();
		String sql = "update produtos set id_tipo = ?, nome = ?, marca = ?, quantidade = ?, preco = ? where cod_produto = ?";
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setInt(1, novoProduto.getTipo().getCodigo());
			ptst.setString(2, novoProduto.getNome());
			ptst.setString(3, novoProduto.getMarca());
			ptst.setInt(4, novoProduto.getQuantidadeEstoque());
			ptst.setDouble(5, novoProduto.getPreco());
			ptst.setInt(1, produto.getCodigo());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarID(ProdutosVO produto) {
		conn = getConnection();
		String sql = "select * from produtos where cod_produto = ?";
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, produto.getCodigo());
			rs = ptst.executeQuery();
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarNome(ProdutosVO produto) {
		conn = getConnection();
		String sql = "select * from produtos where nome = ?";
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, produto.getNome());
			rs = ptst.executeQuery();
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarTipo(ProdutosVO produto) {
		conn = getConnection();
		String sql = "select * from produtos where id_tipo = ?";
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, produto.getTipo().getCodigo());
			rs = ptst.executeQuery();
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarMarca(ProdutosVO produto) {
		conn = getConnection();
		String sql = "select * from produtos where marca = ?";
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, produto.getMarca());
			rs = ptst.executeQuery();
			return rs;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet listar() {
		conn = getConnection();
		String sql = "select * from produtos";
		
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
