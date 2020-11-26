package Model.BO;

import java.util.ArrayList;

import Model.VO.VendasVO;

public interface InterVendasBO {
	public void adicionar(VendasVO venda);
	
	public void remover(VendasVO venda);
	
	public void buscarID(VendasVO venda);
	
	public void buscarCaixaNome(VendasVO venda);
	
	public void buscarCaixaID(VendasVO venda);
	
	public void buscarData(VendasVO venda);
	
	public void editar(VendasVO venda, VendasVO novaVenda);
	
	public void listar(ArrayList<VendasVO> venda);
}
