package Model.BO;

import Model.VO.ProdutosVO;

public class ProdutosBO {
	ProdutosVO produto = new ProdutosVO();
	
	public static void adicionar(ProdutosVO produto) {
		//verifica no banco se o produto j� existe se sim, informa ao usu�rio que
		//este produto j� existe e pergunta se ele deseja alter�-lo, se n�o adiciona um novo produto
	}
	
	public static void remover(ProdutosVO produto) {
		//verifica se o produto existe, se sim o remove
	}
	
	public static void buscarTipo(ProdutosVO produto) {
		//faz um busca pelo tipo do produto no banco de dados
	}
	
	public static void buscarMarca(ProdutosVO produto) {
		//faz um busca pela marca do produto no banco de dados
	}
	
	public static void listar() {
		//lista os produtos que resultam da busca
	}
}
