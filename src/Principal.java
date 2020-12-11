import Model.VO.*;

import java.util.ArrayList;
import java.util.List;

import Model.BO.*;
import Model.DAO.*;

public class Principal {
	public static void main(String args[]) {
		VendasBO bo = new VendasBO();
		VendasVO vo = new VendasVO();
		vo.setData();
		FuncionariosVO fvo = new FuncionariosVO();
		fvo.setCodigo(3);
		vo.setCaixa(fvo);
		vo.setData();
		vo.setHora();
		
		ProdutosVO pvo = new ProdutosVO();
		List<ProdutosVO> produtos = new ArrayList<ProdutosVO>();
		pvo.setCodigo(4);
		pvo.setQuantidadePedido(2);
		produtos.add(pvo);
		
		ProdutosVO p1vo = new ProdutosVO();
		p1vo.setCodigo(3);
		p1vo.setQuantidadePedido(3);
		produtos.add(p1vo);
		
		vo.setProdutos(produtos);
		
		bo.adicionar(vo);
		//bo.mostrar(bo.buscaCaixaData(vo));
		//bo.mostrar(bo.listar());
	}
}
