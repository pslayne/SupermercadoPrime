package Model.VO;

public class CargoVO {
	private String nome;
	private int codigo;
	
    // getters e setters
	public String getNome() {
		if (nome == null)
			return "";
		else
			return nome;
	}
	
	public void setNome(String nome) {
		if (nome != null && !nome.isEmpty())
			this.nome = nome;
		else
			System.out.println("Nome inválido!");
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int cod) {
		codigo = cod;
	}
	
	public String toString(){
		String c = "Código: " + getCodigo() + "\nNome: " + getNome();
		return c;
	}
}
