package Model.BO;

import Model.VO.CaixaVO;
import Model.VO.VendasVO;

public class CaixaBO extends FuncionariosBO{
	CaixaVO caixa = new CaixaVO();
	
	public void adicionar(CaixaVO caixa) {
		//chama o adicionar da super e acrescenta o cargo
	}
	
	public void editar(CaixaVO caixa) {
		//chama o editar da super e acrescenta a atualização do cargo 
	}
	
	public static void buscar(CaixaVO caixa) {
		//busca entre os caixa no banco de dados
	}
	
	public static void listar() {
		//lista todos os caixas que resultaram da busca
	}
	
	public static void realizarVenda(VendasVO venda) {
		VendasBO.adicionar(venda);
	}
}
