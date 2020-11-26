package Model.BO;

import java.util.ArrayList;
import java.util.Iterator;
import Model.DAO.ProdutosDAO;
import Model.VO.ProdutosVO;

public class ProdutosBO implements InterProdutosBO{
	ProdutosDAO dao = new ProdutosDAO();
	
	public void adicionar(ProdutosVO produto) {
		if(produto != null) {
			ArrayList<ProdutosVO> resultado = dao.buscarNome(produto);
			if(resultado.isEmpty()) 
				dao.inserir(produto);
			else System.out.println("Este produto já existe");
		} else System.out.println("Produto inválido");
	}

	public void remover(ProdutosVO produto) {
		if(produto != null) {
			ArrayList<ProdutosVO> resultado = dao.buscarNome(produto);
			if(!resultado.isEmpty()) 
				dao.remover(produto);
			else System.out.println("Este produto não existe");
		} else System.out.println("Produto inválido");
	}

	public void buscarID(ProdutosVO produto) {
		listar(dao.buscarID(produto));
	}

	public void buscarTipo(ProdutosVO produto) {
		listar(dao.buscarTipo(produto));
	}

	public void buscarMarca(ProdutosVO produto) {
		listar(dao.buscarMarca(produto));
	}

	public void atualizar(ArrayList<ProdutosVO> produtos, String evento) {
		if(evento.equals("compra")) {
			Iterator<ProdutosVO> iterator = produtos.iterator();
			
			while (iterator.hasNext()) {
				ProdutosVO prod = iterator.next();
				ArrayList<ProdutosVO> resultado = dao.buscarID(prod);
		
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
				ArrayList<ProdutosVO> resultado = dao.buscarID(prod);
		
				if(!resultado.isEmpty()) {
					Iterator<ProdutosVO> r = resultado.iterator();
					ProdutosVO prodBD = r.next();
					prod.setQuantidadeEstoque(prodBD.getQuantidadeEstoque() - prod.getQuantidadePedido()); 
					dao.atualizar(prodBD, prod);
				}
			}
		}
	}

	public void listar(ArrayList<ProdutosVO> produtos) {
		Iterator<ProdutosVO> iterator = produtos.iterator();
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
	}
	
	
}
