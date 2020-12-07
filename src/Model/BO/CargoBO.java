package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import Model.DAO.CargoDAO;
import Model.VO.CargoVO;

public class CargoBO implements InterCargoBO{
	CargoDAO dao = new CargoDAO();

	public void adicionar(CargoVO cargo) {
		if(cargo != null) {
			List<CargoVO> resultado = buscarNome(cargo);
			if(resultado.isEmpty()) 
				dao.inserir(cargo);
			else System.out.println("Este cargo já existe");
		} else System.out.println("Cargo inválido");
	}

	public void remover(CargoVO cargo) {
		if(cargo != null) {
			CargoVO resultado = buscarID(cargo);
			
			if(resultado != null) 
				dao.remover(cargo);
			else System.out.println("Este cargo não existe");
		} else System.out.println("Cargo inválido");
	}

	public void editar(CargoVO cargo, CargoVO novoCargo) {
		if(cargo != null && novoCargo != null) {
			List<CargoVO> resultado = buscarNome(cargo);
			
			if(!resultado.isEmpty()) { 
				Iterator<CargoVO> it = resultado.iterator();
				CargoVO i = it.next();
				cargo.setCodigo(i.getCodigo());
				
				dao.atualizar(cargo, novoCargo);
			} else System.out.println("Este cargo não existe");
		} else System.out.println("Cargo inválido");
	}

	public CargoVO buscarID(CargoVO cargo) {
		ResultSet rs = dao.buscarID(cargo);
		CargoVO c = new CargoVO();
		try {
			if(rs.next()) {
				c.setCodigo((rs.getInt("id_cargo")));
				c.setNome(rs.getString("nome_cargo"));
				return c;
			} else return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public List<CargoVO> buscarNome(CargoVO cargo) {
		ResultSet rs = dao.buscarNome(cargo);
		List<CargoVO> cargos = new ArrayList<CargoVO>();
		
		try {
			while(rs.next()) {
				CargoVO c = new CargoVO();
				c.setCodigo((rs.getInt("id_cargo")));
				c.setNome(rs.getString("nome_cargo"));
				
				cargos.add(c);
			}
			return cargos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<CargoVO> listar() {
		ResultSet rs = dao.listar();
		ArrayList<CargoVO> cargos = new ArrayList<CargoVO>();
		
		try {
			while(rs.next()) {
				CargoVO c = new CargoVO();
				c.setCodigo((rs.getInt("id_cargo")));
				c.setNome(rs.getString("nome_cargo"));
				
				cargos.add(c);
			}
			return cargos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public void mostrar(List<CargoVO> cargos) {
		Iterator<CargoVO> iterator = cargos.iterator();
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
	}

}
