package Model.BO;

import java.util.ArrayList;

import Model.VO.CargoVO;

public interface InterCargoBO {
	public void adicionar(CargoVO cargo);

	public void remover(CargoVO cargo);

	public void editar(CargoVO cargo, CargoVO novoCargo);

	public void buscar(CargoVO cargo);

	public void buscarNome(CargoVO cargo);

	public void listar(ArrayList<CargoVO> resultadoBusca);
}
