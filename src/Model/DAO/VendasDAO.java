package Model.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import Model.BO.VendasBO;
import Model.VO.ProdutosVO;
import Model.VO.VendasVO;

public class VendasDAO extends BaseDAO {
	VendasBO bo = new VendasBO();
	
	public void inserir(VendasVO venda) {
		conn = getConnection();
		String sql = "insert into vendas(id_venda, cod_produto, quant_produtos, valor, datavenda, hora, id_func) values(?, ?, ?, ?, ?, ?, ?);";
		try {
			ArrayList<ProdutosVO> produtos = venda.getProdutos();
			Iterator<ProdutosVO> iterator = produtos.iterator();
			List<VendasVO> lista = bo.listar();
			int id = lista.get(lista.size() - 1).getCodigo(); 
			while(iterator.hasNext()) {
				ProdutosVO p = iterator.next();
				
				PreparedStatement ptst = conn.prepareStatement(sql);
				
				ptst.setInt(1, id + 1);
				ptst.setInt(2, p.getCodigo());
				ptst.setFloat(3, p.getQuantidadePedido());
				ptst.setDouble(4, p.getQuantidadePedido()*p.getPreco());
				ptst.setDate(5, new Date(venda.getData().getTimeInMillis()));
				ptst.setTime(6, new Time(venda.getHora().getTimeInMillis()));
				ptst.setInt(7, venda.getCaixa().getCodigo());
				
				ptst.execute();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(VendasVO venda) {
		conn = getConnection();
		String sql = "delete from vendas where id_venda = ?;";
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setInt(1, venda.getCodigo());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarData(VendasVO venda) {
		conn = getConnection();
		String sql = "select * from vendas where datavenda = ?";
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setDate(1, new Date(venda.getData().getTimeInMillis()));
			rs = ptst.executeQuery();
			return rs;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet listar(){
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
