package Model.VO;

public class TipoVO {
	
	private String nome;
	private String formaDeVenda;
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
	
	public String getFormaDeVenda() {
		if (formaDeVenda == null)
			return "";
		else
			return formaDeVenda;
	}
	
	public void setFormaDeVenda(String formaDeVenda) {
		if (formaDeVenda != null && !formaDeVenda.isEmpty())
			this.formaDeVenda = formaDeVenda;
		else System.out.println("Forma de venda inválida!");
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo (int cod) {
		codigo = cod;
	}
	
}
