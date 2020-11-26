package Model.BO;

import java.util.ArrayList;
import java.util.Iterator;

import Model.DAO.ComprasDAO;
import Model.VO.ComprasVO;

public class ComprasBO implements InterComprasBO{
	ComprasDAO dao = new ComprasDAO();
	
	public void adicionar(ComprasVO compra) {
		if(compra != null) {
			ArrayList<ComprasVO> resultado = dao.buscarID(compra);
			if(resultado.isEmpty()) {
				dao.inserir(compra);
				ProdutosBO estoque = new ProdutosBO();
				estoque.atualizar(compra.getProdutos(), "compra");
			} else System.out.println("Esta compra já existe");
		} else System.out.println("Compra inválida");
	}
	
	public void remover(ComprasVO compra) {
		if(compra != null) {
			ArrayList<ComprasVO> resultado = dao.buscarID(compra);
			if(!resultado.isEmpty()) 
				dao.remover(compra);
			else System.out.println("Este cargo não existe");
		} else System.out.println("Compra inválida");
	}
	
	public void editar(ComprasVO compra, ComprasVO novaCompra) {
		if(compra != null && novaCompra != null) {
			ArrayList<ComprasVO> resultado = dao.buscarID(compra);
			if(!resultado.isEmpty()) 
				dao.atualizar(compra, novaCompra);
			else System.out.println("Esta compra não existe");
		} else System.out.println("Compra inválida");
	}
	
	public void buscarID(ComprasVO compra) {
		listar(dao.buscarID(compra));
	}
	
	public void buscarGerenteNome(ComprasVO compra){
		listar(dao.buscarGerenteNome(compra));
	}
	
	public void buscarGerenteID(ComprasVO compra){
		listar(dao.buscarGerenteID(compra));
	}
	
	public void buscarData(ComprasVO compra){
		listar (dao.buscarData(compra));
	}
	
	public void listar(ArrayList<ComprasVO> compras) {
		Iterator<ComprasVO> iterator = compras.iterator();
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
	}

}
