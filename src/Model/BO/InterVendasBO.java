package Model.BO;

import java.util.List;

import Model.VO.VendasVO;

public interface InterVendasBO {
	public void adicionar(VendasVO venda);
	
	public void remover(VendasVO venda);
	
	public VendasVO buscarID(VendasVO venda);
	
	public List<VendasVO> buscarCaixaNome(VendasVO venda);

	public List<VendasVO> buscarCaixaID(VendasVO venda);
	
	public List<VendasVO> buscarData(VendasVO venda);
	
	public List<VendasVO> listar();
	
	public void mostrar(List<VendasVO> venda);
}
