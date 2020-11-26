package Model.BO;

import java.util.ArrayList;

import Model.VO.ComprasVO;

public interface InterComprasBO {
	public void adicionar(ComprasVO compra);
	
	public void remover(ComprasVO compra);
	
	public void buscarID(ComprasVO compra);
	
	public void buscarGerenteNome(ComprasVO compra);
	
	public void buscarGerenteID(ComprasVO compra);
	
	public void buscarData(ComprasVO compra);
	
	public void editar(ComprasVO compra, ComprasVO novaCompra);
	
	public void listar(ArrayList<ComprasVO> compras);
}
