package Model.BO;

import java.util.ArrayList;
import java.util.Iterator;
import Model.DAO.VendasDAO;
import Model.VO.VendasVO;

public class VendasBO implements InterVendasBO{
	VendasDAO dao = new VendasDAO();
	
	public void adicionar(VendasVO venda) {
		if(venda != null) {
			ArrayList<VendasVO> resultado = dao.buscarID(venda);
			if(resultado.isEmpty()) {
				dao.inserir(venda);
				ProdutosBO estoque = new ProdutosBO();
				estoque.atualizar(venda.getProdutos(), "venda");
			} else System.out.println("Esta venda já existe");
		} else System.out.println("Venda inválida");
	}

	public void remover(VendasVO venda) {
		if(venda != null) {
			ArrayList<VendasVO> resultado = dao.buscarID(venda);
			if(!resultado.isEmpty()) {
				dao.remover(venda);
			} else System.out.println("Esta venda não existe");
		} else System.out.println("Venda inválida");
	}

	public void buscarID(VendasVO venda) {
		listar(dao.buscarID(venda));
	}

	public void buscarCaixaNome(VendasVO venda) {
		listar(dao.buscarCaixaNome(venda));
	}

	public void buscarCaixaID(VendasVO venda) {
		listar(dao.buscarCaixaID(venda));
	}

	public void buscarData(VendasVO venda) {
		listar(dao.buscarData(venda));
	}

	public void editar(VendasVO venda, VendasVO novaVenda) {
		if(venda != null && novaVenda != null) {
			ArrayList<VendasVO> resultado = dao.buscarID(venda);
			if(!resultado.isEmpty()) 
				dao.atualizar(venda, novaVenda);
			else System.out.println("Esta venda não existe");
		} else System.out.println("Venda inválida");
	}

	public void listar(ArrayList<VendasVO> vendas) {
		Iterator<VendasVO> iterator = vendas.iterator();
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
	}
	

}
