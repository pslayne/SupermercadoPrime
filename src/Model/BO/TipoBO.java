package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import Model.DAO.TipoDAO;
import Model.VO.TipoVO;

public class TipoBO implements InterTipoBO{
	TipoDAO dao = new TipoDAO();

	public void adicionar(TipoVO tipo) {
		if(tipo != null) {
			List<TipoVO> resultado = buscarNome(tipo);
			if(resultado.isEmpty()) 
				dao.inserir(tipo);
			else System.out.println("Este tipo já existe");
		} else System.out.println("Tipo inválido");
	}

	public void remover(TipoVO tipo) {
		if(tipo != null) {
			TipoDAO dao = new TipoDAO();
			List<TipoVO> resultado = buscarNome(tipo);
			if(!resultado.isEmpty()) 
				dao.remover(tipo);
			else System.out.println("Este tipo não existe");
		} else System.out.println("Tipo inválido");
	}
	
	public void editar(TipoVO tipo, TipoVO novoTipo) {
		if(tipo != null && novoTipo != null) {
			List<TipoVO> resultado = buscarNome(tipo);
			if(!resultado.isEmpty()) 
				dao.atualizar(tipo, novoTipo);
			else System.out.println("Este cargo não existe");
		} else System.out.println("Cargo inválido");
	}
	
	public TipoVO buscarID(TipoVO tipo) {
		ResultSet rs = dao.buscarID(tipo);
		TipoVO t = new TipoVO();
		
		try {
			if(rs.next()) {
				t.setCodigo((rs.getInt("id_tipo")));
				t.setNome(rs.getString("nome_tipo"));
				t.setFormaDeVenda(rs.getString("forma_venda"));
				return t;
			}else return null;	
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	
	}

	public List<TipoVO> buscarNome(TipoVO tipo) {
		ResultSet rs = dao.buscarNome(tipo);
		ArrayList<TipoVO> tipos = new ArrayList<TipoVO>();
		
		try {
			while(rs.next()) {
				TipoVO t = new TipoVO();
				t.setCodigo((rs.getInt("id_tipo")));
				t.setNome(rs.getString("nome_tipo"));
				t.setFormaDeVenda(rs.getString("forma_venda"));
				tipos.add(t);
			}
			return tipos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<TipoVO> listar(){
		ResultSet rs = dao.listar();
		ArrayList<TipoVO> tipos = new ArrayList<TipoVO>();
		
		try {
			while(rs.next()) {
				TipoVO t = new TipoVO();
				t.setCodigo((rs.getInt("id_tipo")));
				t.setNome(rs.getString("nome_tipo"));
				t.setFormaDeVenda(rs.getString("forma_venda"));
				tipos.add(t);
			}
			return tipos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void mostrar(List<TipoVO> tipos) {
		Iterator<TipoVO> iterator = tipos.iterator();
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
	}

}
