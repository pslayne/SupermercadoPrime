package Model.VO;

public class Tipo {

	private String nome;
	private String formaDeVenda;
	private int codigo;

    // getters e setters
    
	public String getNome() {
		if (nome == null)
			return "";
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome != null && !nome.isEmpty()) { 
			this.nome = nome;
		} else {
			System.out.println("Nome inválido!");
		}
	}
	
	public String getFormaDeVenda() {
		if (formaDeVenda == null)
			return "";
		return formaDeVenda;
	}
	
	public void setFormaDeVenda(String formaDeVenda) {
		if (formaDeVenda != null && !formaDeVenda.isEmpty()) {
			this.formaDeVenda = formaDeVenda;
		}
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		if(codigo > 0)
		    this.codigo = codigo;
		else
			System.out.println("Código inválido");
	}
	
}
