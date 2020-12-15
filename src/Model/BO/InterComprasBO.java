package Model.BO;

import java.util.List;

import Model.VO.ComprasVO;

public interface InterComprasBO {
	public void adicionar(ComprasVO compra);
	
	public void remover(ComprasVO compra);
	
	public ComprasVO buscarID(ComprasVO compra);
	
	public List<ComprasVO> buscarGerenteNome(ComprasVO compra);
	
	public List<ComprasVO> buscarGerenteID(ComprasVO compra);
	
	public List<ComprasVO> buscarData(ComprasVO compra);
	
	public List<ComprasVO> listar();
	
	public void mostrar(List<ComprasVO> compras);
}
