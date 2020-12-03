package Model.BO;

import java.util.List;

import Model.VO.CargoVO;

public interface InterCargoBO {
	public void adicionar(CargoVO cargo);

	public void remover(CargoVO cargo);

	public void editar(CargoVO cargo, CargoVO novoCargo);

	public CargoVO buscarID(CargoVO cargo);

	public List<CargoVO> buscarNome(CargoVO cargo);
	
	public List<CargoVO> listar();

	public void mostrar(List<CargoVO> resultadoBusca);
}
