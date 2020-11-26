package Model.BO;

import java.util.ArrayList;
import java.util.Iterator;

import Model.DAO.TipoDAO;
import Model.VO.TipoVO;

public class TipoBO implements InterTipoBO{
	TipoDAO dao = new TipoDAO();

	public void adicionar(TipoVO tipo) {
		if(tipo != null) {
			ArrayList<TipoVO> resultado = dao.buscarNome(tipo);
			if(resultado.isEmpty()) 
				dao.inserir(tipo);
			else System.out.println("Este tipo j� existe");
		} else System.out.println("Tipo inv�lido");
	}

	public void remover(TipoVO tipo) {
		if(tipo != null) {
			TipoDAO dao = new TipoDAO();
			ArrayList<TipoVO> resultado = dao.buscarNome(tipo);
			if(!resultado.isEmpty()) 
				dao.remover(tipo);
			else System.out.println("Este tipo n�o existe");
		} else System.out.println("Tipo inv�lido");
	}
	
	public void editar(TipoVO tipo, TipoVO novoTipo) {
		if(tipo != null && novoTipo != null) {
			ArrayList<TipoVO> resultado = dao.buscarNome(tipo);
			if(!resultado.isEmpty()) 
				dao.atualizar(tipo, novoTipo);
			else System.out.println("Este cargo n�o existe");
		} else System.out.println("Cargo inv�lido");
	}
	
	public void buscarID(TipoVO tipo) {
		listar(dao.buscarID(tipo));
	}

	public void buscarNome(TipoVO tipo) {
		listar(dao.buscarNome(tipo));
	}

	public void listar(ArrayList<TipoVO> tipos) {
		Iterator<TipoVO> iterator = tipos.iterator();
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
	}

}
