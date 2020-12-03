package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import Model.DAO.ProdutosDAO;
import Model.VO.ProdutosVO;
import Model.VO.TipoVO;

public class ProdutosBO implements InterProdutosBO{
	ProdutosDAO dao = new ProdutosDAO();
	
	public void adicionar(ProdutosVO produto) {
		if(produto != null) {
			List<ProdutosVO> resultado = buscarNome(produto);
			if(resultado.isEmpty()) 
				dao.inserir(produto);
			else System.out.println("Este produto j� existe");
		} else System.out.println("Produto inv�lido");
	}

	public void remover(ProdutosVO produto) {
		if(produto != null) {
			List<ProdutosVO> resultado = buscarNome(produto);
			if(!resultado.isEmpty()) 
				dao.remover(produto);
			else System.out.println("Este produto n�o existe");
		} else System.out.println("Produto inv�lido");
	}

	public ArrayList<ProdutosVO> buscarID(ProdutosVO produto) {
		ResultSet rs = dao.buscarID(produto);
		ArrayList<ProdutosVO> produtos = new ArrayList<ProdutosVO>();
		
		try {
			while(rs.next()) {
				ProdutosVO p = new ProdutosVO();
				p.setCodigo(rs.getInt("cod_produto"));
				
				TipoVO t = new TipoVO();
				t.setCodigo((rs.getInt("id_tipo")));
				TipoBO tbo = new TipoBO();
				t = tbo.buscarID(t);
				
				p.setNome(rs.getString("nome"));
				p.setMarca(rs.getString("marca"));
				p.setQuantidadeEstoque(rs.getInt("quantidade"));
				p.setPreco(rs.getDouble("preco"));
				
				produtos.add(p);
			}
			return produtos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<ProdutosVO> buscarNome(ProdutosVO produto) {
		ResultSet rs = dao.buscarNome(produto);
		ArrayList<ProdutosVO> produtos = new ArrayList<ProdutosVO>();
		
		try {
			while(rs.next()) {
				ProdutosVO p = new ProdutosVO();
				p.setCodigo(rs.getInt("cod_produto"));
				
				TipoVO t = new TipoVO();
				t.setCodigo((rs.getInt("id_tipo")));
				TipoBO tbo = new TipoBO();
				t = tbo.buscarID(t);
				
				produtos.add(p);
			}
			return produtos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public List<ProdutosVO> buscarTipo(ProdutosVO produto) {
		ResultSet rs = dao.buscarTipo(produto);
		ArrayList<ProdutosVO> produtos = new ArrayList<ProdutosVO>();
		
		try {
			while(rs.next()) {
				ProdutosVO p = new ProdutosVO();
				p.setCodigo(rs.getInt("cod_produto"));
				
				TipoVO t = new TipoVO();
				t.setCodigo((rs.getInt("id_tipo")));
				TipoBO tbo = new TipoBO();
				t = tbo.buscarID(t);
				
				produtos.add(p);
			}
			return produtos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public List<ProdutosVO> buscarMarca(ProdutosVO produto) {
		ResultSet rs = dao.buscarMarca(produto);
		ArrayList<ProdutosVO> produtos = new ArrayList<ProdutosVO>();
		
		try {
			while(rs.next()) {
				ProdutosVO p = new ProdutosVO();
				p.setCodigo(rs.getInt("cod_produto"));
				
				TipoVO t = new TipoVO();
				t.setCodigo((rs.getInt("id_tipo")));
				TipoBO tbo = new TipoBO();
				t = tbo.buscarID(t);
				
				produtos.add(p);
			}
			return produtos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public void atualizar(List<ProdutosVO> produtos, String evento) {
		if(evento.equals("compra")) {
			Iterator<ProdutosVO> iterator = produtos.iterator();
			
			while (iterator.hasNext()) {
				ProdutosVO prod = iterator.next();
				ArrayList<ProdutosVO> resultado = buscarID(prod);
		
				if(!resultado.isEmpty()) {
					Iterator<ProdutosVO> r = resultado.iterator();
					ProdutosVO prodBD = r.next();
					prod.setQuantidadeEstoque(prodBD.getQuantidadeEstoque() + prod.getQuantidadePedido()); 
					dao.atualizar(prodBD, prod);
				}
			}
				
		} else if (evento.equals("venda")) {
			Iterator<ProdutosVO> iterator = produtos.iterator();
			
			while (iterator.hasNext()) {
				ProdutosVO prod = iterator.next();
				ArrayList<ProdutosVO> resultado = buscarID(prod);
		
				if(!resultado.isEmpty()) {
					Iterator<ProdutosVO> r = resultado.iterator();
					ProdutosVO prodBD = r.next();
					prod.setQuantidadeEstoque(prodBD.getQuantidadeEstoque() - prod.getQuantidadePedido()); 
					dao.atualizar(prodBD, prod);
				}
			}
		}
	}
	
	public List<ProdutosVO> listar(){
		ResultSet rs = dao.listar();
		ArrayList<ProdutosVO> produtos = new ArrayList<ProdutosVO>();
		
		try {
			while(rs.next()) {
				ProdutosVO p = new ProdutosVO();
				p.setCodigo(rs.getInt("cod_produto"));
				
				TipoVO t = new TipoVO();
				t.setCodigo((rs.getInt("id_tipo")));
				TipoBO tbo = new TipoBO();
				t = tbo.buscarID(t);
				
				produtos.add(p);
			}
			return produtos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void mostrar(List<ProdutosVO> produtos) {
		Iterator<ProdutosVO> iterator = produtos.iterator();
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
	}
	
	
}