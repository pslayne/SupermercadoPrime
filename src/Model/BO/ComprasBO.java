package Model.BO;

import Model.VO.ComprasVO;

public class ComprasBO {
	ComprasVO compra = new ComprasVO(); 
	
	public static void adicionar(ComprasVO compra) {
		//adiciona um registro de compra e atualiza o estoque
	}
	
	public static void cancelar(ComprasVO compra) {
		//cancela uma compra
	}
	
	public static void editar(ComprasVO compra) {
		//verifica se o registro existe, se sim, edita e atualiza o estoque
	}
	
	public static void buscar(ComprasVO compra) {
		//realiza uma busca no banco de dados
	}
	
	public static void listar() {
		//lista as compras resultantes da busca
	}
}
