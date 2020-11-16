package Model.BO;

import Model.VO.VendasVO;

public class VendasBO {
	VendasVO venda = new VendasVO();
	
	public static void adicionar(VendasVO venda) {
		//adiciona um registro de venda e atualiza o estoque
	}
	
	public static void cancelar(VendasVO venda) {
		//cancela a venda
	}
	
	public static void editar(VendasVO venda) {
		//verifica se o resgistro existe, se sim, edita e atualiza o estoque
	}
	
	public static void buscar(VendasVO venda) {
		//busca no banco pelas vendas
	}
	
	public static void listar() {
		//lista as vendas resultantes da busca
	}
	
	public static void gerarNota(VendasVO venda) {
		//gera a nota da venda 
	}
}
