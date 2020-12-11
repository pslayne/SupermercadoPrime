package Model.BO;

import java.util.List;

import Model.VO.ProdutosVO;

public interface InterProdutosBO {
	public void adicionar(ProdutosVO produto);
	
	public void remover(ProdutosVO produto);
	
	public ProdutosVO buscarID(ProdutosVO produto);
	
	public List<ProdutosVO> buscarNome(ProdutosVO produto);
	
	public List<ProdutosVO> buscarTipo(ProdutosVO produto);
	
	public List<ProdutosVO> buscarMarca(ProdutosVO produto);
	
	public void atualizar(List<ProdutosVO> produtos, String evento);
	
	public List<ProdutosVO> listar();
	 
	public void mostrar(List<ProdutosVO> produtos);
}
