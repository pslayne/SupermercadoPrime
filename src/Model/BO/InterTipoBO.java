package Model.BO;

import java.util.List;

import Model.VO.TipoVO;

public interface InterTipoBO {
	public void adicionar(TipoVO tipo);
	
	public void remover(TipoVO tipo);
	
	public void editar(TipoVO tipo, TipoVO novoTipo);
	
	public TipoVO buscarID(TipoVO tipo);
	
	public List<TipoVO> buscarNome(TipoVO tipo);
	 
	public List<TipoVO> listar();
	
	public void mostrar(List<TipoVO> tipos);
}
