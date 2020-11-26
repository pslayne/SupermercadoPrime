package Model.BO;

import java.util.ArrayList;
import java.util.Iterator;

import Model.DAO.CargoDAO;
import Model.VO.CargoVO;

public class CargoBO implements InterCargoBO{
	CargoDAO dao = new CargoDAO();

	public void adicionar(CargoVO cargo) {
		if(cargo != null) {
			ArrayList<CargoVO> resultado = dao.buscarNome(cargo);
			if(resultado.isEmpty()) 
				dao.inserir(cargo);
			else System.out.println("Este cargo já existe");
		} else System.out.println("Cargo inválido");
	}

	public void remover(CargoVO cargo) {
		if(cargo != null) {
			ArrayList<CargoVO> resultado = dao.buscarNome(cargo);
			if(!resultado.isEmpty()) 
				dao.remover(cargo);
			else System.out.println("Este cargo não existe");
		} else System.out.println("Cargo inválido");
	}

	public void editar(CargoVO cargo, CargoVO novoCargo) {
		if(cargo != null && novoCargo != null) {
			ArrayList<CargoVO> resultado = dao.buscarNome(cargo);
			if(!resultado.isEmpty()) 
				dao.atualizar(cargo, novoCargo);
			else System.out.println("Este cargo não existe");
		} else System.out.println("Cargo inválido");
	}

	public void buscar(CargoVO cargo) {
		listar(dao.buscarID(cargo));
	}

	public void buscarNome(CargoVO cargo) {
		listar(dao.buscarNome(cargo));
	}

	public void listar(ArrayList<CargoVO> cargos) {
		Iterator<CargoVO> iterator = cargos.iterator();
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
	}

}
