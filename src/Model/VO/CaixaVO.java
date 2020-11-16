package Model.VO;

public class CaixaVO extends FuncionariosVO{
	CargoVO cargo;
	
	public CargoVO getCargo() {
		return cargo;
	}
	
	public void setCargo(CargoVO cargo) {
		if (cargo != null)
			this.cargo = cargo;
		else 
			System.out.println("Cargo inválido");
	}
}
