package Model.BO;

import Model.VO.TipoVO;

public class TipoBO {
	TipoVO tipo = new TipoVO();
	
	public static void adicionar(TipoVO tipo) {
		//verifica no banco se já existe, se não, adiciona um novo tipo
	}
	
	public static void remover(TipoVO tipo) {
		//verifica se o ttpo existe, se sim, remove o tipo
	}
	
	public static void editar(TipoVO tipo) {
		//verifica se o ttpo existe, se sim, edita o tipo
	}
	
	public static void buscar(TipoVO tipo) {
		//faz a busca no banco
	}
	
	public void listar() {
		//lista os tipos que resultaram da busca
	}
}
