package Model.DAO;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

import Model.VO.ComprasVO;
import Model.VO.ProdutosVO;

public class ComprasDAO extends BaseDAO {
	public void inserir(ComprasVO compra) {
		conn = getConnection();
		String sql = "insert into compras(id_compra, cod_produto, quant_produtos, valor, datacompra, hora, id_func) values(?, ?, ?, ?, ?, ?, ?);";
		try {
			List<ProdutosVO> produtos = compra.getProdutos();
			Iterator<ProdutosVO> iterator = produtos.iterator();
			while(iterator.hasNext()) {
				ProdutosVO p = iterator.next();
				
				PreparedStatement ptst = conn.prepareStatement(sql);
				
				ptst.setInt(1, compra.getCodigo());
				ptst.setInt(2, p.getCodigo());
				ptst.setFloat(3, p.getQuantidadePedido());
				ptst.setDouble(4, p.getQuantidadePedido()*p.getPreco());
				ptst.setDate(5, new Date(compra.getData().getTimeInMillis()));
				ptst.setTime(6, new Time(compra.getHora().getTimeInMillis()));
				ptst.setInt(7, compra.getGerente().getCodigo());
				
				ptst.execute();
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(ComprasVO compra) {
		conn = getConnection();
		String sql = "delete from compras where id_compra = ?;";
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setInt(1, compra.getCodigo());
			ptst.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarData(ComprasVO compra) {
		conn = getConnection();
		String sql = "select * from compras where datacompra = ?";
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setDate(1, new Date(compra.getData().getTimeInMillis()));
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
		String sql = "select * from compras";
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
