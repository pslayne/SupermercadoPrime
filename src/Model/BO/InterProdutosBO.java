package Model.BO;

import java.util.ArrayList;

import Model.VO.ProdutosVO;

public interface InterProdutosBO {
	public void adicionar(ProdutosVO produto);
	
	public void remover(ProdutosVO produto);
	
	public void buscarID(ProdutosVO produto);
	
	public void buscarTipo(ProdutosVO produto);
	
	public void buscarMarca(ProdutosVO produto);
	
	public void atualizar(ArrayList<ProdutosVO> produtos, String evento);
	 
	public void listar(ArrayList<ProdutosVO> produtos);
}
