package Model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import Model.BO.ComprasBO;
import Model.VO.ComprasVO;
import Model.VO.ProdutosVO;

public class ComprasDAO extends BaseDAO {
	ComprasBO bo = new ComprasBO();
	public void inserir(ComprasVO compra) {
		conn = getConnection();
		String sql = "insert into compras(id_compra, cod_produto, quant_produtos, valor, datacompra, hora, id_func) values(?, ?, ?, ?, ?, ?, ?);";
		try {
			ArrayList<ProdutosVO> produtos = compra.getProdutos();
			Iterator<ProdutosVO> iterator = produtos.iterator();
			List<ComprasVO> lista = bo.listar();
			int id = lista.get(lista.size() - 1).getCodigo(); 
			while(iterator.hasNext()) {
				ProdutosVO p = iterator.next();
				
				PreparedStatement ptst = conn.prepareStatement(sql);
				
				ptst.setInt(1, id + 1);
				ptst.setInt(2, p.getCodigo());
				ptst.setFloat(3, p.getQuantidadePedido());
				ptst.setDouble(4, p.getQuantidadePedido()*p.getPreco());
				ptst.setDate(5, new Date(compra.getData().getTimeInMillis()));
				ptst.setTime(6, new Time(compra.getHora().getTimeInMillis()));
				ptst.setInt(7, compra.getGerente().getCodigo());
				
				ptst.execute();
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
			return rs;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
