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
			else System.out.println("Este produto já existe");
		} else System.out.println("Produto inválido");
	}

	public void remover(ProdutosVO produto) {
		if(produto != null) {
			List<ProdutosVO> resultado = buscarNome(produto);
			if(!resultado.isEmpty()) 
				dao.remover(produto);
			else System.out.println("Este produto não existe");
		} else System.out.println("Produto inválido");
	}

	public ProdutosVO buscarID(ProdutosVO produto) {
		ResultSet rs = dao.buscarID(produto);
		
		try {
			if(rs.next()) {
				ProdutosVO p = new ProdutosVO();
				p.setCodigo(rs.getInt("cod_produto"));
				
				TipoVO t = new TipoVO();
				t.setCodigo((rs.getInt("id_tipo")));
				TipoBO tbo = new TipoBO();
				t = tbo.buscarID(t);
				
				p.setTipo(t);
				p.setNome(rs.getString("nome"));
				p.setMarca(rs.getString("marca"));
				p.setQuantidadeEstoque(rs.getInt("quantidade"));
				p.setPreco(rs.getDouble("preco"));
				
				return p;
			} else return null;
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
				
				p.setTipo(t);
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
				
				p.setTipo(t);
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
				
				p.setTipo(t);
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

	public void atualizar(List<ProdutosVO> produtos, String evento) {
		if(evento.equals("compra")) {
			Iterator<ProdutosVO> iterator = produtos.iterator();
			
			while (iterator.hasNext()) {
				ProdutosVO prod = iterator.next();
				ProdutosVO prodBD = buscarID(prod);
		
				if(prodBD != null) {
					prodBD.setQuantidadeEstoque(prodBD.getQuantidadeEstoque() + prod.getQuantidadePedido()); 
					dao.atualizar(prodBD, prodBD);
				}
			}
				
		} else if (evento.equals("venda")) {
			Iterator<ProdutosVO> iterator = produtos.iterator();
			
			while (iterator.hasNext()) {
				ProdutosVO prod = iterator.next();
				ProdutosVO prodBD = buscarID(prod);
		
				if(prodBD != null) {
					prodBD.setQuantidadeEstoque(prodBD.getQuantidadeEstoque() - prod.getQuantidadePedido()); 
					dao.atualizar(prodBD, prodBD);
				}
				}
			}
	}
	
	public void atualizar(ProdutosVO produto, ProdutosVO novoProduto) {
		if(produto != null && novoProduto != null)
			dao.atualizar(produto, novoProduto);
		else System.out.println("inválido");
	}
	
	public List<ProdutosVO> listar(){
		ResultSet rs = dao.listar();
		List<ProdutosVO> produtos = new ArrayList<ProdutosVO>();
		
		try {
			while(rs.next()) {
				ProdutosVO p = new ProdutosVO();
				p.setCodigo(rs.getInt("cod_produto"));
				
				TipoVO t = new TipoVO();
				t.setCodigo((rs.getInt("id_tipo")));
				TipoBO tbo = new TipoBO();
				t = tbo.buscarID(t);

				p.setTipo(t);
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
	
	public void mostrar(List<ProdutosVO> produtos) {
		Iterator<ProdutosVO> iterator = produtos.iterator();
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
	}
	
	
}
