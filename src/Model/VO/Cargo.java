package Model.VO;

public class Cargo {
	private String nome;
	private int codigo;
	
    // getters e setters
    
	public String getNome() {
		if (nome == null)
			return "";
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
	
	public void setCodigo(int codigo) {
		if (codigo > 0 )
			this.codigo = codigo;
		else 
			System.out.println("Código inválido!");
	}
}
