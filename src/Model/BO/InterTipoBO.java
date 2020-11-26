package Model.BO;

import java.util.ArrayList;

import Model.VO.TipoVO;

public interface InterTipoBO {
	public void adicionar(TipoVO tipo);
	
	public void remover(TipoVO tipo);
	
	public void editar(TipoVO tipo, TipoVO novoTipo);
	
	public void buscarID(TipoVO tipo);
	
	public void buscarNome(TipoVO tipo);
	 
	public void listar(ArrayList<TipoVO> tipos);
}
